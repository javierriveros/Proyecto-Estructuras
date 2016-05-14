package Ventana
;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Accion generica para los items del menu.
 * 
 */
public class ActionMenu extends AbstractAction {
	private String textoOpcion;

	/**
	 * Se le pasa el nombre que se quiere que se muestre
	 * 
	 * @param textoOpcion
	 */
	public ActionMenu(String textoOpcion) {
		this.textoOpcion = textoOpcion;
		this.putValue(Action.NAME, textoOpcion);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pulsado " + textoOpcion);
	}
}