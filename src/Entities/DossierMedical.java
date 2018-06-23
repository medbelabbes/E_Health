package Entities;

import Entities.Keys.KeyDossierMedical;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@NamedQueries({
        @NamedQuery(
                name = "FIND_ALL_BY_MEDECIN", query = "SELECT a FROM DossierMedical a WHERE a.idDossierMedical.medecin.idMedecin = :idMedecin ")
})
@Entity
public class DossierMedical implements Serializable {

    @EmbeddedId
    private KeyDossierMedical idDossierMedical;

    @NotNull
    @Column(name = "Date_Enregistrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;

    private String nbrdossier;

    @NotNull
    @Size(min = 5, max = 30)
    private String etat;

    @NotNull
    @Size(min = 5, max = 500)
    @Column(name = "antecedents_personnels")
    private String antecedentsPersonnels;

    @NotNull
    @Size(min = 5, max = 500)
    @Column(name = "antecedents_familiaux")
    private String antecedentsFamiliaux;

    //Un dossier médical posséde un seul traitement
    @OneToOne
    @JoinColumn(name = "idTraitementActuel")
    private TraitementActuel traitementActuel;

    @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Set<Visite> LesVisites;

            public DossierMedical() {
    }

    public DossierMedical(KeyDossierMedical idDossierMedical, @NotNull Date dateEnregistrement, @NotNull @Size(min = 5, max = 30) String etat, @NotNull @Size(min = 5, max = 500) String antecedentsPersonnels, @NotNull @Size(min = 5, max = 500) String antecedentsFamiliaux, TraitementActuel traitementActuel) {
        this.idDossierMedical = idDossierMedical;
        this.dateEnregistrement = dateEnregistrement;
        this.etat = etat;
        this.antecedentsPersonnels = antecedentsPersonnels;
        this.antecedentsFamiliaux = antecedentsFamiliaux;
        this.traitementActuel = traitementActuel;
    }



    public KeyDossierMedical getIdDossierMedical() {
        return idDossierMedical;
    }

    public void setIdDossierMedical(KeyDossierMedical idDossierMedical) {
        this.idDossierMedical = idDossierMedical;
    }

    public String getNbrdossier() {
        return nbrdossier;
    }

    public void setNbrdossier(String nbrdossier) {
        this.nbrdossier = nbrdossier;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getAntecedentsPersonnels() {
        return antecedentsPersonnels;
    }

    public void setAntecedentsPersonnels(String antecedentsPersonnels) {
        this.antecedentsPersonnels = antecedentsPersonnels;
    }

    public String getAntecedentsFamiliaux() {
        return antecedentsFamiliaux;
    }

    public void setAntecedentsFamiliaux(String antecedentsFamiliaux) {
        this.antecedentsFamiliaux = antecedentsFamiliaux;
    }

    public TraitementActuel getTraitementActuel() {
        return traitementActuel;
    }

    public void setTraitementActuel(TraitementActuel traitementActuel) {
        this.traitementActuel = traitementActuel;
    }

    public Set<Visite> getLesVisites() {
        return LesVisites;
    }

    public void setLesVisites(Set<Visite> lesVisites) {
        LesVisites = lesVisites;
    }
}
