package uiMain.operations;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.Procedimiento;
import gestorAplicacion.documents.Recibo;
public class PagarRecibo extends OpcionDeMenu{

	public PagarRecibo(String key){
		super(key);
	}

	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese la identificacion del recibo");
		String ID = leer.next();
		System.out.print("Ingrese el monto");
		int M = leer.nextInt();
		Recibo R = Data.reci.get(ID);
		Procedimiento P= R.getProcedimiento();
		if(P.getValor()<=M) {
			R.setEstado("Pago");
		}
		else {
			System.out.println("Monto insuficiente"); ;
		}
	}

	@Override
	public String toString() {
		return "pagar recibo";
	}

}
