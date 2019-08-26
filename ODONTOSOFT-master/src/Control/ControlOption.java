package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import View.InterfazVista;
import View.PanelInicio;
import View.PanelValoracion;
import View.VentanaPP;
import errorAplication.ErrorAplication;
import gestorAplicacion.users.User;

public class ControlOption implements ActionListener{
	private InterfazVista vista;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(InterfazVista.INICIAR)) {
			try {
				PanelInicio panel = (PanelInicio) VentanaPP.contenedor.getComponent(0);
				String user = panel.getUser();
				String password = panel.getPassword();
				String login = User.login(user, password);
				
				JMenu archivo = new JMenu("Archivo");
				JMenuItem usuario = new JMenuItem(InterfazVista.USUARIO);
				//Poner ActionListener
				usuario.addActionListener(null);
				archivo.add(usuario);
				
				JMenuItem salir = new JMenuItem(InterfazVista.SALIR);
				//Poner ActionListener
				salir.addActionListener(null);
				archivo.add(salir);
				JMenu procesos = new JMenu("Procesos y Consultas");
				JMenu ayuda = new JMenu(InterfazVista.AYUDA);
				String[] opt = User.currentUser.getMenu().getOperations();
				for (String num: opt) {
					switch(num){
						case("1"):
							JMenuItem opt1 = new JMenuItem(InterfazVista.VEROPTION);
						//Todos los ActionListener se agregan apenas se creen.
							opt1.addActionListener(null);
							procesos.add(opt1);break;
						case("2"):
							JMenuItem opt2 = new JMenuItem(InterfazVista.AGREGAROPTION);
						//Todos los ActionListener se agregan apenas se creen.
							opt2.addActionListener(null);
							procesos.add(opt2);break;
						case("3"):
							JMenuItem opt3 = new JMenuItem(InterfazVista.ELIMINAROPTION);
						//Todos los ActionListener se agregan apenas se creen.
							opt3.addActionListener(null);
							procesos.add(opt3);break;
						case("4"):
							JMenuItem opt4 = new JMenuItem(InterfazVista.NEWADMIN);
						//Todos los ActionListener se agregan apenas se creen.
							opt4.addActionListener(null);
							procesos.add(opt4);break;
						case("5"):
							JMenuItem opt5 = new JMenuItem(InterfazVista.NEWEMPLEADO);
						//Todos los ActionListener se agregan apenas se creen.
							opt5.addActionListener(null);
							procesos.add(opt5);break;
						case("6"):
							JMenuItem opt6 = new JMenuItem(InterfazVista.SOLICITARCITA);
						//Todos los ActionListener se agregan apenas se creen.
							opt6.addActionListener(null);
							procesos.add(opt6);break;
						case("7"):
							JMenuItem opt7 = new JMenuItem(InterfazVista.CANCELARCITA);
						//Todos los ActionListener se agregan apenas se creen.
							opt7.addActionListener(null);
							procesos.add(opt7);break;
						case("8"):
							JMenuItem opt8 = new JMenuItem(InterfazVista.PAGARRECIBO);
						//Todos los ActionListener se agregan apenas se creen.
							opt8.addActionListener(null);
							procesos.add(opt8);break;
						case("9"):
							JMenuItem opt9 = new JMenuItem(InterfazVista.ACTIVOSACTUALES);
						//Todos los ActionListener se agregan apenas se creen.
							opt9.addActionListener(null);
							procesos.add(opt9);break;
						case("10"):
							JMenuItem opt10 = new JMenuItem(InterfazVista.HISTORIA);
						//Todos los ActionListener se agregan apenas se creen.
							opt10.addActionListener(null);
							procesos.add(opt10);break;
						case("11"):
							JMenuItem opt11 = new JMenuItem(InterfazVista.RENUNCIA);
						//Todos los ActionListener se agregan apenas se creen.
							opt11.addActionListener(null);
							procesos.add(opt11);break;
						case("13"):
							JMenuItem opt13 = new JMenuItem(InterfazVista.MODIFICARHISTORIA);
						//Todos los ActionListener se agregan apenas se creen.
							opt13.addActionListener(null);
							procesos.add(opt13);break;
						case("14"):
							JMenuItem opt14 = new JMenuItem(InterfazVista.ELIMINAROPTION);
						//Todos los ActionListener se agregan apenas se creen.
							opt14.addActionListener(null);
							procesos.add(opt14);break;
					}
					VentanaPP.menuBarra.add(archivo);
					VentanaPP.menuBarra.add(procesos);
					VentanaPP.menuBarra.add(ayuda);
					VentanaPP.ventana.setJMenuBar(VentanaPP.menuBarra);
					
					VentanaPP.contenedor.removeAll();
					VentanaPP.ventana.pack();
				}
			}
			catch (ErrorAplication exp) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if (e.getActionCommand().equals(InterfazVista.VALORACION)) {
			
			VentanaPP.contenedor.removeAll();
			VentanaPP.contenedor.add(new PanelValoracion());
			VentanaPP.ventana.pack();
		}
		else if (e.getActionCommand().equals(InterfazVista.VOLVER)) {
			
			VentanaPP.contenedor.removeAll();
			VentanaPP.contenedor.add(new PanelInicio());
			VentanaPP.ventana.pack();
		}
	}
}
