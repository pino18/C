package uiMain.operations;

import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.documents.HistoriaClinica;
import uiMain.OpcionDeMenu;
public class ModificarHistoria extends OpcionDeMenu{//Se modifica la historia clinica de un usuario especifico haciendo uso de manipulacion de archivos de texto
	public ModificarHistoria(String key) {
		super(key);
	}
	public void ejecutar() {//Pide la identificaci�n del usuario al cual se le quiere cambiar la historia clinica, la identificaci�n del usuario es la misma identificaci�n de la historia clinica la cual despues de hacer la validacion se pedir�n los datos que se quiere cambiar en el apartado informaci�n de la Historia clinica
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese la identificaci�n del usuario");
		String ID = leer.next();
		HistoriaClinica HC= Data.historias.get(ID);
		System.out.println("Ingrese la nueva informaci�n clinica, escriba #(Separado por espacio) para terminar: ");
		String info ="";
		while(true){
			String sisa = leer.next();
			if(!sisa.equals("#")){
				info += " "+sisa;
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