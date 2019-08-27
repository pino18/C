package Control.ControlPanelInicio;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlSalir implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int desicion = JOptionPane.showConfirmDialog(null,"Está seguro que desea salir del programa");
		if(desicion == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		int desicion = JOptionPane.showConfirmDialog(null,"Está seguro que desea salir del programa");
		if(desicion == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
