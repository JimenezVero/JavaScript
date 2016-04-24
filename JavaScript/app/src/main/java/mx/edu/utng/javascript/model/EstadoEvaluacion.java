package mx.edu.utng.javascript.model;

/**
 * Created by Iruzz on 05/04/2016.
 */
public class EstadoEvaluacion {
    //crear variables
    private int idUsuario;
    private int idEvaluacion;
    private boolean estado;
//Generar constructor
    public EstadoEvaluacion(int idUsuario, int idEvaluacion, boolean estado) {
        this.idUsuario = idUsuario;
        this.idEvaluacion = idEvaluacion;
        this.estado = estado;
    }
//Getter y setter
    public EstadoEvaluacion() {
        this(0,0,false);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
//Crear oString()
    @Override
    public String toString() {
        return "EstadoEvaluacion{" +
                "idUsuario=" + idUsuario +
                ", idEvaluacion=" + idEvaluacion +
                ", estado=" + estado +
                '}';
    }
}
