package Control.ControlPanelInicio;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.PanelInicio;

public class ControlMouseLabel implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		PanelInicio.L1.setForeground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		PanelInicio.L1.setForeground(Color.black);	
	}
}