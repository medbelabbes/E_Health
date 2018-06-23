package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TraitementActuel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTraitementActuel;

    //un seul traitment pour un patient(dossier médical)
    @OneToOne(mappedBy = "traitementActuel", cascade = CascadeType.PERSIST)
    private DossierMedical dossierMedical;

    //un traitement posséde plusieurs médicaments
    @OneToMany(mappedBy = "traitementActuel")
    private Set<Medicament> LesMedicaments = new HashSet<>();

    public TraitementActuel() {
    }

    public TraitementActuel(DossierMedical dossierMedical, Set<Medicament> lesMedicaments) {
        this.dossierMedical = dossierMedical;
        LesMedicaments = lesMedicaments;
    }

    public int getIdTraitementActuel() {
        return idTraitementActuel;
    }

    public void setIdTraitementActuel(int idTraitementActuel) {
        this.idTraitementActuel = idTraitementActuel;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public Set<Medicament> getLesMedicaments() {
        return LesMedicaments;
    }

    public void setLesMedicaments(Set<Medicament> lesMedicaments) {
        LesMedicaments = lesMedicaments;
    }
}
