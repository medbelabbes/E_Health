package Entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ModeleQuestionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModeleQuestionnaire;

    private String questionnaire;

    //Une Questionnaire posséde plusiéure questions
    @OneToMany(mappedBy = "modeleQuestionnaire")
    private List<ModeleQuestion> LesModelesQuestions = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name = "idService")
    private Service service;


    public ModeleQuestionnaire() {
    }

    public ModeleQuestionnaire(String questionnaire, List<ModeleQuestion> lesModelesQuestions, Service service) {
        this.questionnaire = questionnaire;
        LesModelesQuestions = lesModelesQuestions;
        this.service = service;
    }

    public int getIdModeleQuestionnaire() {
        return idModeleQuestionnaire;
    }

    public void setIdModeleQuestionnaire(int idModeleQuestionnaire) {
        this.idModeleQuestionnaire = idModeleQuestionnaire;
    }

    public String getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(String questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<ModeleQuestion> getLesModelesQuestions() {
        return LesModelesQuestions;
    }

    public void setLesModelesQuestions(List<ModeleQuestion> lesModelesQuestions) {
        LesModelesQuestions = lesModelesQuestions;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


}

