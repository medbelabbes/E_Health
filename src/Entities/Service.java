package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idService;

    @NotNull
    @Size(min = 5, max = 45)
    private String designation;

    @OneToOne
    @JoinColumn(name = "idMedecin")
    private Medecin chefService;
    // un service possede plusieur médecins
    @ManyToMany(mappedBy = "LesServices")
    private Set<Medecin> LesMedecins = new HashSet<>();


        //un service possede un modele de questionnaire
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<ModeleQuestionnaire> LesModelsQuestionnaires = new HashSet<>();

    public Service() {
    }

    public Service(@NotNull @Size(min = 5, max = 45) String designation, Medecin chefService, Set<Medecin> lesMedecins, Set<ModeleQuestionnaire> lesModelsQuestionnaires) {
        this.designation = designation;
        this.chefService = chefService;
        LesMedecins = lesMedecins;
        LesModelsQuestionnaires = lesModelsQuestionnaires;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Medecin getChefService() {
        return chefService;
    }

    public void setChefService(Medecin chefService) {
        this.chefService = chefService;
    }

    public Set<Medecin> getLesMedecins() {
        return LesMedecins;
    }

    public void setLesMedecins(Set<Medecin> lesMedecins) {
        LesMedecins = lesMedecins;
    }

    public Set<ModeleQuestionnaire> getLesModelsQuestionnaires() {
        return LesModelsQuestionnaires;
    }

    public void setLesModelsQuestionnaires(Set<ModeleQuestionnaire> lesModelsQuestionnaires) {
        LesModelsQuestionnaires = lesModelsQuestionnaires;
    }

}
