package mx.edu.utng.javascript.model;

/**
 * Created by Iruzz on 05/04/2016.
 */
public class RespuestaEvaluacion {
    //Craear veriables
    private int idUsuario;
    private int idEvaluacion;
    private int idPregunta;
    private boolean estadoPregunta;
    //Generar constructor
    public RespuestaEvaluacion(int idUsuario, int idEvaluacion, int idPregunta, boolean estadoPregunta) {
        this.idUsuario = idUsuario;
        this.idEvaluacion = idEvaluacion;
        this.idPregunta = idPregunta;
        this.estadoPregunta = estadoPregunta;
    }
    //Getter y setter
    public RespuestaEvaluacion() {
        this(0,0,0,false);
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

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public boolean isEstadoPregunta() {
        return estadoPregunta;
    }

    public void setEstadoPregunta(boolean estadoPregunta) {
        this.estadoPregunta = estadoPregunta;
    }
    //Crear oString()
    @Override
    public String toString() {
        return "RespuestaEvaluacion{" +
                "idUsuario=" + idUsuario +
                ", idEvaluacion=" + idEvaluacion +
                ", idPregunta=" + idPregunta +
                ", estadoPregunta=" + estadoPregunta +
                '}';
    }
}
