package com.example.view;

import java.awt.*;
import java.util.*;

/*
 * Created by JFormDesigner on Wed Apr 29 19:55:07 GMT-05:00 2026
 */
import javax.swing.*;

import com.example.model.IdiomaManager;
import com.formdev.flatlaf.*;



/**
 * @author ortiz
 */
public class MenuEdicion extends JFrame {
	public MenuEdicion() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Carlos
		panel1 = new JPanel();
		btnRegresar = new JButton();
		lblNuevoContacto = new JLabel();
		lblNombre = new JLabel();
		cmpNombre = new JTextField();
		cmpTelefono = new JTextField();
		lblTelefono = new JLabel();
		cmpEmail = new JTextField();
		lblEmail = new JLabel();
		lblCategoria = new JLabel();
		btnFamilia = new JRadioButton();
		lblFamilia = new JLabel();
		lblAmigo = new JLabel();
		btnAmigo = new JRadioButton();
		btnTrabajo = new JRadioButton();
		lblTrabajo = new JLabel();
		lblFavorito = new JLabel();
		chkFavorito = new JCheckBox();
		btnGuardar = new JButton();

		//======== this ========
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("GESTOR DE CONTACTOS");
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(0x13293d));
			panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
			. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder
			. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .
			awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
			; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
			) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
			;

			//---- btnRegresar ----
			btnRegresar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/atras(1).png")));
			btnRegresar.setBackground(new Color(0x004e5052, true));
			btnRegresar.setContentAreaFilled(false);
			btnRegresar.setBorderPainted(false);
			btnRegresar.setFocusPainted(false);

			//---- lblNuevoContacto ----
			lblNuevoContacto.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblNuevoContacto.setForeground(Color.white);

			//---- lblNombre ----
			lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblNombre.setForeground(Color.white);

			//---- cmpNombre ----
			cmpNombre.setBackground(new Color(0x247ba0));
			cmpNombre.setForeground(Color.white);
			cmpNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			cmpNombre.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
			cmpNombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduce el nombre...");

			//---- cmpTelefono ----
			cmpTelefono.setBackground(new Color(0x247ba0));
			cmpTelefono.setForeground(Color.white);
			cmpTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			cmpTelefono.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
			cmpTelefono.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduce el telefono...");

			//---- lblTelefono ----
			lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblTelefono.setForeground(Color.white);

			//---- cmpEmail ----
			cmpEmail.setBackground(new Color(0x247ba0));
			cmpEmail.setForeground(Color.white);
			cmpEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			cmpEmail.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
			cmpEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduce el email...");

			//---- lblEmail ----
			lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblEmail.setForeground(Color.white);

			//---- lblCategoria ----
			lblCategoria.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblCategoria.setForeground(Color.white);

			//---- btnFamilia ----
			btnFamilia.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/familia(3)(1).png")));
			btnFamilia.setBackground(new Color(0x247ba0));
			btnFamilia.setSelectedIcon(new ImageIcon(getClass().getResource("/com/example/icons/image(3).png")));
			btnFamilia.setContentAreaFilled(false);
			btnFamilia.setBorderPainted(true);

			//---- lblFamilia ----
			lblFamilia.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblFamilia.setForeground(Color.white);

			//---- lblAmigo ----
			lblAmigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblAmigo.setForeground(Color.white);

			//---- btnAmigo ----
			btnAmigo.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/11325049(1).png")));
			btnAmigo.setBackground(new Color(0x247ba0));
			btnAmigo.setSelectedIcon(new ImageIcon(getClass().getResource("/com/example/icons/image(4).png")));
			btnAmigo.setBorderPainted(true);
			btnAmigo.setContentAreaFilled(false);

			//---- btnTrabajo ----
			btnTrabajo.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/760621(1).png")));
			btnTrabajo.setBackground(new Color(0x247ba0));
			btnTrabajo.setSelectedIcon(new ImageIcon(getClass().getResource("/com/example/icons/image(5).png")));
			btnTrabajo.setContentAreaFilled(false);
			btnTrabajo.setBorderPainted(true);

			//---- lblTrabajo ----
			lblTrabajo.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblTrabajo.setForeground(Color.white);

			//---- lblFavorito ----
			lblFavorito.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblFavorito.setForeground(Color.white);

			//---- chkFavorito ----
			chkFavorito.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/cerca(2).png")));
			chkFavorito.setSelectedIcon(new ImageIcon(getClass().getResource("/com/example/icons/estrellaa.png")));
			chkFavorito.setBackground(new Color(0x00eeeeee, true));
			chkFavorito.setContentAreaFilled(false);

			//---- btnGuardar ----
			btnGuardar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/disco-flexible(1).png")));
			btnGuardar.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			btnGuardar.setBackground(new Color(0x247ba0));
			btnGuardar.setForeground(Color.white);
			btnGuardar.setContentAreaFilled(false);

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addGap(12, 12, 12)
								.addGroup(panel1Layout.createParallelGroup()
									.addGroup(panel1Layout.createSequentialGroup()
										.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
											.addComponent(btnAmigo)
											.addComponent(btnTrabajo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(lblAmigo)
											.addGroup(panel1Layout.createSequentialGroup()
												.addGroup(panel1Layout.createParallelGroup()
													.addComponent(lblTrabajo)
													.addGroup(panel1Layout.createSequentialGroup()
														.addGap(29, 29, 29)
														.addComponent(lblFavorito)))
												.addGap(32, 32, 32)
												.addComponent(chkFavorito))))
									.addGroup(panel1Layout.createSequentialGroup()
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(lblTelefono)
											.addComponent(lblEmail)
											.addComponent(lblNombre))
										.addGap(12, 12, 12)
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(cmpNombre, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
											.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(cmpEmail, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
												.addComponent(cmpTelefono))))
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(btnFamilia)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblFamilia))
									.addComponent(lblCategoria)))
							.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnRegresar)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lblNuevoContacto)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGap(75, 75, 75))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNuevoContacto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addGap(23, 23, 23)
								.addComponent(cmpNombre))
							.addGroup(panel1Layout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lblNombre)))
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(lblTelefono)
							.addComponent(cmpTelefono, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(lblEmail)
							.addComponent(cmpEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addGap(14, 14, 14)
								.addComponent(lblFamilia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(panel1Layout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnFamilia)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(btnAmigo)
							.addComponent(lblAmigo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup()
									.addGroup(panel1Layout.createSequentialGroup()
										.addComponent(lblTrabajo, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
										.addGap(12, 12, 12)
										.addComponent(lblFavorito))
									.addGroup(panel1Layout.createSequentialGroup()
										.addGap(0, 63, Short.MAX_VALUE)
										.addComponent(chkFavorito)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnGuardar)
								.addContainerGap())
							.addGroup(panel1Layout.createSequentialGroup()
								.addComponent(btnTrabajo)
								.addGap(0, 0, Short.MAX_VALUE))))
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
		lblNuevoContacto.setText(bundle.getString("idioma.lblNuevoContacto.text_2"));
		lblNombre.setText(bundle.getString("idioma.lblNombre.text"));
		lblTelefono.setText(bundle.getString("idioma.lblTelefono.text"));
		lblEmail.setText(bundle.getString("idioma.lblEmail.text"));
		lblCategoria.setText(bundle.getString("idioma.lblCategoria.text_2"));
		lblFamilia.setText(bundle.getString("idioma.lblFamilia.text"));
		lblAmigo.setText(bundle.getString("idioma.lblAmigo.text"));
		lblTrabajo.setText(bundle.getString("idioma.lblTrabajo.text"));
		lblFavorito.setText(bundle.getString("idioma.lblFavorito.text"));
		btnGuardar.setText(bundle.getString("idioma.btnGuardar.text"));
		// JFormDesigner - End of component i18n initialization  //GEN-END:initI18n  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Carlos
	private JPanel panel1;
	public JButton btnRegresar;
	public JLabel lblNuevoContacto;
	public JLabel lblNombre;
	public JTextField cmpNombre;
	public JTextField cmpTelefono;
	public JLabel lblTelefono;
	public JTextField cmpEmail;
	public JLabel lblEmail;
	public JLabel lblCategoria;
	public JRadioButton btnFamilia;
	public JLabel lblFamilia;
	public JLabel lblAmigo;
	public JRadioButton btnAmigo;
	public JRadioButton btnTrabajo;
	public JLabel lblTrabajo;
	public JLabel lblFavorito;
	public JCheckBox chkFavorito;
	public JButton btnGuardar;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

	public String decisionEliminarContacto () {
		return "¿Estás seguro de que deseas eliminar este contacto?";
	}

	public String contactoEliminado () {
		return "Contacto eliminado exitosamente.";
	}

	public void aplicarIdioma() {
		IdiomaManager i18n = IdiomaManager.getInstance();
		lblNuevoContacto.setText(i18n.get("idioma.lblNuevoContacto.text_2")); // "Modificar contacto"
		lblNombre.setText(i18n.get("idioma.lblNombre.text_2"));
		lblTelefono.setText(i18n.get("idioma.lblTelefono.text_2"));
		lblEmail.setText(i18n.get("idioma.lblEmail.text_2"));
		lblCategoria.setText(i18n.get("idioma.lblCategoria.text_3"));
		lblFavorito.setText(i18n.get("idioma.lblFavorito.text_2"));
		btnGuardar.setText(i18n.get("idioma.btnGuardar.text_2"));
		lblAmigo.setText(i18n.get("idioma.lblAmigo.text_2"));
		lblFamilia.setText(i18n.get("idioma.lblFamilia.text_2"));
		lblTrabajo.setText(i18n.get("idioma.lblTrabajo.text_2"));
		try {
			this.setTitle(i18n.get("idioma.titulo.gestorContactos"));
		} catch (Exception e) {
			// Título por defecto si no se encuentra en los .properties
			this.setTitle("GESTOR DE CONTACTOS");
		}
	}
}
