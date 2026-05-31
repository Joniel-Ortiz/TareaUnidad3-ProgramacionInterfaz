package com.example.view;

import java.awt.*;
import java.util.*;

/*
 * Created by JFormDesigner on Wed Apr 29 18:22:17 GMT-05:00 2026
 */
import javax.swing.*;

import com.example.model.IdiomaManager;



/**
 * @author ortiz
 */
public class MenuDatos extends JFrame {
	public MenuDatos() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Carlos
		panel1 = new JPanel();
		btnRegresar = new JButton();
		lblNuevoContacto = new JLabel();
		lblNombre = new JLabel();
		lblTelefono = new JLabel();
		lblCorreo = new JLabel();
		lblCategoria = new JLabel();
		categoriaContacto = new JLabel();
		lblFoto = new JLabel();
		btnLllamar = new JButton();
		btnEditar = new JButton();
		btnEliminar = new JButton();

		//======== this ========
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("GESTOR DE CONTACTOS");
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(0x13293d));

			//---- btnRegresar ----
			btnRegresar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/atras(1).png")));
			btnRegresar.setBackground(new Color(0x004e5052, true));
			btnRegresar.setBorderPainted(false);
			btnRegresar.setFocusPainted(false);
			btnRegresar.setContentAreaFilled(false);

			//---- lblNuevoContacto ----
			lblNuevoContacto.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblNuevoContacto.setForeground(Color.white);

			//---- lblNombre ----
			lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
			lblNombre.setForeground(Color.white);
			lblNombre.setText("nombre");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

			//---- lblTelefono ----
			lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
			lblTelefono.setForeground(Color.white);
			lblTelefono.setText(" numero");
			lblTelefono.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/6361846(1).png")));
			lblTelefono.setBackground(new Color(0x00eeeeee, true));

			//---- lblCorreo ----
			lblCorreo.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
			lblCorreo.setForeground(Color.white);
			lblCorreo.setText(" correo");
			lblCorreo.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/8679834(1).png")));
			lblCorreo.setBackground(new Color(0x00eeeeee, true));

			//---- lblCategoria ----
			lblCategoria.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			lblCategoria.setForeground(Color.white);

			//---- categoriaContacto ----
			categoriaContacto.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
			categoriaContacto.setForeground(Color.white);
			categoriaContacto.setText("categoria");
			categoriaContacto.setIcon(null);
			categoriaContacto.setBackground(new Color(0x00eeeeee, true));

			//---- lblFoto ----
			lblFoto.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/12058199(1)(1).png")));

			//---- btnLllamar ----
			btnLllamar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/6361846(1).png")));
			btnLllamar.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			btnLllamar.setBackground(new Color(0x247ba0));
			btnLllamar.setForeground(Color.white);
			btnLllamar.setContentAreaFilled(false);

			//---- btnEditar ----
			btnEditar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/1703792(1).png")));
			btnEditar.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			btnEditar.setBackground(new Color(0x001e617e, true));
			btnEditar.setForeground(Color.white);
			btnEditar.setContentAreaFilled(false);

			//---- btnEliminar ----
			btnEliminar.setIcon(new ImageIcon(getClass().getResource("/com/example/icons/2496740(1).png")));
			btnEliminar.setFont(new Font("Segoe UI Black", Font.ITALIC, 24));
			btnEliminar.setBackground(new Color(0x001e617e, true));
			btnEliminar.setForeground(Color.white);
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setFocusPainted(false);

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap(32, Short.MAX_VALUE)
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
								.addComponent(lblFoto)
								.addGap(158, 158, 158))
							.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
										.addComponent(btnLllamar)
										.addGap(18, 18, 18)
										.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
									.addGroup(panel1Layout.createSequentialGroup()
										.addGap(76, 76, 76)
										.addComponent(btnEliminar)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 88, GroupLayout.PREFERRED_SIZE)))
								.addGap(28, 28, 28))))
					.addGroup(panel1Layout.createSequentialGroup()
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup()
									.addGroup(panel1Layout.createSequentialGroup()
										.addGap(12, 12, 12)
										.addGroup(panel1Layout.createParallelGroup()
											.addComponent(lblTelefono)
											.addComponent(lblCorreo)
											.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(lblCategoria)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(categoriaContacto))))
									.addGroup(panel1Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnRegresar)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblNuevoContacto)))
								.addGap(0, 132, Short.MAX_VALUE)))
						.addContainerGap())
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNuevoContacto))
						.addGap(28, 28, 28)
						.addComponent(lblFoto)
						.addGap(31, 31, 31)
						.addComponent(lblNombre)
						.addGap(23, 23, 23)
						.addComponent(lblTelefono)
						.addGap(18, 18, 18)
						.addComponent(lblCorreo)
						.addGap(18, 18, 18)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addComponent(categoriaContacto))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(btnLllamar)
							.addComponent(btnEditar))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btnEliminar)
						.addGap(27, 27, 27))
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
		ResourceBundle bundle = ResourceBundle.getBundle("locales.es", Locale.ROOT);
		lblNuevoContacto.setText(bundle.getString("idioma.lblNuevoContacto.text"));
		lblCategoria.setText(bundle.getString("idioma.lblCategoria.text"));
		btnLllamar.setText(bundle.getString("idioma.btnLllamar.text"));
		btnEditar.setText(bundle.getString("idioma.btnEditar.text"));
		btnEliminar.setText(bundle.getString("idioma.btnEliminar.text"));
		// JFormDesigner - End of component i18n initialization  //GEN-END:initI18n  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Carlos
	private JPanel panel1;
	public JButton btnRegresar;
	public JLabel lblNuevoContacto;
	public JLabel lblNombre;
	public JLabel lblTelefono;
	public JLabel lblCorreo;
	public JLabel lblCategoria;
	public JLabel categoriaContacto;
	public JLabel lblFoto;
	public JButton btnLllamar;
	public JButton btnEditar;
	public JButton btnEliminar;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

	public String llamandoContacto() {
		return IdiomaManager.getInstance().get("idioma.llamandoContacto");
	}

	public void aplicarIdioma() {
		IdiomaManager i18n = IdiomaManager.getInstance();
		lblNuevoContacto.setText(i18n.get("idioma.lblNuevoContacto.text")); // "Contacto"
		lblNombre.setText(i18n.get("idioma.lblNombre.text_2"));
		lblTelefono.setText(i18n.get("idioma.lblTelefono.text"));
		lblCorreo.setText(i18n.get("idioma.lblEmail.text_2"));
		lblCategoria.setText(i18n.get("idioma.lblCategoria.text_2"));
		btnEditar.setText(i18n.get("idioma.btnEditar.text"));
		btnEliminar.setText(i18n.get("idioma.btnEliminar.text"));
		btnLllamar.setText(i18n.get("idioma.btnLllamar.text"));
	}
}
