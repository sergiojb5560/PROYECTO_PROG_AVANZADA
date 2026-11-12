package co.edu.udistrital.jimenez.services;

import co.edu.udistrital.jimenez.model.Aspirante;
import co.edu.udistrital.jimenez.repository.AspiranteRepository;
import java.io.Serializable;
import java.util.List;

public class AspiranteService implements Serializable {

    private static final long serialVersionUID = 1L;
    private AspiranteRepository aspiranteRepository;

    public AspiranteService() {
        this.aspiranteRepository = new AspiranteRepository();
    }

    public List<Aspirante> listarAspirantes() {
        return aspiranteRepository.findAll();
    }

    public boolean registrarAspirante(Aspirante nuevoAspirante) {
        if (aspiranteRepository.existsByIdentificacion(nuevoAspirante.getIdentificacion())) {
            return false;
        }
        Aspirante aspirante = new Aspirante(
                nuevoAspirante.getIdentificacion().trim(),
                nuevoAspirante.getNombres().trim(),
                nuevoAspirante.getApellidos().trim(),
                nuevoAspirante.getCorreo().trim().toLowerCase(),
                nuevoAspirante.getTelefono().trim(),
                nuevoAspirante.getProgramaInteresado()
        );
        aspiranteRepository.save(aspirante);
        return true;
    }

    public void eliminarAspirante(String identificacion) {
        aspiranteRepository.deleteByIdentificacion(identificacion);
    }
}
