package uiMain.operations;

import uiMain.OpcionDeMenu;
import java.util.Map;
import BaseDatos.Data;
import gestorAplicacion.documents.Recibo;

public class ActivosActuales extends OpcionDeMenu {//Muestra los activos totales de la compa�ia para poder llevar un control de la situaci�n economica de la compa�ia
	public ActivosActuales(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {//Va al registro de los recibos que han sido pagados y hace la suma de la totalidad de dichos recibos, almacena ese valor y lo imprime como Activos totales de la compa�ia
		int TOTAL = 0;
		for (Map.Entry<String, Recibo> Recibo : Data.reci.entrySet()) {
			Recibo RObj = Recibo.getValue();
			if (RObj.getEstado().equals("Pago")) {
				TOTAL += RObj.getProcedimiento().getValor();
			}
		}
		System.out.print("Los activos actuales de la empresa son: "+TOTAL);
	}

	@Override
	public String toString() {
		return "Activos Actuales";
	}

}