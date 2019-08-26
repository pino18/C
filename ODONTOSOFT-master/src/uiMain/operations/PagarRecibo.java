package uiMain.operations;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.Procedimiento;
import gestorAplicacion.documents.Recibo;
public class PagarRecibo extends OpcionDeMenu{//Hace el proceso de pago de un recibo existente, ademas mantiene un registro de los pagos que se hacen para poder ser usados en la clase "Activos totales"

	public PagarRecibo(String key){
		super(key);
	}
	@Override
	public void ejecutar() {//Hace la validación del recibo, lo busca mediante ID y ejecuta las operaciones necesarias para poder asegurar que el monto ingresado por el usuario es suficiente para realizar el pago del recibo
		Scanner leer = new Scanner(System.in);
		while(true) {
			System.out.print("Ingrese la identificacion del recibo");
			String ID = leer.next();
			if(Data.reci.containsKey(ID)) {
				Recibo R = Data.reci.get(ID);
				System.out.println("Monto Total a pagar: "+R.getProcedimiento().getValor());
				System.out.print("Ingrese el monto a debitar");
				int M = leer.nextInt();
				Procedimiento P= R.getProcedimiento();
				if(P.getValor()<=M) {
					R.setEstado("Pago");
					System.out.println("el recibo ha sido pagado");
					break;		
				}
				else {
					System.out.println("Monto insuficiente, el recibo no ha sido pagado");
				}
			}else {
				System.out.print("Identificacion erronea");
			}
		}
		
	}

	@Override
	public String toString() {
		return "pagar recibo";
	}

}
