package Ventana;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class Principal {

	JFrame frmAuditorAlpha;

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuditorAlpha = new JFrame();
		frmAuditorAlpha.getContentPane().setBackground(Color.WHITE);
		frmAuditorAlpha.setTitle("AudiTor");
		frmAuditorAlpha.setBounds(100, 100, 450, 300);
		frmAuditorAlpha.setLocationRelativeTo(null);
		
		frmAuditorAlpha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("/src/img/icon-AudiTor.png");
		frmAuditorAlpha.setIconImage(icon);
		
		elMenuBar();
		decoracionVentana();
	}

	private void elMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frmAuditorAlpha.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmCargarArchivo = new JMenuItem("Cargar Archivo...");
		mnArchivo.add(mntmCargarArchivo);

		JMenuItem mntmGuardarArchivo = new JMenuItem("Guardar Archivo...");
		mnArchivo.add(mntmGuardarArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDeAuditor = new JMenuItem("Acerca de AudiTor");
		mnAyuda.add(mntmAcercaDeAuditor);
	}

	private void decoracionVentana() {
		frmAuditorAlpha.getContentPane().setLayout(new BorderLayout(0, 0));
		this.frmAuditorAlpha.getContentPane().setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmAuditorAlpha.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JButton btnNewButton = new JButton();
		btnNewButton.setBackground(Color.WHITE);
		panel.add(btnNewButton);

		// Image iconButton =
		// Toolkit.getDefaultToolkit().getImage("src/icon.png");
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconx96.png"))); // NOI18N
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-pressedx96.png"))); // NOI18N
		btnNewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-hoverx96.png"))); //

		JLabel lblCargarArchivo = new JLabel("Cargar Archivo");
		lblCargarArchivo.setFont(new Font("RobotoDraft", Font.ITALIC, 26));
		lblCargarArchivo.setBackground(Color.WHITE);
		lblCargarArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCargarArchivo);
	}

}
