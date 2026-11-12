package co.edu.udistrital.jimenez.repository;

import co.edu.udistrital.jimenez.model.ProgramaAcademico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProgramaRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final List<ProgramaAcademico> LISTA_PROGRAMAS = new ArrayList<>();
    private static int secuenciaId = 10;

    static {
        LISTA_PROGRAMAS.add(new ProgramaAcademico(secuenciaId, "SNIES-101", "Ingeniería de Sistemas", "Ingeniería"));
        secuenciaId += 10;
        LISTA_PROGRAMAS.add(new ProgramaAcademico(secuenciaId, "SNIES-102", "Ingeniería Industrial", "Ingeniería"));
        secuenciaId += 10;
        LISTA_PROGRAMAS.add(new ProgramaAcademico(secuenciaId, "SNIES-103", "Matemática", "Ciencias y Educación"));
        secuenciaId += 10;
        LISTA_PROGRAMAS.add(new ProgramaAcademico(secuenciaId, "SNIES-104", "Administración de empresas", "Ciencias Económicas"));
        secuenciaId += 10;
        LISTA_PROGRAMAS.add(new ProgramaAcademico(secuenciaId, "SNIES-105", "Derecho", "Ciencias Jurídicas"));
        secuenciaId += 10;
        LISTA_PROGRAMAS.add(new ProgramaAcademico(secuenciaId, "SNIES-106", "Ingeniería Temática", "Tecnológica"));
        secuenciaId += 10;
    }

    public List<ProgramaAcademico> findAll() {
        return LISTA_PROGRAMAS;
    }

    public void save(ProgramaAcademico programa) {
        programa.setId(secuenciaId);
        secuenciaId += 10;
        LISTA_PROGRAMAS.add(programa);
    }

    public void deleteById(int id) {
        LISTA_PROGRAMAS.removeIf(p -> p.getId() == id);
    }

    public boolean existsByNombre(String nombre) {
        return LISTA_PROGRAMAS.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre.trim()));
    }
}
