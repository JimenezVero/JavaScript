package mx.edu.utng.javascript.model;

/**
 * Created by Iruzz on 05/04/2016.
 */
public class Evaluacion {
    //Crear variables
    private int idEvaluacion;
    private String descripcion;
    //Generar constructor
    public Evaluacion(int idEvaluacion, String descripcion) {
        this.idEvaluacion = idEvaluacion;
        this.descripcion = descripcion;
    }
    //Getter y setter
    public Evaluacion() {
        this(0,"");
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Crear oString()
    @Override
    public String toString() {
        return "Evaluacion{" +
                "idEvaluacion=" + idEvaluacion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
