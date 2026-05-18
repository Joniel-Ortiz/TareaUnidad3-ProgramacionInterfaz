package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private File archivo;
    private Persona persona;
    private static final Object lockArchivo = new Object();

    public PersonaDAO(Persona persona) {
        this.persona = persona;
        prepararArchivo();
    }

    public PersonaDAO() {
        prepararArchivo();
    }

    private void prepararArchivo() {
        this.archivo = new File("contactos.csv");
    }

    public boolean escribirArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(persona.formatoLista());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public List<Persona> leerArchivo() {
        List<Persona> lista = new ArrayList<>();
        if (!archivo.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    lista.add(new Persona(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            datos[3].trim(),
                            Boolean.parseBoolean(datos[4].trim())
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarContactos(List<Persona> listaPersonas) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Persona p : listaPersonas) {
                pw.println(p.formatoLista());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarContactosSincronizado(List<Persona> listaPersonas) {
        synchronized (lockArchivo) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                for (Persona p : listaPersonas) {
                    pw.println(p.formatoLista());
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
