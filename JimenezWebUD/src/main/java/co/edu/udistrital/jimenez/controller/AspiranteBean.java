package co.edu.udistrital.jimenez.controller;

import co.edu.udistrital.jimenez.model.Aspirante;
import co.edu.udistrital.jimenez.model.ProgramaAcademico;
import co.edu.udistrital.jimenez.services.AspiranteService;
import co.edu.udistrital.jimenez.services.ProgramaService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("aspiranteBean")
@SessionScoped
public class AspiranteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Aspirante aspiranteActual;
    private ProgramaAcademico programaActual;

    private AspiranteService aspiranteService;
    private ProgramaService programaService;

    @PostConstruct
    public void init() {
        aspiranteActual = new Aspirante();
        programaActual = new ProgramaAcademico();
        aspiranteService = new AspiranteService();
        programaService = new ProgramaService();
    }

    public void guardarAspirante() {
        boolean exito = aspiranteService.registrarAspirante(aspiranteActual);
        if (exito) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Registro exitoso",
                            "El aspirante " + aspiranteActual.getNombres() + " fue registrado."));
            aspiranteActual = new Aspirante();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Identificación duplicada",
                            "Ya existe un aspirante con la identificación " + aspiranteActual.getIdentificacion()));
        }
    }

    public void eliminarAspirante(String identificacion) {
        aspiranteService.eliminarAspirante(identificacion);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Aspirante eliminado",
                        "Se eliminó el registro con identificación " + identificacion));
    }

    public void guardarPrograma() {
        boolean exito = programaService.registrarPrograma(programaActual);
        if (exito) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Programa creado",
                            "El programa " + programaActual.getNombre() + " fue agregado."));
            programaActual = new ProgramaAcademico();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Programa duplicado",
                            "El programa " + programaActual.getNombre() + " ya existe."));
        }
    }

    public void eliminarPrograma(int id) {
        programaService.eliminarPrograma(id);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Programa eliminado",
                        "El programa académico fue eliminado."));
    }

    public List<Aspirante> getListaAspirantes() {
        return aspiranteService.listarAspirantes();
    }

    public List<ProgramaAcademico> getListaProgramas() {
        return programaService.listarProgramas();
    }

    public Aspirante getAspiranteActual() {
        return aspiranteActual;
    }

    public void setAspiranteActual(Aspirante aspiranteActual) {
        this.aspiranteActual = aspiranteActual;
    }

    public ProgramaAcademico getProgramaActual() {
        return programaActual;
    }

    public void setProgramaActual(ProgramaAcademico programaActual) {
        this.programaActual = programaActual;
    }
}
