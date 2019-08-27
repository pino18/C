package View;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import View.FieldPanel.FieldPanel;
public class PanelRemoveOpt extends JPanel {
	
	JButton volver;
	JButton verificar;
	public PanelRemoveOpt(){
		JPanel PP=new JPanel();
		PP.setLayout(new BorderLayout());
		
		
		JPanel PI=new JPanel();
		PI.add(new JLabel("Eliminar una Opcion de Menú a un Usuario"));
		PP.add(PI,BorderLayout.NORTH);
		
		
		JPanel PM=new JPanel();
		ArrayList<String>formu = new ArrayList();
		formu.add("Ingrese el nombre de usuario: ");
		formu.add("Ingrese el numero de la funcionalidad a remover: ");
		
		PM.add(new FieldPanel("Datos", formu, "Rellenar", null, null));
		PP.add(PM,BorderLayout.CENTER);
		
		
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
