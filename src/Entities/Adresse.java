package Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {


    @NotNull
    @Size(min = 3,max = 40)
    private String rue;

    @NotNull
    private int nuemro;

    @NotNull
    @Size(min = 3,max = 10)
    @Column(name = "code_postal")
    private String codePostale;

    @NotNull
    @Size(min = 3,max = 25)
    private String ville;

    public String getRue() {
        return rue;
    }

    public Adresse() {
    }

    public Adresse(@NotNull @Size(min = 3, max = 40) String rue, @NotNull int nuemro, @NotNull @Size(min = 3, max = 10) String codePostale, @NotNull @Size(min = 3, max = 25) String ville) {
        this.rue = rue;
        this.nuemro = nuemro;
        this.codePostale = codePostale;
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNuemro() {
        return nuemro;
    }

    public void setNuemro(int nuemro) {
        this.nuemro = nuemro;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
