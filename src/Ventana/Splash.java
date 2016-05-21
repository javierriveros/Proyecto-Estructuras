package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;

import jm.util.Read;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingUtilities;
import static javax.swing.SwingUtilities.updateComponentTreeUI;
import javax.swing.UIManager;

public class Splash extends JFrame {
	private JPanel contentPane;
	private Cargar hilo;
	private JProgressBar progressBar;
	private JPanel panel;
	private JLabel lblCargandoComponentes;

	public Splash() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(568, 600);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Image icon = Toolkit.getDefaultToolkit().getImage("src/img/icon-AudiTor.png");
		setIconImage(icon);
		setUndecorated(true);
		setLocationRelativeTo(null);

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
			updateComponentTreeUI(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		JLabel lblNewLabel = new JLabel("");
		ImageIcon icono = new ImageIcon(Splash.class.getResource("/img/logo.png"));
		lblNewLabel.setIcon(icono);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblCargandoComponentes = new JLabel("Cargando componentes...");
		panel.add(lblCargandoComponentes, BorderLayout.PAGE_START);

		progressBar = new JProgressBar();
		panel.add(progressBar, BorderLayout.PAGE_END);
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int progreso = progressBar.getValue();
				if (progreso == 30)
					lblCargandoComponentes.setText("Cargando graficadoras...");
				else if (progreso == 50)
					lblCargandoComponentes.setText("Cargando directorios...");
				else if (progreso == 90)
					lblCargandoComponentes.setText("Abriendo ventana principal...");
				else if (progreso == 100) {
					new Principal().setVisible(true);
					;
					dispose();
				}
			}
		});
		
		hilo = new Cargar(this.progressBar);
		hilo.start();
		hilo = null;
	}
}
