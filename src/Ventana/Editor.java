package Ventana;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import jm.util.Read;
import listas.Lista;
import logica.Cancion;

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
	//Se cambia la visibilidad a public y static para poder cambiar el icono dinamicamente desde la clase Events
	public static JButton btnPlay;
	private JButton btnPrev;
	private JButton btnNext;
	
	private JPopupMenu popup;
	private JButton btnStop;
	private JButton btnOptions;
	
	private Cancion cancion;
	
	public static boolean play;
	
	public Editor(Cancion cancion) {
		this.cancion = cancion;
		play = true;
		
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
		this.modifyButton(btnCopy, "/img/icon-copy.png", "/img/icon-copy-hover.png", "/img/icon-copy-pressed.png", "btnCopy", "Copiar");
		
		btnPaste = new JButton();
		this.modifyButton(btnPaste, "/img/icon-paste.png", "/img/icon-paste-hover.png", "/img/icon-paste-pressed.png", "btnPaste", "Pegar");
		
		btnCut = new JButton();
		this.modifyButton(btnCut, "/img/icon-cut.png", "/img/icon-cut-hover.png", "/img/icon-cut-pressed.png", "btnCut", "Cortar");
		
		FlowLayout fl_panelActionButton = new FlowLayout(FlowLayout.LEADING, 5, 5);
		fl_panelActionButton.setAlignOnBaseline(true);
		panelActionButton.setLayout(fl_panelActionButton);
		panelActionButton.add(btnCopy);
		panelActionButton.add(btnCut);
		panelActionButton.add(btnPaste);
		
		btnOpenFile = new JButton("");
		this.modifyButton(btnOpenFile, "/img/icon-open-file.png", "/img/icon-open-file-hover.png", "/img/icon-open-file-pressed.png", "btnOpenFile", "Abrir archivo");
		panelActionButton.add(btnOpenFile);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelGrafica = new Grafica(cancion.getAmplitudes());
		panelCenter.add(panelGrafica, BorderLayout.CENTER);
		
		panelSongButtons = new JPanel();
		panelSongButtons.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelSongButtons.setBackground(Color.white);
		panelCenter.add(panelSongButtons, BorderLayout.PAGE_END);
		
		btnStop = new JButton("");
		this.modifyButton(btnStop, "/img/icon-stop.png", "/img/icon-stop-hover.png", "/img/icon-stop-pressed.png", "btnStop", "Detener");
		panelSongButtons.add(btnStop);
		
		btnPrev = new JButton();
		this.modifyButton(btnPrev, "/img/icon-prev.png", "/img/icon-prev-hover.png", "/img/icon-prev-pressed.png", "btnPrev", "Anterior");
		panelSongButtons.add(btnPrev);
		
		btnPlay = new JButton();
		this.modifyButton(btnPlay, "/img/icon-play.png", "/img/icon-play-hover.png", "/img/icon-play-pressed.png", "btnPlay", "Play");
		panelSongButtons.add(btnPlay);
		
		btnNext = new JButton();
		this.modifyButton(btnNext, "/img/icon-next.png", "/img/icon-next-hover.png", "/img/icon-next-pressed.png", "btnNext", "Siguiente");
		
		popup = new JPopupMenu();
		popup.add(new ActionMenu("uno"));
		popup.add(new ActionMenu("dos"));
		popup.add(new ActionMenu("tres"));
		panelSongButtons.add(btnNext);
		
		btnOptions = new JButton("");
		this.modifyButton(btnOptions, "/img/icon-options.png", "/img/icon-options-hover.png", "/img/icon-options-pressed.png", "btnOptions", "Opciones");
		btnOptions.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {showOptions(e);}
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
	
	public void showOptions(MouseEvent e) {
		if (e.isPopupTrigger()) {
			popup.setLocation(e.getLocationOnScreen());
			popup.setVisible(true);
		} else {
			popup.setVisible(false);
		}
	}
	
	/** Metodo para evitar escribir tanto codigo con los estilos de los botones ya que a todos se les agrega los iconos y el listener
	 * */
	public void modifyButton(JButton btn, String icon, String iconHover, String iconPressed, String actionCommand, String tooltip) {
		btn.setIcon(new ImageIcon(Principal.class.getResource(icon)));
		btn.setSelectedIcon(new ImageIcon(Principal.class.getResource(iconPressed)));
		btn.setRolloverIcon(new ImageIcon(Principal.class.getResource(iconHover)));
		btn.setBorder(null);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setActionCommand(actionCommand);
		btn.addActionListener(new Events(this));
		btn.setToolTipText(tooltip);
	}
		
	public static void changeIcon(String icon) {
		Editor.btnPlay.setIcon(new ImageIcon(Principal.class.getResource("/img/"+icon+".png")));
		Editor.btnPlay.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/"+icon+"-pressed.png")));
		Editor.btnPlay.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/"+icon+"-hover.png")));
	}

	/**
	 * @return the panelActionButton
	 */
	public JPanel getPanelActionButton() {
		return panelActionButton;
	}

	/**
	 * @param panelActionButton the panelActionButton to set
	 */
	public void setPanelActionButton(JPanel panelActionButton) {
		this.panelActionButton = panelActionButton;
	}

	/**
	 * @return the panelPrincipal
	 */
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	/**
	 * @param panelPrincipal the panelPrincipal to set
	 */
	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	/**
	 * @return the panelCenter
	 */
	public JPanel getPanelCenter() {
		return panelCenter;
	}

	/**
	 * @param panelCenter the panelCenter to set
	 */
	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	/**
	 * @return the panelGrafica
	 */
	public Grafica getPanelGrafica() {
		return panelGrafica;
	}

	/**
	 * @param panelGrafica the panelGrafica to set
	 */
	public void setPanelGrafica(Grafica panelGrafica) {
		this.panelGrafica = panelGrafica;
	}

	/**
	 * @return the panelSongButtons
	 */
	public JPanel getPanelSongButtons() {
		return panelSongButtons;
	}

	/**
	 * @param panelSongButtons the panelSongButtons to set
	 */
	public void setPanelSongButtons(JPanel panelSongButtons) {
		this.panelSongButtons = panelSongButtons;
	}

	/**
	 * @return the robotoDraftNormal
	 */
	public Font getRobotoDraftNormal() {
		return robotoDraftNormal;
	}

	/**
	 * @param robotoDraftNormal the robotoDraftNormal to set
	 */
	public void setRobotoDraftNormal(Font robotoDraftNormal) {
		this.robotoDraftNormal = robotoDraftNormal;
	}

	/**
	 * @return the robotoDraftMedium
	 */
	public Font getRobotoDraftMedium() {
		return robotoDraftMedium;
	}

	/**
	 * @param robotoDraftMedium the robotoDraftMedium to set
	 */
	public void setRobotoDraftMedium(Font robotoDraftMedium) {
		this.robotoDraftMedium = robotoDraftMedium;
	}

	/**
	 * @return the btnCopy
	 */
	public JButton getBtnCopy() {
		return btnCopy;
	}

	/**
	 * @param btnCopy the btnCopy to set
	 */
	public void setBtnCopy(JButton btnCopy) {
		this.btnCopy = btnCopy;
	}

	/**
	 * @return the btnCut
	 */
	public JButton getBtnCut() {
		return btnCut;
	}

	/**
	 * @param btnCut the btnCut to set
	 */
	public void setBtnCut(JButton btnCut) {
		this.btnCut = btnCut;
	}

	/**
	 * @return the btnPaste
	 */
	public JButton getBtnPaste() {
		return btnPaste;
	}

	/**
	 * @param btnPaste the btnPaste to set
	 */
	public void setBtnPaste(JButton btnPaste) {
		this.btnPaste = btnPaste;
	}

	/**
	 * @return the btnOpenFile
	 */
	public JButton getBtnOpenFile() {
		return btnOpenFile;
	}

	/**
	 * @param btnOpenFile the btnOpenFile to set
	 */
	public void setBtnOpenFile(JButton btnOpenFile) {
		this.btnOpenFile = btnOpenFile;
	}

	/**
	 * @return the btnPrev
	 */
	public JButton getBtnPrev() {
		return btnPrev;
	}

	/**
	 * @param btnPrev the btnPrev to set
	 */
	public void setBtnPrev(JButton btnPrev) {
		this.btnPrev = btnPrev;
	}

	/**
	 * @return the btnNext
	 */
	public JButton getBtnNext() {
		return btnNext;
	}

	/**
	 * @param btnNext the btnNext to set
	 */
	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	/**
	 * @return the btnStop
	 */
	public JButton getBtnStop() {
		return btnStop;
	}

	/**
	 * @param btnStop the btnStop to set
	 */
	public void setBtnStop(JButton btnStop) {
		this.btnStop = btnStop;
	}

	/**
	 * @return the btnOptions
	 */
	public JButton getBtnOptions() {
		return btnOptions;
	}

	/**
	 * @param btnOptions the btnOptions to set
	 */
	public void setBtnOptions(JButton btnOptions) {
		this.btnOptions = btnOptions;
	}
	
}
