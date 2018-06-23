package Entities.Keys;

import Entities.Medecin;
import Entities.Patient;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class KeyDossierMedical implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;

    public KeyDossierMedical() {
    }

    public KeyDossierMedical(Patient patient, Medecin medecin) {
        this.patient = patient;
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
