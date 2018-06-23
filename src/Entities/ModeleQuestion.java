package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ModeleQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModeleQuestion;

    @NotNull
    @Size(min = 5, max = 500)
    private String Question;

    // Une question posséde plusiéurs choix
    @OneToMany(mappedBy = "modeleQuestion")
    private List<ModeleChoix> LesModelesChoix = new ArrayList<>();

    //Il y a plusieure questions pour un questionnaire

   @ManyToOne
   @JoinColumn(name = "idModeleQuestionnaire")
    private ModeleQuestionnaire modeleQuestionnaire;


    public ModeleQuestion() {
    }

    public ModeleQuestion(@NotNull @Size(min = 5, max = 500) String question, List<ModeleChoix> lesModelesChoix, ModeleQuestionnaire modeleQuestionnaire) {
        Question = question;
        LesModelesChoix = lesModelesChoix;
        this.modeleQuestionnaire = modeleQuestionnaire;
    }

    public int getIdModeleQuestion() {
        return idModeleQuestion;
    }

    public void setIdModeleQuestion(int idModeleQuestion) {
        this.idModeleQuestion = idModeleQuestion;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public List<ModeleChoix> getLesModelesChoix() {
        return LesModelesChoix;
    }

    public void setLesModelesChoix(List<ModeleChoix> lesModelesChoix) {
        LesModelesChoix = lesModelesChoix;
    }

    public ModeleQuestionnaire getModeleQuestionnaire() {
        return modeleQuestionnaire;
    }

    public void setModeleQuestionnaire(ModeleQuestionnaire modeleQuestionnaire) {
        this.modeleQuestionnaire = modeleQuestionnaire;
    }
}

