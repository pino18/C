package View;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Control.ControlCancelarCita;
import Control.ControlRegistrar;
import javax.swing.JLabel;


public class PanelCancelarCita extends JPanel{
	JButton volver;
	JButton verificar;
	JComboBox<String> option;
	JLabel title;
	public static JPanel PP;
	public static JPanel Field = new PanelVoid();
	public static JPanel PF;
	public PanelCancelarCita() {
		
		PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		title.add(new JLabel("Cancelar Cita"),BorderLayout.NORTH);
		PP.add(title, BorderLayout.NORTH);
		
		JPanel PCENTER = new JPanel(); 
		PCENTER.add(new JLabel("Indique Como Cancelará Su Cita: "));
		option = new JComboBox();
		option.addItem("---");
		option.addItem("Por Fecha");
		option.addItem("Por numero");
		option.addItemListener(new ControlCancelarCita());
		PCENTER.add(option);
		title.add(PCENTER);

		
		
		PF=new JPanel();
		PF.setLayout(new GridLayout(1,2));
		verificar=new JButton(InterfazVista.ENVIAR);
		volver = new JButton(InterfazVista.VOLVER);
		PF.add(verificar);
		PF.add(volver);
		
		
		PP.add(title, BorderLayout.NORTH);
		PP.add(Field,BorderLayout.CENTER);
		PP.add(PF,BorderLayout.SOUTH);
		this.add(PP);
		
		
	}
}
