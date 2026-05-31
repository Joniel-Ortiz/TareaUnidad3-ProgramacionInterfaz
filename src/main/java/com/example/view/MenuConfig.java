package com.example.view;

import java.awt.*;
import java.util.*;

/*
 * Created by JFormDesigner on Thu Apr 30 12:22:04 GMT-05:00 2026
 */
import javax.swing.*;

import com.example.model.IdiomaManager;



/**
 * @author ortiz
 */
public class MenuConfig extends JFrame {
	public MenuConfig() {
		initComponents();
		
		// Le damos a nuestro ComboBox un ancho base para que no se vea aplastado
		cmbIdiomas.setPrototypeDisplayValue("Seleccione idioma...");
		// Forzamos un tamaño fijo para que la ventana no se encoja de más
		setSize(398, 179);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Carlos
		panel1 = new JPanel();
		btnRegresar = new JButton();
		lblConfiguracion = new JLabel();
		btnAgg = new JButton();
		lblIdioma = new JLabel();
		cmbIdiomas = new JComboBox();

		//======== this ========
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("GESTOR DE CONTACTOS");
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(0x13293d));
			panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
			( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
			. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
			. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
			propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
			; }} );

			//---- btnRegresar ----
			btnRegresar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/atras(1).png")));
			btnRegresar.setBackground(new Color(0x004e5052, true));
			btnRegresar.setBorderPainted(false);
			btnRegresar.setFocusPainted(false);
			btnRegresar.setContentAreaFilled(false);

			//---- lblConfiguracion ----
			lblConfiguracion.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblConfiguracion.setForeground(Color.white);

			//---- btnAgg ----
			btnAgg.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/planeta-tierra(2).png")));
			btnAgg.setBackground(new Color(0x003c3f41, true));
			btnAgg.setBorderPainted(false);
			btnAgg.setFocusPainted(false);
			btnAgg.setContentAreaFilled(false);

			//---- lblIdioma ----
			lblIdioma.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblIdioma.setForeground(Color.white);

			//---- cmbIdiomas ----
			cmbIdiomas.setBackground(new Color(0x247ba0));
			cmbIdiomas.setForeground(Color.white);
			cmbIdiomas.setMaximumRowCount(3);
			cmbIdiomas.setPrototypeDisplayValue("s");

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lblConfiguracion))
							.addGroup(panel1Layout.createSequentialGroup()
								.addGap(128, 128, 128)
								.addGroup(panel1Layout.createParallelGroup()
									.addComponent(cmbIdiomas, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(btnAgg, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblIdioma)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(lblConfiguracion)
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addComponent(btnAgg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblIdioma, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cmbIdiomas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		lblConfiguracion.setText(bundle.getString("idioma.lblConfiguracion.text"));
		lblIdioma.setText(bundle.getString("idioma.lblIdioma.text"));
		// JFormDesigner - End of component i18n initialization  //GEN-END:initI18n  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Carlos
	private JPanel panel1;
	public JButton btnRegresar;
	public JLabel lblConfiguracion;
	public JButton btnAgg;
	public JLabel lblIdioma;
	public JComboBox cmbIdiomas;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

	public void aplicarIdioma() {
		IdiomaManager i18n = IdiomaManager.getInstance();
		lblConfiguracion.setText(i18n.get("idioma.lblConfiguracion.text"));
		lblIdioma.setText(i18n.get("idioma.lblIdioma.text"));
		try {
			this.setTitle(i18n.get("idioma.titulo.gestorContactos"));
		} catch (Exception e) {
			// Título por defecto si no se encuentra en los .properties
			this.setTitle("GESTOR DE CONTACTOS");
		}
	}
}
