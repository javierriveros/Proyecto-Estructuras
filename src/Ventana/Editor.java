package Ventana;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Cancion;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;

public class Editor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelActionButton;
	private JPanel panelPrincipal;
	private JPanel panelCenter;
	private Grafica panelGrafica;
	private JPanel panelSongButtons;
	private JPanel panelEdicion;

	private Font robotoDraftNormal;
	private Font robotoDraftMedium;

	private JLabel lblSoundTitle;
	private JLabel lblSoundSize;
	private JButton btnPlay;

	private JButton btnStop;
	private JButton btnOptions;

	private Cancion cancion;

	private boolean play;
	private JPanel panelFrom;
	private JPanel panelTo;

	public Editor(Cancion cancion) {

		this.cancion = cancion;
		play = true;
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));

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
		add(panelPrincipal, BorderLayout.NORTH);
		panelPrincipal.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panelTexto = new JPanel();
		panelTexto.setLayout(new GridLayout(1, 2));
		panelTexto.setBackground(Color.white);

		lblSoundTitle = new JLabel("Nombre del archivo: " + cancion.getNombreDelAudio());
		lblSoundTitle.setFont(robotoDraftMedium);
		lblSoundTitle.setBackground(new Color(238, 238, 238));
		panelTexto.add(lblSoundTitle);

		lblSoundSize = new JLabel("Duraci�n: " + cancion.getDuracion() + " seg.");
		lblSoundSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoundSize.setFont(robotoDraftNormal);
		lblSoundSize.setBackground(new Color(238, 238, 238));
		panelTexto.add(lblSoundSize);

		panelPrincipal.add(panelTexto);

		panelActionButton = new JPanel();
		panelActionButton.setBorder(new EmptyBorder(10, 0, 5, 0));
		panelActionButton.setBackground(Color.WHITE);
		panelPrincipal.add(panelActionButton);

		panelEdicion = new JPanel();
		panelEdicion.setBackground(Color.white);
		panelEdicion.setLayout(new BorderLayout());

		panelPrincipal.add(panelEdicion);

		this.panelFrom = new JPanel();
		this.panelFrom.setBackground(Color.WHITE);
		panelEdicion.add(this.panelFrom, BorderLayout.WEST);

		this.panelTo = new JPanel();
		this.panelTo.setBackground(Color.WHITE);
		panelEdicion.add(this.panelTo, BorderLayout.EAST);

		FlowLayout fl_panelActionButton = new FlowLayout(FlowLayout.LEADING, 5, 5);
		fl_panelActionButton.setAlignOnBaseline(true);
		panelActionButton.setLayout(fl_panelActionButton);


		panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelGrafica = new Grafica(cancion.getAmplitudes());
		panelCenter.add(panelGrafica, BorderLayout.CENTER);

		panelSongButtons = new JPanel();
		panelSongButtons.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelSongButtons.setBackground(Color.white);
		panelCenter.add(panelSongButtons, BorderLayout.PAGE_END);

		btnStop = new JButton();
		panelSongButtons.add(btnStop);

		btnPlay = new JButton();
		panelSongButtons.add(btnPlay);

		btnOptions = new JButton("");
		panelSongButtons.add(btnOptions);
		this.setIcons();
		
	}

	/**
	 * Metodo para evitar escribir tanto codigo con los estilos de los botones
	 * ya que a todos se les agrega los iconos y el listener
	 */
	public void modifyButton(JButton btn, String icon, String iconHover, String iconPressed, String actionCommand,
			String tooltip) {
		btn.setIcon(new ImageIcon("src/" + icon));
		btn.setPressedIcon(new ImageIcon("src/" + iconPressed));
		btn.setRolloverIcon(new ImageIcon("src/" + iconHover));
		btn.setBorder(null);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setActionCommand(actionCommand);
		btn.addActionListener(new Events(this));
		btn.setToolTipText(tooltip);
	}

	public void setIcons() {
		this.modifyButton(btnPlay, "/img/icon-play.png", "/img/icon-play-hover.png", "/img/icon-play-pressed.png",
				"btnPlay", "Play");
		this.modifyButton(btnOptions, "/img/icon-options.png", "/img/icon-options-hover.png",
				"/img/icon-options-pressed.png", "btnOptions", "Opciones");
		this.modifyButton(btnStop, "/img/icon-stop.png", "/img/icon-stop-hover.png", "/img/icon-stop-pressed.png",
				"btnStop", "Detener");
	}

	public void changeIcon(String icon) {
		btnPlay.setIcon(new ImageIcon(Principal.class.getResource("/img/" + icon + ".png")));
		btnPlay.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/" + icon + "-pressed.png")));
		btnPlay.setRolloverIcon(new ImageIcon(Principal.class.getResource("/img/" + icon + "-hover.png")));
	}

	/**
	 * @return the panelActionButton
	 */
	public JPanel getPanelActionButton() {
		return panelActionButton;
	}

	public Cancion getCancion() {
		return cancion;
	}

	/**
	 * @return the panelGrafica
	 */
	public Grafica getPanelGrafica() {
		return panelGrafica;
	}

	/**
	 * @param panelGrafica
	 *            the panelGrafica to set
	 */
	public void setPanelGrafica(Grafica panelGrafica) {
		this.panelGrafica = panelGrafica;
	}
	
	/**
	 * @return the btnPlay
	 */
	public JButton getBtnPlay() {
		return btnPlay;
	}

	/**
	 * @param btnPlay the btnPlay to set
	 */
	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

	/**
	 * @return the play
	 */
	public boolean isPlay() {
		return play;
	}

	/**
	 * @param play the play to set
	 */
	public void setPlay(boolean play) {
		this.play = play;
	}

	/**
	 * @param cancion the cancion to set
	 */
	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}
	
	

}
