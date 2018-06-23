package Controllers.Medecin;

import DAO.IDAO.IPatientDAO;
import Entities.Adresse;
import Entities.Patient;
import Entities.Types.Sexe;
import org.primefaces.event.FlowEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
/**
 * Created by amjad on 12/06/2018.
 */
@Named(value = "patientWizard")
    @ViewScoped
    public class PatientWizard implements Serializable {

    private Patient patient = new Patient();
    private Adresse adresse=new Adresse();
    private Sexe sexe;

    @EJB
    IPatientDAO patientDAO;

    @PostConstruct
    public void init(){
        patient.setAdresse(adresse);
    }

    private boolean skip;

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient Patient) {
        this.patient = patient;
    }

    public void save() throws IOException {
        System.out.println("Save patient "+ patient.getNom()+" "+patient.getPrenom()+" "+patient.getEmail()+" "+patient.getLieuNaissance()+" "+patient.getDateNaissance()+" "+patient.getNumeroAS()+" "+patient.getAdresse().getRue()+" "+patient.getAdresse().getCodePostale()+" "+patient.getAdresse().getVille()+" "+patient.getAdresse().getNuemro()+patient.getTelephone());
//       patient.setIdPatient(99);
        patientDAO.create(patient);

        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + patient.getNom()+" "+patient.getPrenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
//        return "views/admin/index";

 }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case Patient goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public String  addPatient(){
        patientDAO.create(patient);
        return "views/medecin/index.xhtml?faces-redirect=true";
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
}
