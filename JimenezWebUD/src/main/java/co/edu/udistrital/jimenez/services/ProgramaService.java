package co.edu.udistrital.jimenez.services;

import co.edu.udistrital.jimenez.model.ProgramaAcademico;
import co.edu.udistrital.jimenez.repository.ProgramaRepository;
import java.io.Serializable;
import java.util.List;

public class ProgramaService implements Serializable {

    private static final long serialVersionUID = 1L;
    private ProgramaRepository programaRepository;

    public ProgramaService() {
        this.programaRepository = new ProgramaRepository();
    }

    public List<ProgramaAcademico> listarProgramas() {
        return programaRepository.findAll();
    }

    public boolean registrarPrograma(ProgramaAcademico nuevoPrograma) {
        if (programaRepository.existsByNombre(nuevoPrograma.getNombre())) {
            return false;
        }
        ProgramaAcademico programa = new ProgramaAcademico(
                0,
                nuevoPrograma.getCodigoSnies().trim().toUpperCase(),
                nuevoPrograma.getNombre().trim(),
                nuevoPrograma.getFacultad().trim()
        );
        programaRepository.save(programa);
        return true;
    }

    public void eliminarPrograma(int id) {
        programaRepository.deleteById(id);
    }
}
