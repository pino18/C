package uiMain.operations;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.Main;
import uiMain.OpcionDeMenu;
public class ModificarHistoria extends OpcionDeMenu{
	public ModificarHistoria(String key) {
		super(key);
	}
	public void ejecutar() {
		User P= Main.user;
		String ID=P.getIdentificacion();
		HistoriaClinica HC= Data.historias.get(ID);
		System.out.println("Ingrese la nueva informaciÃ³n clinica, escriba #(Separado por espacio) para terminar: ");
		Scanner leer = new Scanner(System.in);
		String info ="";
		while(true){
			String sisa = leer.next();
			if(!sisa.equals("#")){
				info += sisa;
			}
			else if(sisa.equals("#")){
				break;
			}
		}
		if(HC.getInformacion().equals("ninguna")){
			HC.setInformacion(info);
			System.out.println("Historia cambiada exitosamente");
		}else {
			HC.setInformacionNueva(info);
			System.out.println("Historia cambiada exitosamente");
		}
	}
	public String toString() {
		return "Modificar Historia Clinica";
	}
}

