package mx.edu.utng.javascript.model;

/**
 * Created by Edgar on 27/03/2016.
 */
public class Pregunta {
    //Crear variables
    private int idPregunta;
    private String descripcion;
    private int idEvaluacion;
    //Generar constructor
    public Pregunta(int idPregunta, String descripcion, int idEvaluacion) {
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.idEvaluacion = idEvaluacion;
    }
    //Getter y setter
    public Pregunta() {
        this(0,"",0);
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    //Crear oString()
    @Override
    public String toString() {
        return "Pregunta{" +
                "idPregunta=" + idPregunta +
                ", descripcion='" + descripcion + '\'' +
                ", idEvaluacion=" + idEvaluacion +
                '}';
    }
}
