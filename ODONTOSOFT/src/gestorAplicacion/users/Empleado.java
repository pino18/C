package gestorAplicacion.users;
import java.util.*;

public class Empleado extends Persona{
	
	
	
	public static Vector <Empleado> medicos=new Vector<>();
	public static Vector <Empleado> secretarios=new Vector<>();
	public TreeSet<String>citasasignadas=new TreeSet<String>();
	private String contrato;
	private String cargo;
	private int sueldo;
	private String horario;
	
	

	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

	public boolean verificardisponible(String fe,String h) {
		String veri=fe+" "+h;
		boolean r;
		if(citasasignadas.contains(veri)==false) {
			r=true;
		}
		else {
			r=false;
		}
		return r;
	}
	public void renunciar(String c) throws Throwable {
		if (this.cargo.equals("secretario")){
			this.finalize();
		}
		else if(this.cargo.equals("medico")) {
			this.finalize(this.citasasignadas);
		}
	}
	
	
	public void finalize(){
		secretarios.remove(this);
	}
	public void finalize(TreeSet<String> c){
		while (c.size()>0){
			String f=c.pollFirst();
			Iterator<Empleado>h=medicos.iterator();
			while(h.hasNext()) {
				Empleado me=h.next();
				if(me.citasasignadas.contains(f)==false) {
					me.citasasignadas.add(f);
					break;
				}
				else if(me.citasasignadas.contains(f)==true) {
				}
			}
		}
		medicos.remove(this);
		
	}
	
	

}
