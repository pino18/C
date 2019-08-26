package uiMain.operations;

import java.util.Map;
import java.util.Scanner;
import uiMain.OpcionDeMenu;
import BaseDatos.Data;

public class Valoracion extends OpcionDeMenu {//La clase valoracion guarda las valoraciones dadas por los usuarios de tipo invitado (Para que se realice de forma anonima) y hace un promedio de las valoraciones para tener una visión acerca de la opinión de las personas acerca de la compañia

	@Override
	public void ejecutar() { //Ejecuta todas las operaciones de la clase Valoracion, como guardar y promediar las valoraciones otorgadas por usuarios anonimos
		Scanner leer = new Scanner(System.in);
		String vals="";
		try {
			while(true) {
				System.out.println("Ingrese una valoracion entre 1 y 5 si es decimal use punto: ");
				vals = leer.next();
				Double val = Double.parseDouble(vals);
				if (!(val>=1&&val<=5)) {
					System.out.println("Rango incorrecto");
					continue;
				}
				break;
			}
			System.out.println("Ingrese su comentario (acabe con un #): ");
			String com ="";
			String last="";
			while(!last.equals("#")) {
				com+= last+" ";
				last =leer.next();
			}
			Data.valora.put(Data.valora.size()+1,vals+";"+com);
		} catch (Exception e) {
			System.out.println("Utilice el punto en el decimal.");
			this.ejecutar();
		} finally {
			Double pro=0.0;
			for (Map.Entry<Integer, String> valor: Data.valora.entrySet()) {
				String[] vec = valor.getValue().split(";");
				pro += Double.parseDouble(vec[0]);
			}
			System.out.println("Valoracion general: "+(pro/Data.valora.size()));
		}
		
	}

	@Override
	public String toString() {
		
		return "Dar valoracion";
	}

}
