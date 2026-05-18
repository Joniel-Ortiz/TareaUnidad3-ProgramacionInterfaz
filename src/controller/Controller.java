package controller;

import model.IdiomaManager;
import model.Persona;
import model.PersonaDAO;
import view.MenuPrincipal;
import view.MenuAgregar;
import view.MenuDatos;
import view.MenuEdicion;
import view.MenuConfig;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Controller implements ActionListener, MouseListener {

    MenuAgregar menuAgregar;
    MenuPrincipal menuPrincipal;
    MenuDatos menuDatos;
    MenuEdicion menuEdicion;
    MenuConfig menuConfig;
    Persona persona;
    PersonaDAO personaDAO;

    DefaultListModel<Persona> listModel = new DefaultListModel<>();
    DefaultListModel<Persona> listModelFav = new DefaultListModel<>();
    ArrayList<Persona> todasLasPersonas = new ArrayList<>();
    JList<Persona> listaEnUso;

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final ReentrantLock lockContactos = new ReentrantLock();

    public Controller(MenuAgregar menuAgregar, Persona persona, MenuPrincipal menuPrincipal,
                      MenuDatos menuDatos, MenuEdicion menuEdicion, MenuConfig menuConfig) {

        this.personaDAO = new PersonaDAO();
        this.menuPrincipal = menuPrincipal;
        this.menuAgregar = menuAgregar;
        this.persona = persona;
        this.menuDatos = menuDatos;
        this.menuEdicion = menuEdicion;
        this.menuConfig = menuConfig;

        this.menuPrincipal.btnAgg.addActionListener(this);
        this.menuPrincipal.btnExportar.addActionListener(this);
        this.menuPrincipal.btnImportar.addActionListener(this);
        this.menuPrincipal.btnConfig.addActionListener(this);
        this.menuAgregar.btnRegresar.addActionListener(this);
        this.menuAgregar.btnGuardar.addActionListener(this);
        this.menuAgregar.btnAmigo.addActionListener(this);
        this.menuAgregar.btnFamilia.addActionListener(this);
        this.menuAgregar.btnTrabajo.addActionListener(this);
        this.menuPrincipal.lstAllContacts.addMouseListener(this);
        this.menuPrincipal.lstFavContacts.addMouseListener(this);
        this.menuDatos.btnRegresar.addActionListener(this);
        this.menuDatos.btnEliminar.addActionListener(this);
        this.menuDatos.btnLllamar.addActionListener(this);
        this.menuDatos.btnEditar.addActionListener(this);
        this.menuEdicion.btnGuardar.addActionListener(this);
        this.menuEdicion.btnRegresar.addActionListener(this);
        this.menuEdicion.btnAmigo.addActionListener(this);
        this.menuEdicion.btnFamilia.addActionListener(this);
        this.menuEdicion.btnTrabajo.addActionListener(this);
        this.menuConfig.btnRegresar.addActionListener(this);

        menuConfig.cmbIdiomas.addActionListener(e -> {
            switch (menuConfig.cmbIdiomas.getSelectedIndex()) {
                case 0 -> cambiarIdioma("es");
                case 1 -> cambiarIdioma("en");
                case 2 -> cambiarIdioma("fr");
            }
        });

        menuPrincipal.lstAllContacts.setModel(listModel);
        menuPrincipal.lstFavContacts.setModel(listModelFav);

        menuPrincipal.cmpBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarContactoEnSegundoPlano(menuPrincipal.cmpBusqueda.getText());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarContactoEnSegundoPlano(menuPrincipal.cmpBusqueda.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuPrincipal.btnAgg) {
            menuPrincipal.setVisible(false);
            menuAgregar.setVisible(true);
        }
        if (e.getSource() == menuPrincipal.btnConfig) {
            menuPrincipal.setVisible(false);
            menuConfig.setVisible(true);
        }
        if (e.getSource() == menuPrincipal.btnExportar) {
            exportarContactoConcurrente();
        }
        if (e.getSource() == menuPrincipal.btnImportar) {
            importarContacto();
        }
        if (e.getSource() == menuDatos.btnRegresar) {
            menuPrincipal.setVisible(true);
            menuDatos.setVisible(false);
        }
        if (e.getSource() == menuDatos.btnEliminar) {
            eliminarContacto(listaEnUso);
        }
        if (e.getSource() == menuDatos.btnLllamar) {
            JOptionPane.showMessageDialog(menuDatos, menuDatos.llamandoContacto());
        }
        if (e.getSource() == menuAgregar.btnRegresar) {
            menuPrincipal.setVisible(true);
            menuAgregar.setVisible(false);
        }
        if (e.getSource() == menuAgregar.btnGuardar) {
            agregarContacto();
        }
        if (e.getSource() == menuDatos.btnEditar) {
            editarContacto();
        }
        if (e.getSource() == menuEdicion.btnGuardar) {
            actualizarContactoConcurrente();
        }
        if (e.getSource() == menuEdicion.btnRegresar) {
            menuDatos.setVisible(true);
            menuEdicion.setVisible(false);
        }
        if (e.getSource() == menuConfig.btnRegresar) {
            menuPrincipal.setVisible(true);
            menuConfig.setVisible(false);
        }
    }

    public void agregarContacto() {
        String nombre = menuAgregar.cmpNombre.getText().trim();
        String telefono = menuAgregar.cmpTelefono.getText().trim();
        String email = menuAgregar.cmpEmail.getText().trim();
        boolean favorito = menuAgregar.chkFavorito.isSelected();
        String categoria = "";

        if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(menuAgregar, menuAgregar.completarCampos());
            return;
        }

        if (menuAgregar.btnAmigo.isSelected()) {
            categoria = "Amigo";
        } else if (menuAgregar.btnFamilia.isSelected()) {
            categoria = "Familia";
        } else if (menuAgregar.btnTrabajo.isSelected()) {
            categoria = "Trabajo";
        }

        final String catFinal = categoria;
        menuAgregar.btnGuardar.setEnabled(false);
        validarContactoEnSegundoPlano(nombre, telefono, email, catFinal, favorito);
    }

    private void validarContactoEnSegundoPlano(String nombre, String telefono,
                                                String email, String categoria, boolean favorito) {
        long inicioSinThread = System.nanoTime();
        boolean duplicadoSinThread = false;
        for (Persona p : todasLasPersonas) {
            if (p.getNombre().equals(nombre) && p.getTelefono().equals(telefono) && p.getEmail().equals(email)) {
                duplicadoSinThread = true;
                break;
            }
        }
        long finSinThread = System.nanoTime();
        System.out.println("[SIN THREAD] Validacion duplicado: " + (finSinThread - inicioSinThread) + " ns | Duplicado: " + duplicadoSinThread);
        System.out.flush();

        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() {
                long inicio = System.nanoTime();
                boolean esDuplicado = false;
                lockContactos.lock();
                try {
                    for (Persona p : todasLasPersonas) {
                        if (p.getNombre().equals(nombre) &&
                                p.getTelefono().equals(telefono) &&
                                p.getEmail().equals(email)) {
                            esDuplicado = true;
                            break;
                        }
                    }
                } finally {
                    lockContactos.unlock();
                }
                long fin = System.nanoTime();
                System.out.println("[CON THREAD SwingWorker] Validacion duplicado: " + (fin - inicio) + " ns | Duplicado: " + esDuplicado);
                return esDuplicado;
            }

            @Override
            protected void done() {
                menuAgregar.btnGuardar.setEnabled(true);
                try {
                    boolean esDuplicado = get();
                    if (esDuplicado) {
                        JOptionPane.showMessageDialog(menuAgregar, menuAgregar.contactoExistente());
                        return;
                    }
                    Persona nueva = new Persona(nombre, telefono, email, categoria, favorito);
                    lockContactos.lock();
                    try {
                        todasLasPersonas.add(nueva);
                    } finally {
                        lockContactos.unlock();
                    }
                    SwingUtilities.invokeLater(() -> {
                        listModel.addElement(nueva);
                        if (favorito) listModelFav.addElement(nueva);
                        mostrarNotificacion("Contacto guardado con exito");
                        menuAgregar.limpiarCampos();
                        menuAgregar.setVisible(false);
                        menuPrincipal.setVisible(true);
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    public void buscarContactoEnSegundoPlano(String textoBusqueda) {
        long inicioSinThread = System.nanoTime();
        List<Persona> resultadosSin = new ArrayList<>();
        String textoSin = textoBusqueda.toLowerCase();
        for (Persona p : todasLasPersonas) {
            if (p.getNombre().toLowerCase().contains(textoSin)) {
                resultadosSin.add(p);
            }
        }
        long finSinThread = System.nanoTime();
        System.out.println("[SIN THREAD] Busqueda: " + (finSinThread - inicioSinThread) + " ns | Resultados: " + resultadosSin.size());
        System.out.flush();

        SwingWorker<List<Persona>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<Persona> doInBackground() {
                long inicio = System.nanoTime();
                List<Persona> resultados = new ArrayList<>();
                String busqueda = textoBusqueda.toLowerCase();
                lockContactos.lock();
                try {
                    for (Persona p : todasLasPersonas) {
                        if (p.getNombre().toLowerCase().contains(busqueda)) {
                            resultados.add(p);
                        }
                    }
                } finally {
                    lockContactos.unlock();
                }
                long fin = System.nanoTime();
                System.out.println("[CON THREAD SwingWorker] Busqueda: " + (fin - inicio) + " ns | Resultados: " + resultados.size());
                return resultados;
            }

            @Override
            protected void done() {
                try {
                    List<Persona> resultados = get();
                    SwingUtilities.invokeLater(() -> {
                        listModel.clear();
                        listModelFav.clear();
                        for (Persona p : resultados) {
                            listModel.addElement(p);
                            if (p.isFavorito()) listModelFav.addElement(p);
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    public void exportarContactoConcurrente() {
        long inicioSinThread = System.nanoTime();
        boolean exitoSinThread = personaDAO.actualizarContactos(new ArrayList<>(todasLasPersonas));
        long finSinThread = System.nanoTime();
        System.out.println("[SIN THREAD] Exportacion: " + (finSinThread - inicioSinThread) + " ns | Exito: " + exitoSinThread);
        System.out.flush();

        executor.submit(() -> {
            long inicio = System.nanoTime();
            lockContactos.lock();
            List<Persona> copia;
            try {
                copia = new ArrayList<>(todasLasPersonas);
            } finally {
                lockContactos.unlock();
            }
            boolean exito = personaDAO.actualizarContactosSincronizado(copia);
            long fin = System.nanoTime();
            System.out.println("[CON THREAD ExecutorService] Exportacion: " + (fin - inicio) + " ns | Exito: " + exito);

            SwingUtilities.invokeLater(() -> {
                if (exito) {
                    mostrarNotificacion("Exportacion completada exitosamente");
                    JOptionPane.showMessageDialog(menuPrincipal, menuPrincipal.exportacionExitosa());
                } else {
                    JOptionPane.showMessageDialog(menuPrincipal, menuPrincipal.errorExportacion());
                }
            });
        });
    }

    public synchronized void actualizarContactoConcurrente() {
        int indice = listaEnUso.getSelectedIndex();
        if (indice < 0) return;

        Persona p = listaEnUso.getModel().getElementAt(indice);

        long inicioSinThread = System.nanoTime();
        String nombreViejo = p.getNombre();
        long finSinThread = System.nanoTime();
        System.out.println("[SIN THREAD] Lectura de contacto para edicion: " + (finSinThread - inicioSinThread) + " ns | Nombre actual: " + nombreViejo);
        System.out.flush();

        String categoria = p.getCategoria();
        if (menuEdicion.btnAmigo.isSelected()) {
            categoria = "Amigo";
        } else if (menuEdicion.btnFamilia.isSelected()) {
            categoria = "Familia";
        } else if (menuEdicion.btnTrabajo.isSelected()) {
            categoria = "Trabajo";
        }

        final String catFinal = categoria;
        final String nuevoNombre = menuEdicion.cmpNombre.getText();
        final String nuevoTelefono = menuEdicion.cmpTelefono.getText();
        final String nuevoEmail = menuEdicion.cmpEmail.getText();
        final boolean nuevoFavorito = menuEdicion.chkFavorito.isSelected();

        executor.submit(() -> {
            long inicio = System.nanoTime();
            lockContactos.lock();
            try {
                p.setNombre(nuevoNombre);
                p.setTelefono(nuevoTelefono);
                p.setEmail(nuevoEmail);
                p.setCategoria(catFinal);
                p.setFavorito(nuevoFavorito);
            } finally {
                lockContactos.unlock();
            }
            long fin = System.nanoTime();
            System.out.println("[CON THREAD synchronized + ExecutorService] Actualizacion contacto: " + (fin - inicio) + " ns");

            SwingUtilities.invokeLater(() -> {
                if (p.isFavorito()) {
                    if (!listModelFav.contains(p)) listModelFav.addElement(p);
                } else {
                    listModelFav.removeElement(p);
                }
                int posicion = listModel.indexOf(p);
                if (posicion >= 0) listModel.set(posicion, p);
                datosContacto(p);
                mostrarNotificacion("Contacto actualizado correctamente");
                menuEdicion.setVisible(false);
                menuDatos.setVisible(true);
            });
        });
    }

    private void mostrarNotificacion(String mensaje) {
        Thread notificacionThread = new Thread(() -> {
            SwingUtilities.invokeLater(() -> {
                JOptionPane optionPane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(menuPrincipal, "Notificacion");
                dialog.setModal(false);
                dialog.setVisible(true);
                Timer timer = new Timer(2500, evt -> dialog.dispose());
                timer.setRepeats(false);
                timer.start();
            });
        });
        notificacionThread.setDaemon(true);
        notificacionThread.start();
    }

    public void abrirMenuEdicion() {
        menuDatos.setVisible(true);
        menuDatos.setLocationRelativeTo(null);
        menuPrincipal.setVisible(false);
    }

    public void iniciar() {
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void datosContacto(Object objeto) {
        if (objeto instanceof Persona) {
            Persona persona = (Persona) objeto;
            menuDatos.lblNombre.setText(persona.getNombre());
            menuDatos.lblTelefono.setText(persona.getTelefono());
            menuDatos.lblCorreo.setText(persona.getEmail());
            menuDatos.categoriaContacto.setText(persona.getCategoria());

            if (persona.isFavorito()) {
                menuDatos.lblNombre.setIcon(new ImageIcon(getClass().getResource("/icons/estrella.png")));
            } else {
                menuDatos.lblNombre.setIcon(null);
            }

            switch (persona.getCategoria()) {
                case "Amigo":
                    menuDatos.categoriaContacto.setIcon(new ImageIcon(getClass().getResource("/icons/11325049(1).png")));
                    break;
                case "Familia":
                    menuDatos.categoriaContacto.setIcon(new ImageIcon(getClass().getResource("/icons/familia(3)(1).png")));
                    break;
                case "Trabajo":
                    menuDatos.categoriaContacto.setIcon(new ImageIcon(getClass().getResource("/icons/760621(1).png")));
                    break;
                default:
                    menuDatos.categoriaContacto.setIcon(null);
            }
        }
        menuDatos.repaint();
        menuDatos.revalidate();
    }

    public void eliminarContacto(JList<Persona> lista) {
        int indice = lista.getSelectedIndex();
        if (indice >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(
                    menuDatos,
                    IdiomaManager.getInstance().get("idioma.confirmarEliminar"),
                    "⚠️",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                Persona persona = listaEnUso.getModel().getElementAt(indice);
                lockContactos.lock();
                try {
                    todasLasPersonas.remove(persona);
                } finally {
                    lockContactos.unlock();
                }
                SwingUtilities.invokeLater(() -> {
                    listModelFav.removeElement(persona);
                    listModel.removeElement(persona);
                    menuDatos.setVisible(false);
                    menuPrincipal.setVisible(true);
                    mostrarNotificacion(IdiomaManager.getInstance().get("idioma.contactoEliminado"));
                });
            }
        }
    }

    public void editarContacto() {
        menuDatos.setVisible(false);
        menuEdicion.setVisible(true);
        menuEdicion.setLocationRelativeTo(null);
        int indice = listaEnUso.getSelectedIndex();
        if (indice >= 0) {
            Persona persona = listaEnUso.getModel().getElementAt(indice);
            menuEdicion.cmpNombre.setText(persona.getNombre());
            menuEdicion.cmpTelefono.setText(persona.getTelefono());
            menuEdicion.cmpEmail.setText(persona.getEmail());
            menuEdicion.chkFavorito.setSelected(persona.isFavorito());

            if (persona.getCategoria().equals("Amigo")) {
                menuEdicion.btnAmigo.setSelected(true);
            } else if (persona.getCategoria().equals("Familia")) {
                menuEdicion.btnFamilia.setSelected(true);
            } else if (persona.getCategoria().equals("Trabajo")) {
                menuEdicion.btnTrabajo.setSelected(true);
            }
        }
    }

    public void importarContacto() {
        long inicioSinThread = System.nanoTime();
        List<Persona> importadosSinThread;
        try {
            importadosSinThread = personaDAO.leerArchivo();
        } catch (Exception e) {
            importadosSinThread = new ArrayList<>();
        }
        long finSinThread = System.nanoTime();
        System.out.println("[SIN THREAD] Importacion: " + (finSinThread - inicioSinThread) + " ns | Leidos: " + importadosSinThread.size());
        System.out.flush();

        executor.submit(() -> {
            long inicio = System.nanoTime();
            List<Persona> importados;
            try {
                importados = personaDAO.leerArchivo();
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(menuPrincipal, menuPrincipal.errorImportacion()));
                return;
            }
            lockContactos.lock();
            List<Persona> nuevos = new ArrayList<>();
            try {
                for (Persona p : importados) {
                    if (!todasLasPersonas.contains(p)) {
                        todasLasPersonas.add(p);
                        nuevos.add(p);
                    }
                }
            } finally {
                lockContactos.unlock();
            }
            long fin = System.nanoTime();
            System.out.println("[CON THREAD ExecutorService] Importacion: " + (fin - inicio) + " ns | Importados: " + nuevos.size());

            SwingUtilities.invokeLater(() -> {
                for (Persona p : nuevos) {
                    listModel.addElement(p);
                    if (p.isFavorito()) listModelFav.addElement(p);
                }
                JOptionPane.showMessageDialog(menuPrincipal, menuPrincipal.importacionExitosa());
            });
        });
    }

    public void cambiarIdioma(String codigo) {
        IdiomaManager.getInstance().cambiarIdioma(codigo);
        menuPrincipal.aplicarIdioma();
        menuAgregar.aplicarIdioma();
        menuDatos.aplicarIdioma();
        menuEdicion.aplicarIdioma();
        menuConfig.aplicarIdioma();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            listaEnUso = (JList<Persona>) e.getSource();
            int indice = listaEnUso.locationToIndex(e.getPoint());
            if (indice >= 0) {
                Object contacto = listaEnUso.getModel().getElementAt(indice);
                datosContacto(contacto);
                abrirMenuEdicion();
            }
        }
    }

    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
}
