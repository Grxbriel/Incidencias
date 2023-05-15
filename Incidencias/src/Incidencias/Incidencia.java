package Incidencias;

public class Incidencia {
	private static int codigoActual = 1;
    private int codigo;
    private int puesto;
    private String descripcion;
    private String solucion;
    private Estado estado;

    public enum Estado {
        PENDIENTE, RESUELTA
    }

    public Incidencia(int puesto, String descripcion) {
        this.codigo = codigoActual++;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPuesto() {
        return puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void resolver(String solucion) {
        this.solucion = solucion;
        this.estado = Estado.RESUELTA;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        String estadoString = estado == Estado.PENDIENTE ? "Pendiente" : "Resuelta";
        String solucionString = estado == Estado.RESUELTA ? " - " + solucion : "";
        return "Incidencia " + codigo + " - Puesto: " + puesto + " - " + descripcion + " - " + estadoString + solucionString;
    }
    
    
    public static void main(String[] args) {
        ControladorIncidencias controlador = new ControladorIncidencias();

        controlador.crearIncidencia(105, "No tiene acceso a internet");
        controlador.crearIncidencia(14, "No arranca");
        controlador.crearIncidencia(5, "La pantalla se ve rosa");
        controlador.crearIncidencia(237, "Hace un ruido extraño");
        controlador.crearIncidencia(111, "Se queda colgado al abrir 3 ventanas");

        controlador.resolverIncidencia(2, "El equipo no estaba enchufado");
        controlador.resolverIncidencia(3, "Cambio del cable VGA");

        controlador.mostrarIncidencias();
    }


}
