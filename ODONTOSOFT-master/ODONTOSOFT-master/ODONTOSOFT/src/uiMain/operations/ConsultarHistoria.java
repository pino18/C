package uiMain.operations;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.User;
import uiMain.Main;
import uiMain.OpcionDeMenu;
public class ConsultarHistoria extends OpcionDeMenu {
	public ConsultarHistoria(String key){
		super(key);
	}
	@Override
	public void ejecutar() {
		User P= Main.user;
		String ID=P.getIdentificacion();
		HistoriaClinica HC= Data.historias.get(ID);
		System.out.println("Identificacion: "+HC.getID());
		System.out.println("Nombre del Paciente: "+ P.getFullname());
		System.out.println("Numero de citas realizadas: "+HC.getNroCitasRealizadas());
		System.out.println("Informacion a tener en cuenta: "+HC.getInformacion());

		
	}

	@Override
	public String toString() {
		
		return"Historia Clinica";
	}

}
