package Entities;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Medicament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicament;

    @NotNull
    @Size(min = 3, max = 500)
    private String designation;

    @NotNull
    @URL
    @Column(nullable = true, length = 2000)
    private String url;

    //Un médicament est inclu dans un traitement
    @ManyToOne
    @JoinColumn(name = "idTraitementActuel")
    private TraitementActuel traitementActuel;

    public Medicament(@NotNull @Size(min = 3, max = 500) String designation, @NotNull @URL String url, TraitementActuel traitementActuel) {
        this.designation = designation;
        this.url = url;
        this.traitementActuel = traitementActuel;
    }

    public Medicament() {
    }

    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TraitementActuel getTraitementActuel() {
        return traitementActuel;
    }

    public void setTraitementActuel(TraitementActuel traitementActuel) {
        this.traitementActuel = traitementActuel;
    }
}
