package View;
import java.awt.*;
import javax.swing.*;

import Control.ControlCancelarCita;
import Control.ControlModificarCita;

public class PanelModificarCita extends JPanel {
	JButton volver;
	JButton verificar;
	JComboBox<String> option;
	public static JPanel PP;
	public static JPanel Field = new PanelVoid();
	public static JPanel PF;
	public PanelModificarCita() {
		PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		title.add(new JLabel("Modificar Cita"),BorderLayout.NORTH);
		PP.add(title, BorderLayout.NORTH);
		
		
		JPanel PCENTER = new JPanel(); 
		PCENTER.add(new JLabel("Seleccione Una Opcion: "));
		option = new JComboBox();
		option.addItem("---");
		option.addItem("Cambiar El Estado De Una Cita");
		option.addItem("Ingresar El Procedimiento Realizado En La Cita");
		option.addItemListener(new ControlModificarCita());
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
