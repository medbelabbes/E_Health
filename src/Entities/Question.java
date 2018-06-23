package Entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestion;

    @NotNull
    @Size(min = 5, max = 100)
    private String Question;

    // Une question posséde plusiéure choix
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Choix> LesChoix = new HashSet<>();

    //Il y a plusieure questions pour un questionnaire
//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name="idQuestionnaire.medecin"),
//            @JoinColumn(name="idQuestionnaire.patient")})
//    private Questionnaire questionnaire;


    public Question() {
    }

    public Question(@NotNull @Size(min = 5, max = 100) String question, Set<Choix> lesChoix) {
        Question = question;
        LesChoix = lesChoix;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Set<Choix> getLesChoix() {
        return LesChoix;
    }

    public void setLesChoix(Set<Choix> lesChoix) {
        LesChoix = lesChoix;
    }
}
