package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class ModeleChoix implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModeleChoix;

    private String choix;


    private String ChoixJuste;

    //Il y a plusieurs choix pour une question
    @ManyToOne
    @JoinColumn(name = "idModeleQuestion")
    private ModeleQuestion modeleQuestion;

    public ModeleChoix() {
    }

    public ModeleChoix(String choix, String choixJuste, ModeleQuestion modeleQuestion) {
        this.choix = choix;
        ChoixJuste = choixJuste;
        this.modeleQuestion = modeleQuestion;
    }

    public int getIdModeleChoix() {
        return idModeleChoix;
    }

    public void setIdModeleChoix(int idModeleChoix) {
        this.idModeleChoix = idModeleChoix;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public String getChoixJuste() {
        return ChoixJuste;
    }

    public void setChoixJuste(String choixJuste) {
        ChoixJuste = choixJuste;
    }

    public ModeleQuestion getModeleQuestion() {
        return modeleQuestion;
    }

    public void setModeleQuestion(ModeleQuestion modeleQuestion) {
        this.modeleQuestion = modeleQuestion;
    }
}
