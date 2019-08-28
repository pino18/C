package View;
import java.awt.*;
import javax.swing.*;

import Control.ControlCancelarCita;
import Control.ControlModificarCita;
import Control.ControlOption;
import Control.ControlRegistrar;
import gestorAplicacion.documents.Procedimiento;

public class PanelModificarCita extends JPanel {
	JButton volver;
	JButton verificar;
	public static JComboBox<String> option;
	public static JPanel PP;
	public static JPanel Field = new PanelVoid();
	public static JPanel PF;
	public static JTextField numcita;
	public static JTextField procedi;
	
	
	public PanelModificarCita() {
		PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		JPanel title = new JPanel();
		title.setLayout(new GridLayout(3,1,7,7));
		title.add(new JLabel("Modificar Cita"));
		JPanel text = new JPanel();
		text.add(new JLabel("Digite el número de la cita a modificar: "));
		numcita = new JTextField("",15);
		text.add(numcita);
		title.add(text);
		
		
		
		JPanel PM=new JPanel();
		PM.setLayout(new BorderLayout());
		JPanel PCENTER = new JPanel(); 
		PCENTER.add(new JLabel("La cita fue realizada con exito: "));
		option = new JComboBox();
		option.addItem("---");
		option.addItem("Si");
		option.addItem("No");
		PCENTER.add(option);
		PM.add(PCENTER,BorderLayout.NORTH);
		PM.add(new JLabel("Ingrese el Procedimiento Realizado: "), BorderLayout.CENTER);
		procedi=new JTextField();
		PM.add(procedi,BorderLayout.SOUTH);
		
		
		PF=new JPanel();
		verificar=new JButton(InterfazVista.ENVIAR);
		verificar.addActionListener(new ControlModificarCita());
		volver = new JButton(InterfazVista.VOLVER);
		volver.addActionListener(new ControlOption());
		PF.add(verificar);
		PF.add(volver);
		
		
		PP.add(title, BorderLayout.NORTH);
		PP.add(PM,BorderLayout.CENTER);
		PP.add(PF,BorderLayout.SOUTH);
		this.add(PP);
		
		
		
	}

}
