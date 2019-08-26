package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.ControlOption;

public class PanelValoracion extends JPanel{
	
	JButton volver;
	
	public PanelValoracion() {
		JPanel PanelPP = new JPanel();
		JLabel val = new JLabel("Aquí va el panel de valoración que hace el impedido de Sebastián");
		volver = new JButton(InterfazVista.VOLVER);
		volver.addActionListener(new ControlOption());
		PanelPP.add(val);
		PanelPP.add(volver);
		this.add(PanelPP);
	}
}
