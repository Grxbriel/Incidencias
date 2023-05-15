package Incidencias;

import java.util.ArrayList;

public class ControladorIncidencias {
	private ArrayList<Incidencia> incidencias;

    public ControladorIncidencias() {
        this.incidencias = new ArrayList<>();
    }

    public void crearIncidencia(int puesto, String descripcion) {
        incidencias.add(new Incidencia(puesto, descripcion));
    }

    public void resolverIncidencia(int codigo, String solucion) {
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getCodigo() == codigo) {
                incidencia.resolver(solucion);
                break;
            }
        }
    }

    public void mostrarIncidencias() {
        for (Incidencia incidencia : incidencias) {
            System.out.println(incidencia.toString());
        }
        int pendientes = 0;
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getEstado() == Incidencia.Estado.PENDIENTE) {
                pendientes++;
            }
        }
        System.out.println("Incidencias pendientes: " + pendientes);
    }
}
