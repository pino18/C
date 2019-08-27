package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.InterfazVista;
import errorAplication.UnCompleteException;

public class ControlNewEmpleado implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(InterfazVista.ACEPTAR)) {
			try {
				
			}catch(UnCompleteException EX){
				
			}
		}

	}

}
