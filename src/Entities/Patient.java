package Entities;

import Entities.Types.Sexe;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatient;


    @NotNull
    @Size(min = 3, max = 45)
    private String nom;

    @NotNull
    @Size(min = 3, max = 45)
    private String prenom;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @NotNull
    @Past
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Transient
    private Integer age;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @Embedded
    private Adresse adresse;

    @Column(unique = true)
    private String email;


    private String telephone;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(unique = true)
    private String numeroAS;

    //une patient posséde un seul compte
    @OneToOne(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Compte compte;

    //Un patient peut avoir plusieurs dossiers médicaux
    @OneToMany(mappedBy = "idDossierMedical.patient", cascade = CascadeType.ALL)
    private Set<DossierMedical> LesDossiersMedicaux = new HashSet<>();

    //Un patient a une seul opération
    @OneToOne(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private Operation operation;


    public Patient() {
    }


    public Patient(@NotNull @Size(min = 3, max = 45) String nom, @NotNull @Size(min = 3, max = 45) String prenom, @NotNull Sexe sexe, @NotNull @Past Date dateNaissance, Integer age, @NotNull @Size(min = 3, max = 45) String lieuNaissance, Adresse adresse, String email, String telephone, @NotNull @Size(min = 3, max = 45) String numeroAS) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.numeroAS = numeroAS;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }


    public Adresse getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumeroAS() {
        return numeroAS;
    }

    public void setNumeroAS(String numeroAS) {
        this.numeroAS = numeroAS;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Set<DossierMedical> getLesDossiersMedicaux() {
        return LesDossiersMedicaux;
    }

    public void setLesDossiersMedicaux(Set<DossierMedical> lesDossiersMedicaux) {
        LesDossiersMedicaux = lesDossiersMedicaux;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }



    @Override
    public String toString() {
        return this.getIdPatient()+" "+this.getNom()+" "+this.getPrenom()+" ";
    }

}
