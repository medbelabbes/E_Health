package Entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOperation;

    @NotNull
    @Column(name = "nuemro_salle")
    private int numeroSalle;

    @NotNull
    @Future
    @Column(name = "date_operation")
    private Date dateOperation;



    @Lob
    @Column(name = "rapport_operation")
    private byte[] rappotOperation;

    //Une opération pour un patient
    @OneToOne
    @JoinColumn(name = "idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="idMedecin")
    private Medecin medecin;

    // Une opération posséde plusiéurs consignes
    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL)
    private Set<Consigne> LesConsignes = new HashSet<>();

    // Une opération est faite par plusiéurs medecins
//    @ManyToMany(mappedBy = "LesOperations")
//    private Set<Medecin> LesMedecins = new HashSet<>();

    //une periode de preopration pour une opération

    @OneToOne(mappedBy = "operation", cascade = CascadeType.PERSIST)
    private PreOperation preOperation;

    //un période de postopératon pour une opération
    @OneToOne(mappedBy = "operation", cascade = CascadeType.PERSIST)
    private PostOperation postOperation;

    public Operation() {
    }

    public Operation(@NotNull int numeroSalle, @NotNull @Future Date dateOperation, Patient patient, Medecin medecin) {
        this.numeroSalle = numeroSalle;
        this.dateOperation = dateOperation;
        this.patient = patient;
        this.medecin = medecin;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public int getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(int numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }


    public byte[] getRappotOperation() {
        return rappotOperation;
    }

    public void setRappotOperation(byte[] rappotOperation) {
        this.rappotOperation = rappotOperation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Consigne> getLesConsignes() {
        return LesConsignes;
    }

    public void setLesConsignes(Set<Consigne> lesConsignes) {
        LesConsignes = lesConsignes;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public PreOperation getPreOperation() {
        return preOperation;
    }

    public void setPreOperation(PreOperation preOperation) {
        this.preOperation = preOperation;
    }

    public PostOperation getPostOperation() {
        return postOperation;
    }

    public void setPostOperation(PostOperation postOperation) {
        this.postOperation = postOperation;
    }


    @Override
    public String toString() {
        return this.getIdOperation()+" "+this.getDateOperation().toString()+" "+this.getNumeroSalle();
    }
}
