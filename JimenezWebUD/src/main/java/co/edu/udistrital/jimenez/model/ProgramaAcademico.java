package co.edu.udistrital.jimenez.model;

import java.io.Serializable;
import java.util.Objects;

public class ProgramaAcademico implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String codigoSnies;
    private String nombre;
    private String facultad;

    public ProgramaAcademico() {
    }

    public ProgramaAcademico(int id, String codigoSnies, String nombre, String facultad) {
        this.id = id;
        this.codigoSnies = codigoSnies;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoSnies() {
        return codigoSnies;
    }

    public void setCodigoSnies(String codigoSnies) {
        this.codigoSnies = codigoSnies;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoSnies, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ProgramaAcademico other = (ProgramaAcademico) obj;
        return id == other.id && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "ProgramaAcademico [id=" + id + ", codigoSnies=" + codigoSnies + ", nombre=" + nombre + "]";
    }
}
