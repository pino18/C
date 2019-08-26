package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.InterfazVista;
import View.PanelInicio;
import View.PanelValoracion;
import View.VentanaPP;
import errorAplication.RandException;
import uiMain.operations.Valoracion;

public class ControlValoracion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(InterfazVista.ENVIAR)) {
			try {
				double N = Double.parseDouble(PanelValoracion.VAL.getText());
				String C = PanelValoracion.COM.getText();
				Valoracion.ejecutar(N,C);
				double PRO = Valoracion.ProGen();
				JOptionPane.showMessageDialog(null, "La Valoracion General de la empresa es: "+PRO, "Valoracion General", JOptionPane.INFORMATION_MESSAGE);
				
				VentanaPP.contenedor.removeAll();
				VentanaPP.contenedor.add(new PanelInicio());
				VentanaPP.ventana.pack();

			}catch(RandException re) {
				JOptionPane.showMessageDialog(null, "La Valoracion está fuera del rango", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
