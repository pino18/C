package gestorAplicacion.documents;
import java.util.*;

public class Recibo {
	private static Vector<Recibo>pendientes=new Vector<Recibo>();
	private static Vector<Recibo>pagados=new Vector<Recibo>();
	private String ID;
	private String Estado;
	private Procedimiento procedimiento;
	
	

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Procedimiento getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}
	
	public boolean pagar(int monto) {
		boolean r;
		if (this.pendientes.contains(this)) {
			if(this.procedimiento.getValor()<=monto) {
				this.pendientes.remove(this);
				this.pagados.add(this);
				r=true;
			}
			else {
				r=false;
			}
			
		}
		else {
			r=false;
		}
		return r;
	}
}
