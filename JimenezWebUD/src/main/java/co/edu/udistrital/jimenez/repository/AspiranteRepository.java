package co.edu.udistrital.jimenez.repository;

import co.edu.udistrital.jimenez.model.Aspirante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AspiranteRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final List<Aspirante> LISTA_ASPIRANTES = new ArrayList<>();

    public List<Aspirante> findAll() {
        return LISTA_ASPIRANTES;
    }

    public void save(Aspirante aspirante) {
        LISTA_ASPIRANTES.add(aspirante);
    }

    public void deleteByIdentificacion(String identificacion) {
        LISTA_ASPIRANTES.removeIf(a -> a.getIdentificacion().equals(identificacion));
    }

    public boolean existsByIdentificacion(String identificacion) {
        return LISTA_ASPIRANTES.stream()
                .anyMatch(a -> a.getIdentificacion().equalsIgnoreCase(identificacion.trim()));
    }
}
