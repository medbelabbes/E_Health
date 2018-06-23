package Controllers.Medecin;

import DAO.IDAO.IDossierMedicalDAO;
import DAO.IDAO.IVisiteDAO;
import Entities.DossierMedical;
import Entities.Keys.KeyDossierMedical;
import Entities.Visite;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static Controllers.security.UserSessionController.idMedecin;

/**
 * Created by amjad on 12/06/2018.
 */
@Named(value = "dossierMedController")
@RequestScoped
public class DossierMedController implements Serializable {

    @EJB
    private IVisiteDAO iVisiteDAO;

    @EJB
    IDossierMedicalDAO dossierMedDAO;


    private Visite visite = new Visite();

    private List<DossierMedical> filtereddossierMeds;
    private DossierMedical selecteddossierMed;
    private KeyDossierMedical iddossierMedical;
    private List<DossierMedical> dossierMedListe;

    @PostConstruct
    public void init() {

        dossierMedListe = dossierMedDAO.findAllByMed(idMedecin);
        filtereddossierMeds = dossierMedDAO.findAll();
    }

    public List<DossierMedical> getFiltereddossierMeds() {
        return filtereddossierMeds;
    }

    public List<Visite> getAllVisites(KeyDossierMedical id) {

        List<Visite> visiteList = iVisiteDAO.dosMedVisites(id);
        System.out.println("size visite list" + visiteList.size());

        return visiteList;
    }

    public void setFiltereddossierMeds(List<DossierMedical> filtereddossierMeds) {
        this.filtereddossierMeds = filtereddossierMeds;
    }

    public KeyDossierMedical getIddossierMedical() {
        return iddossierMedical;
    }

    public void setIddossierMedical(KeyDossierMedical iddossierMedical) {
        this.iddossierMedical = iddossierMedical;
    }

    public DossierMedical getSelecteddossierMed() {
        return selecteddossierMed;
    }

    public void setSelecteddossierMed(DossierMedical selecteddossierMed) {
        this.selecteddossierMed = selecteddossierMed;
    }

    public List<DossierMedical> getDossierMedListe() {
        return dossierMedListe;
    }

    public void setDossierMedListe(List<DossierMedical> dossierMedListe) {
        this.dossierMedListe = dossierMedListe;
    }

    public Visite getVisite() {
        return visite;
    }

    public void setVisite(Visite visite) {
        this.visite = visite;
    }

    public String routeAjouterVisite() {
//        System.out.println("route Ajouter Visite"+iddossierMedical.getMedecin().getIdMedecin()+" "+iddossierMedical.getPatient().getIdPatient());
//        visite=new Visite(iddossierMedical);
//        visite.getDossierMedical().getIdDossierMedical().getMedecin().setIdMedecin(selecteddossierMed.getIdDossierMedical().getMedecin().getIdMedecin());
//        visite.getDossierMedical().getIdDossierMedical().getPatient().setIdPatient(selecteddossierMed.getIdDossierMedical().getPatient().getIdPatient());
        String page = "ajouterVisite.xhtml?faces-redirect=true";
        return page;
    }

    public void addVisite() {

        iVisiteDAO.create(visite);
    }
}