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

@NamedQueries({
        @NamedQuery(name = "FIND_BY_LOGIN_MEDECIN", query = "SELECT m FROM Medecin m WHERE m.email = :email AND m.password = :password "),
        @NamedQuery(name = "CHECK_CHEF_SERVICE", query = "SELECT s FROM Service s WHERE s.idService = :idMedecin")
})

@Entity
public class Medecin  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedecin;

    @Size(min = 3, max = 45)
    private String nom;


    @Size(min = 3, max = 45)
    private String prenom;


    @Enumerated(EnumType.STRING)
    private Sexe sexe;


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

    @NotNull
    @Column(unique = true)
    private String email;


    private String telephone;


    private String specialite;


    private String grade;


    private String password;

    @Embedded
    private Adresse adresse;

    //Un medecin est résponsable d'un patient(dossier médical)
    @OneToMany(mappedBy = "idDossierMedical.medecin", cascade = CascadeType.ALL)
    private Set<DossierMedical> LesDossiersMedicaux = new HashSet<>();

    // Un médecin peut étre un chef d'un seul service
    @OneToOne(mappedBy = "chefService", cascade = CascadeType.PERSIST)
    private Service Service;

    //Un medecin est inclu à plusieurs service et un service posséde plusiéur médedcin
    @ManyToMany
    @JoinTable(name = "Medecin_Service",
            joinColumns = @JoinColumn(name = "idMedecin"),
            inverseJoinColumns = @JoinColumn(name = "idService"))
    private Set<Service> LesServices = new HashSet<>();

    //Un medecin intervient dans plusiéurs opérations
    @OneToMany(mappedBy = "medecin")
    private Set<Operation> operations;


    //un medecin peut editer plusiéurs questionnaires
    @OneToMany(mappedBy = "idQuestionnaire.medecin", cascade = CascadeType.ALL)
    private Set<Questionnaire> LesQuestionnaires = new HashSet<>();

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Set<Agenda> lesAgenda;


    public Medecin() {
    }

    public Medecin(@Size(min = 3, max = 45) String nom, @Size(min = 3, max = 45) String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<DossierMedical> getLesDossiersMedicaux() {
        return LesDossiersMedicaux;
    }

    public void setLesDossiersMedicaux(Set<DossierMedical> lesDossiersMedicaux) {
        LesDossiersMedicaux = lesDossiersMedicaux;
    }

    public Entities.Service getService() {
        return Service;
    }

    public void setService(Entities.Service service) {
        Service = service;
    }

    public Set<Entities.Service> getLesServices() {
        return LesServices;
    }

    public void setLesServices(Set<Entities.Service> lesServices) {
        LesServices = lesServices;
    }


    public Set<Questionnaire> getLesQuestionnaires() {
        return LesQuestionnaires;
    }

    public void setLesQuestionnaires(Set<Questionnaire> lesQuestionnaires) {
        LesQuestionnaires = lesQuestionnaires;
    }

    public Set<Agenda> getLesAgenda() {
        return lesAgenda;
    }

    public void setLesAgenda(Set<Agenda> lesAgenda) {
        this.lesAgenda = lesAgenda;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }


    @Override
    public String toString() {
        return this.getIdMedecin()+" "+this.getNom()+" "+this.getPrenom()+" "+this.getGrade();
    }
}
