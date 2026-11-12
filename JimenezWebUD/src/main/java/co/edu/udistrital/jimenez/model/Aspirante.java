package co.edu.udistrital.jimenez.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Aspirante extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private String programaInteresado;
    private LocalDate fechaRegistro;

    public Aspirante() {
        super();
        this.fechaRegistro = LocalDate.now();
    }

    public Aspirante(String identificacion, String nombres, String apellidos,
                     String correo, String telefono, String programaInteresado) {
        super(identificacion, nombres, apellidos, correo, telefono);
        this.programaInteresado = programaInteresado;
        this.fechaRegistro = LocalDate.now();
    }

    public String getProgramaInteresado() {
        return programaInteresado;
    }

    public void setProgramaInteresado(String programaInteresado) {
        this.programaInteresado = programaInteresado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Aspirante [identificacion=" + getIdentificacion() + ", nombres=" + getNombres()
                + ", apellidos=" + getApellidos() + ", programa=" + programaInteresado
                + ", fechaRegistro=" + fechaRegistro + "]";
    }
}
