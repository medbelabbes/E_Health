package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Choix implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChoix;

    @NotNull
    @Size(min = 1,max = 200)
    private String Choix;


    @Column(length = 4)
    private String Choisi;



    //Une question posséde plusiéure choix possibles
    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question question;

    public Choix() {
    }

    public Choix(@NotNull @Size(min = 1, max = 200) String choix, String choisi, Question question) {
        Choix = choix;
        Choisi = choisi;
        this.question = question;
    }

    public int getIdChoix() {
        return idChoix;
    }

    public void setIdChoix(int idChoix) {
        this.idChoix = idChoix;
    }

    public String getChoix() {
        return Choix;
    }

    public void setChoix(String choix) {
        Choix = choix;
    }

    public String getChoisi() {
        return Choisi;
    }

    public void setChoisi(String choisi) {
        Choisi = choisi;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
