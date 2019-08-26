package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import BaseDatos.Data;
import Control.ControlPanelInicio.ControlWindowsClose;
import uiMain.operations.ActivosActuales;
import uiMain.operations.AddOpt;
import uiMain.operations.CancelarCita;
import uiMain.operations.ConsultarHistoria;
import uiMain.operations.ModificarCita;
import uiMain.operations.ModificarHistoria;
import uiMain.operations.NewAdmin;
import uiMain.operations.NewEmpleado;
import uiMain.operations.PagarRecibo;
import uiMain.operations.RemoveOpt;
import uiMain.operations.Renunciar;
import uiMain.operations.SeeOpt;
import uiMain.operations.SignOut;
import uiMain.operations.SolicitarCita;

public class VentanaPP extends JFrame implements InterfazVista{
	
	public static Container contenedor;
	public static JFrame ventana;
	public static JMenuBar menuBarra;
	
	public VentanaPP() {
		super("ODONTOSOFT");
		startConfigs();
		//Se quita para guardar cuando se cierra la ventana usando el WindowListener
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana = this;
		ventana.addWindowListener(new ControlWindowsClose());
		menuBarra = new JMenuBar();
		contenedor = this.getContentPane();
		contenedor.add(new PanelInicio());
		this.setPreferredSize(new Dimension(800, 500));
	}
	
	@Override
	public void arranca() {
		pack();// coloca los componentes
		setLocationRelativeTo(null);// centra la ventana en la pantalla
		setVisible(true);// visualiza la ventana
	}

	@Override
	public void startConfigs() {//Asignación de las Keys de los menús de usuario, ademas los ingresa a la tabla hash operations que se encuentra en la clase Data
		
		//Cargar las opciones del programa primero
		
		//Operaciones administrativas
		Data.operations.put("1", new SeeOpt("1"));
		Data.operations.put("2", new AddOpt("2"));
		Data.operations.put("3", new RemoveOpt("3"));
		Data.operations.put("4", new NewAdmin("4"));
		Data.operations.put("5", new NewEmpleado("5"));
		
		//Operaciones de mis usuarios
		
		Data.operations.put("6", new SolicitarCita("6"));
		Data.operations.put("7", new CancelarCita("7"));
		Data.operations.put("8", new PagarRecibo("8"));
		Data.operations.put("9", new ActivosActuales("9"));
		Data.operations.put("10", new ConsultarHistoria("10"));
		Data.operations.put("11", new Renunciar("11"));
		Data.operations.put("12", new SignOut("12"));
		Data.operations.put("13", new ModificarHistoria("13"));
		Data.operations.put("14", new ModificarCita("14"));
		
		Data.loadData();
		// TODO Auto-generated method stub
		
	}
}


