package com.example.view;

import java.awt.*;
import java.util.*;

/*
 * Created by JFormDesigner on Tue Apr 28 22:06:21 GMT-05:00 2026
 */
import javax.swing.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import com.example.model.IdiomaManager;



/**
 * @author ortiz
 */
public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        initComponents();
        configurarListasVacias();
    }

    private void configurarListasVacias() {
        lstFavContacts = crearListaConEstadoVacio(lstFavContacts, scrollPane1, "No hay contactos favoritos");
        lstAllContacts = crearListaConEstadoVacio(lstAllContacts, scrollPane2, "No hay contactos");
    }

    private JList crearListaConEstadoVacio(JList listaOriginal, JScrollPane scrollPane, String textoVacio) {
        JList nuevaLista = new JList() {
            private Icon emptyIcon;
            {
                try {
                    // Cargamos el icono sin la barra '/' inicial para que FlatSVGIcon lo encuentre correctamente
                    FlatSVGIcon svgIcon = new FlatSVGIcon("com/example/icons/conjunto-vacio.svg", 64, 64);
                    
                    // Aplicar un filtro para que cualquier color del SVG original se convierta en blanco
                    svgIcon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> Color.WHITE));
                    emptyIcon = svgIcon;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Solo dibujamos la imagen y el texto si no hay ningún registro
                if (getModel().getSize() == 0) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setFont(getFont());
                    FontMetrics fm = g2.getFontMetrics();

                    int textWidth = fm.stringWidth(textoVacio);
                    int textHeight = fm.getHeight();

                    int iconWidth = emptyIcon != null ? emptyIcon.getIconWidth() : 0;
                    int iconHeight = emptyIcon != null ? emptyIcon.getIconHeight() : 0;

                    int spacing = 10; // Espaciado entre la imagen y el texto
                    int totalHeight = iconHeight + spacing + textHeight;

                    int x = (getWidth() - iconWidth) / 2;
                    int y = (getHeight() - totalHeight) / 2;

                    if (emptyIcon != null) {
                        emptyIcon.paintIcon(this, g2, x, y);
                    }

                    g2.setColor(Color.LIGHT_GRAY); // Color del mensaje informativo
                    g2.drawString(textoVacio, (getWidth() - textWidth) / 2, y + iconHeight + spacing + fm.getAscent());
                    g2.dispose();
                }
            }
        };

        // Copiamos las propiedades de las listas generadas originalmente
        nuevaLista.setBackground(listaOriginal.getBackground());
        nuevaLista.setForeground(listaOriginal.getForeground());
        nuevaLista.setFont(listaOriginal.getFont());
        nuevaLista.setModel(listaOriginal.getModel());
        
        // Copiar las propiedades de estilo de FlatLaf (como los bordes redondeados)
        if (listaOriginal.getClientProperty(FlatClientProperties.STYLE) != null) {
            String estilo = listaOriginal.getClientProperty(FlatClientProperties.STYLE).toString();
            // Ignoramos las propiedades inválidas de JTable que JFormDesigner agregó por error al JList
            if (!estilo.contains("showHorizontalLines")) {
                nuevaLista.putClientProperty(FlatClientProperties.STYLE, estilo);
            }
        }
        if (listaOriginal.getClientProperty(FlatClientProperties.STYLE_CLASS) != null) {
            nuevaLista.putClientProperty(FlatClientProperties.STYLE_CLASS, listaOriginal.getClientProperty(FlatClientProperties.STYLE_CLASS));
        }
        
        // Copiamos el borde directamente y forzamos a FlatLaf a actualizar el diseño visual
        nuevaLista.setBorder(listaOriginal.getBorder());
        nuevaLista.updateUI();
        
        // Evitamos el error de 'arc' en JScrollPane. FlatLaf hace el recorte automáticamente 
        // usando el borde original si igualamos los colores de fondo del Viewport.
        scrollPane.getViewport().setBackground(listaOriginal.getBackground());
        
        scrollPane.setViewportView(nuevaLista);

        return nuevaLista;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Carlos
		panel1 = new JPanel();
		cmpBusqueda = new JTextField();
		label1 = new JLabel();
		lblFavoritos = new JLabel();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		lstFavContacts = new JList();
		lblAllContacts = new JLabel();
		label5 = new JLabel();
		btnAgg = new JButton();
		btnExportar = new JButton();
		btnImportar = new JButton();
		scrollPane2 = new JScrollPane();
		lstAllContacts = new JList();
		btnConfig = new JButton();

		//======== this ========
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("GESTOR DE CONTACTOS");
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(0x13293d));
			panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
			.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder
			.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
			awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder()))
			;panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
			){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
			;

			//---- cmpBusqueda ----
			cmpBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			cmpBusqueda.setForeground(Color.white);
			cmpBusqueda.setBackground(new Color(0x247ba0));
			cmpBusqueda.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar contacto...");
			cmpBusqueda.putClientProperty(FlatClientProperties.STYLE, "arc: 30");

			//---- label1 ----
			label1.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/lupa.png")));

			//---- lblFavoritos ----
			lblFavoritos.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			lblFavoritos.setForeground(Color.white);

			//---- label3 ----
			label3.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/estrella.png")));

			//======== scrollPane1 ========
			{

				//---- lstFavContacts ----
				lstFavContacts.setBackground(new Color(0x247ba0));
				lstFavContacts.setForeground(Color.white);
				lstFavContacts.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				scrollPane1.setViewportView(lstFavContacts);
			}

			//---- lblAllContacts ----
			lblAllContacts.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			lblAllContacts.setForeground(Color.white);

			//---- label5 ----
			label5.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/contactos.png")));

			//---- btnAgg ----
			btnAgg.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/agregar.png")));
			btnAgg.setBackground(new Color(0x003c3f41, true));
			btnAgg.setBorderPainted(false);
			btnAgg.setFocusPainted(false);
			btnAgg.setContentAreaFilled(false);

			//---- btnExportar ----
			btnExportar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/exportar(1).png")));
			btnExportar.setBackground(new Color(0x003c3f41, true));
			btnExportar.setBorderPainted(false);
			btnExportar.setFocusPainted(false);
			btnExportar.setContentAreaFilled(false);

			//---- btnImportar ----
			btnImportar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/importar(1).png")));
			btnImportar.setBackground(new Color(0x003c3f41, true));
			btnImportar.setBorderPainted(false);
			btnImportar.setFocusPainted(false);
			btnImportar.setContentAreaFilled(false);

			//======== scrollPane2 ========
			{

				//---- lstAllContacts ----
				lstAllContacts.setBackground(new Color(0x247ba0));
				lstAllContacts.setForeground(Color.white);
				lstAllContacts.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				scrollPane2.setViewportView(lstAllContacts);
			}

			//---- btnConfig ----
			btnConfig.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/config(1).png")));
			btnConfig.setBackground(new Color(0x003c3f41, true));
			btnConfig.setBorderPainted(false);
			btnConfig.setFocusPainted(false);
			btnConfig.setContentAreaFilled(false);

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addGap(12, 12, 12)
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addComponent(label5)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lblAllContacts))
							.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
									.addComponent(btnAgg, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(38, 38, 38)
									.addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(38, 38, 38)
									.addComponent(btnConfig, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
								.addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
									.addGroup(panel1Layout.createParallelGroup()
										.addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(panel1Layout.createParallelGroup()
										.addComponent(lblFavoritos)
										.addComponent(cmpBusqueda, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)))))
						.addContainerGap(14, Short.MAX_VALUE))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmpBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(label3, GroupLayout.Alignment.TRAILING)
							.addComponent(lblFavoritos, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(13, 13, 13)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(lblAllContacts, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(label5))
						.addGap(18, 18, 18)
						.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(btnAgg, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnConfig, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		initComponentsI18n();

		pack();
		setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void initComponentsI18n() {
        // JFormDesigner - Component i18n initialization - DO NOT MODIFY  //GEN-BEGIN:initI18n  @formatter:off
		// Generated using JFormDesigner Evaluation license - Carlos
		ResourceBundle bundle = ResourceBundle.getBundle("locales.es");
		cmpBusqueda.setToolTipText(bundle.getString("idioma.cmpBusqueda.toolTipText"));
		lblFavoritos.setText(bundle.getString("idioma.lblFavoritos.text"));
		lblAllContacts.setText(bundle.getString("idioma.lblAllContacts.text"));
        // JFormDesigner - End of component i18n initialization  //GEN-END:initI18n  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Carlos
	private JPanel panel1;
	public JTextField cmpBusqueda;
	private JLabel label1;
	public JLabel lblFavoritos;
	private JLabel label3;
	public JScrollPane scrollPane1;
	public JList lstFavContacts;
	public JLabel lblAllContacts;
	private JLabel label5;
	public JButton btnAgg;
	public JButton btnExportar;
	public JButton btnImportar;
	public JScrollPane scrollPane2;
	public JList lstAllContacts;
	public JButton btnConfig;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public String importacionExitosa() {
        return IdiomaManager.getInstance().get("idioma.importacionExitosa");
    }

    public String errorImportacion() {
        return IdiomaManager.getInstance().get("idioma.errorImportacion");
    }

    public String exportacionExitosa() {
        return IdiomaManager.getInstance().get("idioma.exportacionExitosa");
    }

    public String errorExportacion() {
        return IdiomaManager.getInstance().get("idioma.errorExportacion");
    }

    public void aplicarIdioma() {
        IdiomaManager i18n = IdiomaManager.getInstance();
        lblAllContacts.setText(i18n.get("idioma.lblAllContacts.text"));
        lblFavoritos.setText(i18n.get("idioma.lblFavoritos.text"));
        cmpBusqueda.setToolTipText(i18n.get("idioma.cmpBusqueda.toolTipText"));
        try {
            this.setTitle(i18n.get("idioma.titulo.gestorContactos"));
        } catch (Exception e) {
            // Título por defecto si no se encuentra en los .properties
            this.setTitle("GESTOR DE CONTACTOS");
        }
    }

}
