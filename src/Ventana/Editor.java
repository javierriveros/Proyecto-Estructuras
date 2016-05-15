package Ventana;

import static javax.swing.SwingUtilities.updateComponentTreeUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class Editor extends JFrame {
	private JPanel contentPane;
	private JPanel panelActionButton;
	private JPanel panelPrincipal;
	private JPanel panelCenter;
	private Grafica panelGrafica;
	private JPanel panelSongButtons;
	
	private Font robotoDraftNormal;
	private Font robotoDraftMedium;
	
	private JLabel lblSoundTitle;
	private JLabel lblSoundSize;
	
	private JButton btnCopy;
	private JButton btnCut;
	private JButton btnPaste;
	private JButton btnOpenFile;
	private JButton btnPlay;
	private JButton btnPrev;
	private JButton btnNext;
	
	private JPopupMenu popup;
	private JButton btnStop;
	private JButton btnOptions;
	
	public Editor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 650);
		setTitle("AudiTor");
		setLocationRelativeTo(null);
		Image icon = Toolkit.getDefaultToolkit().getImage("src/img/icon-AudiTor.png");
		setIconImage(icon);
		elMenuBar();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		/* Fonts declaration */
		robotoDraftNormal = new Font("RobotoDraft", Font.PLAIN, 16);
		robotoDraftMedium = new Font("RobotoDraft", Font.PLAIN, 24);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 10));
		contentPane.add(panelPrincipal, BorderLayout.NORTH);
		panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblSoundTitle = new JLabel("Titulo del audio".toUpperCase());
		lblSoundTitle.setFont(robotoDraftMedium);
		lblSoundTitle.setBackground(new Color(238,238,238));
		panelPrincipal.add(lblSoundTitle);
		
		lblSoundSize = new JLabel("Tamaño: 2kb");
		lblSoundSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoundSize.setFont(robotoDraftNormal);
		lblSoundSize.setBackground(new Color(238,238,238));
		panelPrincipal.add(lblSoundSize);
		
		panelActionButton = new JPanel();
		panelActionButton.setBorder(new EmptyBorder(10, 0, 5, 0));
		panelActionButton.setBackground(Color.WHITE);
		panelPrincipal.add(panelActionButton);
		
		btnCopy = new JButton();
		btnCopy.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-copy-pressed.png")));
		btnCopy.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-copy-hover.png")));
		btnCopy.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-copy.png")));
		btnCopy.setBorder(null);
		btnCopy.setBorderPainted(false);
		btnCopy.setContentAreaFilled(false);
		btnCopy.setToolTipText("Copiar");
		btnCopy.addActionListener((e) -> btnCopyActionListener(e));
		
		btnPaste = new JButton();
		btnPaste.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-paste.png")));
		btnPaste.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-paste-pressed.png")));
		btnPaste.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-paste-hover.png")));
		btnPaste.setBorder(null);
		btnPaste.setBorderPainted(false);
		btnPaste.setContentAreaFilled(false);
		btnPaste.setToolTipText("Pegar");
		btnPaste.addActionListener((e) -> btnPasteActionListener(e));
		
		btnCut = new JButton();
		btnCut.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-cut-pressed.png")));
		btnCut.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-cut-hover.png")));
		btnCut.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-cut.png")));
		btnCut.setBorder(null);
		btnCut.setBorderPainted(false);
		btnCut.setContentAreaFilled(false);
		btnCut.setToolTipText("Cortar");
		btnCut.addActionListener((e) -> btnCutActionListener(e));
		FlowLayout fl_panelActionButton = new FlowLayout(FlowLayout.LEADING, 5, 5);
		fl_panelActionButton.setAlignOnBaseline(true);
		panelActionButton.setLayout(fl_panelActionButton);
		panelActionButton.add(btnCopy);
		panelActionButton.add(btnCut);
		panelActionButton.add(btnPaste);
		
		btnOpenFile = new JButton("");
		btnOpenFile.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-open-file-pressed.png")));
		btnOpenFile.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-open-file-hover.png")));
		btnOpenFile.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-open-file.png")));
		btnOpenFile.setBorder(null);
		btnOpenFile.setBorderPainted(false);
		btnOpenFile.setContentAreaFilled(false);
		btnOpenFile.setToolTipText("Abrir archivo");
		btnOpenFile.addActionListener((e) -> btnOpenFileActionListener(e));
		panelActionButton.add(btnOpenFile);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		panelGrafica = new Grafica();
		panelCenter.add(panelGrafica, BorderLayout.CENTER);
		
		panelSongButtons = new JPanel();
		panelSongButtons.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelSongButtons.setBackground(Color.white);
		panelCenter.add(panelSongButtons, BorderLayout.PAGE_END);
		
		btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-stop.png")));
		btnStop.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-stop-pressed.png")));
		btnStop.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-stop-hover.png")));
		btnStop.setBorder(null);
		btnStop.setBorderPainted(false);
		btnStop.setContentAreaFilled(false);
		btnStop.addActionListener((e) -> btnStopActionListener(e));
		panelSongButtons.add(btnStop);
		
		btnPrev = new JButton();
		btnPrev.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-prev.png")));
		btnPrev.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-prev-pressed.png")));
		btnPrev.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-prev-hover.png")));
		panelSongButtons.add(btnPrev);
		btnPrev.setBorder(null);
		btnPrev.setBorderPainted(false);
		btnPrev.setContentAreaFilled(false);
		btnPrev.addActionListener((e)-> btnPrevActionListener(e));
		
		btnPlay = new JButton();
		btnPlay.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-play-pressed.png")));
		btnPlay.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-play-hover.png")));
		btnPlay.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-play.png")));
		btnPlay.setBorder(null);
		btnPlay.setBorderPainted(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.addActionListener((e)-> btnPlayActionListener(e));
		panelSongButtons.add(btnPlay);
		
		btnNext = new JButton();
		btnNext.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-next.png")));
		btnNext.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-next-pressed.png")));
		btnNext.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-next-hover.png")));
		btnNext.setBorder(null);
		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);
		btnNext.addActionListener((e) -> btnNextActionListener(e));
		
		popup = new JPopupMenu();
		popup.add(new ActionMenu("Option One"));
		popup.add(new ActionMenu("Option Two"));
		popup.add(new ActionMenu("Option Three"));
		panelSongButtons.add(btnNext);
		
		btnOptions = new JButton("");
		btnOptions.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/icon-options-presed.png")));
		btnOptions.setIcon(new ImageIcon(Principal.class.getResource("/img/icon-options.png")));
		btnOptions.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/icon-options-hover.png")));
		btnOptions.setBorder(null);
		btnOptions.setBorderPainted(false);
		btnOptions.setContentAreaFilled(false);
		btnOptions.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				showOptions(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		panelSongButtons.add(btnOptions);
	}

	private void elMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

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
	
	private void btnCopyActionListener(ActionEvent e) {
		System.out.println("Copy");
	}
	
	private void btnCutActionListener(ActionEvent e) {
		System.out.println("Cut");	
	}
	
	private void btnOpenFileActionListener(ActionEvent e) {
		System.out.println("Open File");
	}
	
	private void btnPasteActionListener(ActionEvent e) {
		System.out.println("Paste");
	}
	
	private void btnPrevActionListener(ActionEvent e) {
		System.out.println("Previous");
	}

	private void btnPlayActionListener(ActionEvent e) {
		System.out.println("Play");
	}

	private void btnNextActionListener(ActionEvent e) {
		System.out.println("Next");
	}
	
	private void btnStopActionListener(ActionEvent e) {
		System.out.println("Stop");
	}
	
	public void showOptions(MouseEvent e) {
		if (e.isPopupTrigger()) {
			popup.setLocation(e.getLocationOnScreen());
			popup.setVisible(true);
		} else {
			popup.setVisible(false);
		}
	}
}
