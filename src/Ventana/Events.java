package Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
				break;
			case "btnPaste":
				System.out.println("PASTE");
				break;
			case "btnCut":
				System.out.println("CUT");
				break;
			case "btnOpenFile":
				System.out.println("OPEN FILE");
				break;
			case "btnStop":
				System.out.println("STOP");
				break;
			case "btnPrev":
				System.out.println("PREVIOUS");
				break;
			case "btnPlay":
				if (Editor.play == true) {
					Editor.changeIcon("icon-pause");
					Editor.play = false;
					frame.getCancion().play();
				} else {
					Editor.play = true;
					Editor.changeIcon("icon-play");
					frame.getCancion().pause();
				}
				break;
			case "btnNext":
				System.out.println("NEXT");
				break;
		}
	}
}
