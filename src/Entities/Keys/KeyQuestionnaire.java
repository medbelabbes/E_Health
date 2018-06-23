package Entities.Keys;

import Entities.Medecin;
import Entities.Patient;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class KeyQuestionnaire implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    private Patient patient;

    public KeyQuestionnaire() {
    }

    public KeyQuestionnaire(Medecin medecin, Patient patient) {
        this.medecin = medecin;
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
