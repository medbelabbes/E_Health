package Controllers.Medecin;


import DAO.IDAO.IPatientDAO;
import Entities.Patient;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
/**
 * Created by amjad on 09/06/2018.
 */
@Named(value = "medecinController")
@RequestScoped
public class MedecinController implements Serializable {
    @PostConstruct
    public void init(){

        patientListe=patientDAO.findAll();
//       filteredPatients=patientDAO.findAll();
    }

    @EJB
    IPatientDAO patientDAO;


    private List<Patient> filteredPatients;
    private Patient selectedPatient;
    private List<Patient> patientListe;



    public void save(ActionEvent actionEvent) {
        addMessage("Data saved");
    }

    public void update(ActionEvent actionEvent) {
        addMessage("Data updated");
    }

    public void delete(ActionEvent actionEvent) {
        addMessage("Data deleted");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void toggle(){
//        showPassword=!showPassword;
        System.out.println("show password ");
    }
    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public List<Patient> getFilteredPatients() {
        return filteredPatients;
    }

    public void setFilteredPatients(List<Patient> filteredPatients) {
        this.filteredPatients = filteredPatients;
    }

    public List<Patient> getPatientListe() {
        return patientListe;
    }

    public void setPatientListe(List<Patient> patientListe) {
        this.patientListe = patientListe;
    }


}


