package Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Events implements ActionListener {
	private Editor frame;
	
	public Events(Editor frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "btnCopy":
				System.out.println("COPY");
				verifySpinners();
				break;
			case "btnPaste":
				System.out.println("PASTE");
				verifySpinners();
				break;
			case "btnCut":
				System.out.println("CUT");
				if (verifySpinners()) {
					frame.getCancion().getAmplitudes().cortar(Integer.parseInt(frame.getSpinnerFrom().getValue().toString()),Integer.parseInt(frame.getSpinnerTo().getValue().toString()));
				}
				break;
			case "btnOpenFile":
				System.out.println("OPEN FILE");
				break;
			case "btnStop":
				System.out.println("STOP");
				frame.getCancion().stop();
				break;
			case "btnPrev":
				System.out.println("PREVIOUS");
				break;
			case "btnPlay":
				if (frame.isPlay()) {
					frame.getCancion().play();
					frame.changeIcon("icon-pause");
					frame.setPlay(false);
				} else {
					frame.setPlay(true);
					frame.getCancion().pause();
					frame.changeIcon("icon-play");
				}
				break;
			case "btnNext":
				System.out.println("NEXT");
				break;
			case "btnOptions":
				JOptionPane.showMessageDialog(frame, frame.getCancion(), "Información del audio", JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
	
	public boolean verifySpinners() {
		String vSpinnerFrom = frame.getSpinnerFrom().getValue().toString();
		String vSpinnerTo = frame.getSpinnerTo().getValue().toString();
		if(isNumber(vSpinnerFrom) && isNumber(vSpinnerTo)) {
			int iSpinnerFrom = Integer.parseInt(vSpinnerFrom.toString());
			int iSpinnerTo = Integer.parseInt(vSpinnerTo.toString());
			if(iSpinnerFrom > iSpinnerTo || iSpinnerTo > frame.getCancion().getDuracion())
				JOptionPane.showMessageDialog(frame, "No has seleccionado un intervalo válido", "Error", JOptionPane.WARNING_MESSAGE);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isNumber(String s) {
		boolean number = false;
		try {
			Integer.parseInt(s);
			number = true;
		} catch(Exception e) {
		}
		return number;
	}
}
