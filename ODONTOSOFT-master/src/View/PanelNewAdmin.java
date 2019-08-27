package View;

import java.awt.*;
import java.util.ArrayList;
import View.FieldPanel.FieldPanel;
import javax.swing.*;

public class PanelNewAdmin extends JPanel{
	JButton volver;
	JButton verificar;
	public PanelNewAdmin() {
		JPanel PP=new JPanel();
		PP.setLayout(new BorderLayout());
		
		
		JPanel PI=new JPanel();
		PI.add(new JLabel("New Admin"));
		PP.add(PI,BorderLayout.NORTH);
		
		
		JPanel PM=new JPanel();
		ArrayList<String>formulario = new ArrayList();
		formulario.add("Ingrese un Nuevo Nombre de Usuario: ");
		formulario.add("Ingrese su Nueva Contraseña: ");
		formulario.add("Verifique su contraseña: ");
		formulario.add("Ingrese su nombre y apellido: ");
		formulario.add("Ingrese su identificación: ");
		formulario.add("Ingrese su edad: ");
		formulario.add("Ingrese su telefono: ");
		formulario.add("Ingrese su sexo: ");
		formulario.add("Ingrese su email: ");

		PM.add(new FieldPanel("Datos", formulario, "Rellenar", null, null));
		
		PP.add(PM, BorderLayout.CENTER);
		
		
		JPanel PF=new JPanel();
		PF.setLayout(new GridLayout(1,2));
		verificar=new JButton(InterfazVista.ENVIAR);
		volver = new JButton(InterfazVista.VOLVER);
		PF.add(verificar);
		PF.add(volver);
		PP.add(PF,BorderLayout.SOUTH);
		
		this.add(PP);
	}
	
	
	

}
