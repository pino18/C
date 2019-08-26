package View;

public interface InterfazVista {
	

		void arranca(); // comienza la visualización
		
		void startConfigs(); // comienza las configuraciones
		
		// Constantes que definen las posibles operaciones:

		static final String INICIARADMIN = "Administrador";
		static final String INICIARUSER = "Usuario com�n";
		static final String REGISTRAR = "Registrarse";
		static final String VALORACION = "Dar valoración";
		static final String VOLVER = "Volver";
		static final String AYUDA = "Ayuda";
		static final String ENVIAR = "Enviar";
		static final String USUARIO = "Usuario";
		static final String ACEPTAR = "Aceptar";
		static final String CANCELAR = "Cancelar";
		static final String PAGAR = "Pagar";
		// Opciones del menú
		
		static final String VEROPTION = "Ver opciones de un usuario";
		static final String AGREGAROPTION = "Añadir opciones a un usuario";
		static final String ELIMINAROPTION = "Borrar opciones de un usuario";
		static final String NEWADMIN = "Crear nuevo usuario admin";
		static final String NEWEMPLEADO = "Crear nuevo usuario empleado";
		static final String SOLICITARCITA = "Solicitar cita";
		static final String CANCELARCITA = "Cancelar cita";
		static final String PAGARRECIBO = "Pagar recibo";
		static final String ACTIVOSACTUALES = "Ver activos actuales";
		static final String HISTORIA = "Historia clinica";
		static final String RENUNCIA = "Renunciar";
		static final String SALIR = "Salir";
		static final String MODIFICARHISTORIA = "Modificar historia";
		static final String MODIFICARCITA = "Modificar cita";
}
