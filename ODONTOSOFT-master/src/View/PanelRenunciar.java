package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.ControlModificarCita;
import Control.ControlOption;
import Control.ControlRenunciar;
import View.FieldPanel.FieldPanel;

public class PanelRenunciar extends JPanel {
	JButton volver;
	JButton verificar;
	public static FieldPanel Field;
	
	
	public PanelRenunciar(){
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		
		JPanel PI=new JPanel();
		PI.add(new JLabel("Renunciar"));
		
		
		JPanel PM=new JPanel();
		ArrayList<String>formulario = new ArrayList();
		formulario.add("Ingrese el Nombre de Usuario Nuevamente: ");
		formulario.add("Ingrese Su contraseña nuevamente: ");
		Field=new FieldPanel("Datos", formulario, "Rellenar", null, null);
		PM.add(Field);
		
		
		JPanel PF=new JPanel();
		PF.setLayout(new GridLayout(1,2));
		verificar=new JButton(InterfazVista.ENVIAR);
		volver = new JButton(InterfazVista.VOLVER);
		PF.add(verificar);
		PF.add(volver);
		verificar.addActionListener(new ControlRenunciar());
		volver.addActionListener(new ControlOption());
		
		
		
		PP.add(PI,BorderLayout.NORTH);
		PP.add(PM,BorderLayout.CENTER);
		PP.add(PF,BorderLayout.SOUTH);
		this.add(PP);
		
		
		
		
	}
	

}
