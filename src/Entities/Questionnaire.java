package Entities;

import Entities.Keys.KeyQuestionnaire;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Questionnaire implements Serializable {

    @EmbeddedId
    private KeyQuestionnaire idQuestionnaire;

//     Une Questionnaire posséde plusiéure questions
//    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL)
//    private Set<Question> LesQuestions = new HashSet<>();


    public Questionnaire() {
    }

    public Questionnaire(KeyQuestionnaire idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public KeyQuestionnaire getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(KeyQuestionnaire idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }
}
