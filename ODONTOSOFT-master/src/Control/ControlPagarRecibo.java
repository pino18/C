package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.InterfazVista;
import View.PanelInicio;
import View.PanelLogin;
import View.PanelPagarRecibo;
import View.PanelValoracion;
import View.VentanaPP;
import errorAplication.NotFoundException;
import errorAplication.RandException;
import gestorAplicacion.documents.Recibo;
import uiMain.operations.PagarRecibo;
import uiMain.operations.Valoracion;

public class ControlPagarRecibo implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(InterfazVista.ACEPTAR)) {
			String NR = PanelPagarRecibo.NroR.getText();
			try {
				Recibo R = PagarRecibo.Validacion(NR);
				VentanaPP.contenedor.removeAll();
				VentanaPP.contenedor.add(new PanelPagarRecibo(R.getID(),R.getProcedimiento().getValor()));
				VentanaPP.ventana.pack();
				
			}catch(NotFoundException re) {
				JOptionPane.showMessageDialog(null, "El recibo con identificacion "+NR+" no fue encontrado", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (e.getActionCommand().equals(InterfazVista.PAGAR)) {
			int M = Integer.parseInt(PanelPagarRecibo.Mon.getText());
			String NR = PanelPagarRecibo.Nro;
			try {
				PagarRecibo.Pago(NR,M);
				JOptionPane.showMessageDialog(null, "Pago exitoso"," Pagar Recibo", JOptionPane.INFORMATION_MESSAGE);
				VentanaPP.contenedor.removeAll();
				VentanaPP.contenedor.add(new PanelLogin());
				VentanaPP.ventana.pack();
				
			}catch(NotFoundException re) {
				JOptionPane.showMessageDialog(null, "Monto insuficiente, el recibo no ha sido pagado", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
