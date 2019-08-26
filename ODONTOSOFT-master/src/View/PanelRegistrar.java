package View;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Control.ControlRegistrar;

public class PanelRegistrar extends JPanel {
	
	JLabel title;
	JComboBox<String> option;
	public static JPanel PP;
	public static JPanel Field = new PanelVoid();
	public PanelRegistrar() {
		
		PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		title = new JLabel("Registrarse");
		PP.add(title, BorderLayout.NORTH);
		
		JPanel PCENTER = new JPanel(); 
		PCENTER.add(new JLabel("Indique el tipo de usuario:   "));
		option = new JComboBox();
		option.addItem("---");
		option.addItem("Paciente");
		option.addItem("Acompañante");
		option.addItemListener(new ControlRegistrar());
		PCENTER.add(option);
		
		PP.add(PCENTER, BorderLayout.CENTER);
		PP.add(Field,BorderLayout.SOUTH);
		this.add(PP);
	}
}
