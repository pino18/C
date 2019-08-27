package View;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import View.FieldPanel.FieldPanel;


public class PanelModificarHistoria extends JPanel {
	public static JPanel PF;
	JButton volver;
	JButton verificar;
	JLabel title;
	JComboBox<String> option;
	public static JPanel PP;
	public static JPanel Field = new PanelVoid();
	public PanelModificarHistoria() {
		PP = new JPanel();
		PP.setLayout(new BorderLayout(10,10));
		Field.setLayout(new BorderLayout(10,10));

		JPanel title = new JPanel();
		title.add(new JLabel("Modificar Historia"));
		PP.add(title, BorderLayout.NORTH);
		
		ArrayList<String>formul = new ArrayList();
		formul.add("Ingrese la Identificacion del Usuario");
		Field.add(new FieldPanel("Parametro",formul,"Valor",null,null),BorderLayout.NORTH);
		
		
		Field.add(new JLabel("Ingrese la Nueva Información del Usuario"),BorderLayout.CENTER);
		Field.add(new JTextArea(10,20),BorderLayout.SOUTH);
		PP.add(Field,BorderLayout.CENTER);
		
		
		PF=new JPanel();
		PF.setLayout(new GridLayout(1,2));
		verificar=new JButton(InterfazVista.ENVIAR);
		volver = new JButton(InterfazVista.VOLVER);
		PF.add(verificar);
		PF.add(volver);
		PP.add(PF,BorderLayout.SOUTH);
		
		this.add(PP);
		
		
	}
}
