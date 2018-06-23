package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Visite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVisite;

    private Date date;


    private String motif;


    public Visite(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    //    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "idDossierMedical")

    @ManyToOne(cascade = CascadeType.ALL)
    private DossierMedical dossierMedical;

    public Visite() {
    }

    public Visite(Date date, String motif) {
        this.date = date;
        this.motif = motif;
    }

    public int getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }
}
