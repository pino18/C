package Control;

import java.util.Map;

import javax.swing.JOptionPane;

import BaseDatos.Data;
import gestorAplicacion.documents.Recibo;

public class ControlActivosActuales {
//se suman todos los valores de los recibos creados a parir de las citas	
	public ControlActivosActuales() {
		int TOTAL = 1;
		for (Map.Entry<String, Recibo> Recibo : Data.reci.entrySet()) {
			Recibo RObj = Recibo.getValue();
			if (RObj.getEstado().equals("Pago")) {
				TOTAL += RObj.getProcedimiento().getValor();
			}
		}
//se crea una ventana emergente con la informacion		
		JOptionPane.showMessageDialog(null, "Los Activos Actuales de la Empresa son: "+TOTAL, "Activos Actuales",
				JOptionPane.INFORMATION_MESSAGE);
		
	}

}
