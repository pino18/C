package Control.ControlPanelInicio;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.PanelInicio;
public class ControlChangeButton implements MouseListener {
	int contador = 0;
	@Override
	public void mouseClicked(MouseEvent e) {
		contador++;
			if(contador%3==1) {
				PanelInicio.CambiarImagen("foto1.png");
			}
			if(contador%3==2) {
				PanelInicio.CambiarImagen("foto2.png");
			}
			if(contador%3==0) {
				PanelInicio.CambiarImagen("imagen1.png");
			}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
