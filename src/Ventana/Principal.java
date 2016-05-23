package Ventana;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import jm.util.Read;
import logica.Cancion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class Principal extends JFrame {

	//JFrame frmAuditorAlpha;

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
		//frmAuditorAlpha = new JFrame();
		getContentPane().setBackground(Color.WHITE);
		setTitle("AudiTor");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frmAuditorAlpha.setBounds(100, 100, 708, 417);
		setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("src/img/icon-AudiTor.png");
		setIconImage(icon);
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

		elMenuBar();
		decoracionVentana();
	}

	private void elMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmCargarArchivo = new JMenuItem("Cargar Archivo");
		mntmCargarArchivo.addActionListener((e) -> cargarArchivo());
		mnArchivo.add(mntmCargarArchivo);

		JMenuItem mntmGuardarArchivo = new JMenuItem("Guardar Archivo");
		mnArchivo.add(mntmGuardarArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener((l) -> System.exit(0));
		mnArchivo.add(mntmSalir);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDeAuditor = new JMenuItem("Acerca de AudiTor");
		mnAyuda.add(mntmAcercaDeAuditor);
	}

	private void decoracionVentana() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 1, 0, 0));

		JButton btnAgregar = new JButton();
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cargarArchivo();
			}
		});
		panel.add(btnAgregar);
		btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"))); // NOI18N
		btnAgregar.setBorder(null);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-pressed.png"))); // NOI18N
		btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-hover.png")));
	}
	
	private void cargarArchivo() {
		try {
			JFileChooser cargaArchivo = new JFileChooser();
			cargaArchivo.showOpenDialog(null);
			String ruta = cargaArchivo.getSelectedFile().getAbsolutePath();
			if (ruta.contains(".mp3") || ruta.contains(".wav") || ruta.contains(".aiff")) {

				Cancion cancion = new Cancion(ruta);
				JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente.");
				Editor editorVentana = new Editor(cancion);
				setContentPane(editorVentana);
				revalidate();
				repaint();
			} else {
				JOptionPane.showMessageDialog(null, "Extensión de archivo no compatible", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No has seleccionado ningún archivo.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
