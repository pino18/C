package uiMain;

import java.util.ArrayList;
import BaseDatos.Data;
import View.InterfazVista;
import View.VentanaPP;
import View.VentanaText;
import gestorAplicacion.users.User;
import uiMain.operations.*;

public class Main {
	public static void main(String[] args) {//Bloque Principal
		
		//Ejecutar el programa desde la interfaz de consola:
		//InterfazVista ventana = new VentanaText();
		//ventana.arranca();
		
		//Ejecutar el programa desde la interfaz gráfica:
		InterfazVista ventana = new VentanaPP();
		ventana.arranca();
	}
}
