package Controllers.Admin;


import DAO.IDAO.*;
import Entities.*;
import Entities.Types.Sexe;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.*;

@Named(value = "adminController")
@SessionScoped
public class AdminController implements Serializable {


    //Service Attributs
    private int idService;
    private int idServiceQuestionnaire;
    private String designation;
    private int idChef;
    private List<Medecin> lesMedecins = new ArrayList<>();
    private boolean checked;
    private Set<ModeleQuestionnaire> LesModelsQuestionnaires = new HashSet<>();
    private List<Service> lesServices = new ArrayList<>();
    private Set<Service> services = new HashSet<>();
    private List<Integer> idServices;
    private static int idServiceStatic;

    @EJB
    private IServiceDAOLocal iServiceDAOLocal;


    //Medecin Attributs
    private int idMedecin;
    private String nom;
    private String prenom;
    private String fullName;
    private Sexe sexe;
    private Date dateNaissance;
    private String lieuNaissance;
    private String email;
    private String telephone;
    private String specialite;
    private String grade;
    private String password;
    private String rue;
    private int numero;
    private String ville;
    private String codePostale;
    private List<Medecin> toutMedecins = new ArrayList<>();
    private Set<DossierMedical> LesDossiersMedicaux = new HashSet<>();
    private Service service;
    private Set<Service> LesServices = new HashSet<>();
    private List<Integer> idChefList;
    private Medecin medecin = new Medecin();


    @EJB
    private IMedecinDAOLocal iMedecinDAOLocal;

    //Questionnaire attributs
    // Modele Questionnaire attributs
    private int idModeleQuestionnaire;
    private static int idModeleQ;
    private String questionnaire;
    private String modeleQuestionnaire;
    private String modeleQuestionnairename;
    private List<ModeleQuestionnaire> modelesQuestioniaresList = new ArrayList<>();
    private List<ModeleQuestion> LesModelesQuestions = new ArrayList<>();


    @EJB
    private IModeleQuestionnaireDAOLocal iModeleQuestionnaireDAOLocal;

    // Modele Question Attributs
    private int idModeleQuestion;
    private String question;


    @EJB
    private IModeleQuestionDAOLocal iModeleQuestionDAOLocal;


    //Modele choix Attributs

    private int idModeleChoix;
    private String choix;
    private static int idModeleC;
    private String ChoixJuste;
    private ModeleQuestion modeleQuestion;
    private List<ModeleChoix> LesModelesChoix = new ArrayList<>();

    @EJB
    private IModeleChoixDAOLocal iModeleChoixDAOLocal;


    //Service methods

    @PostConstruct
    public void getServices() {
        lesServices = iServiceDAOLocal.findAll();
        idChefList = new ArrayList<>();
        toutMedecins = iMedecinDAOLocal.findAll();
    }

    public String goToAddService() {
        getServices();
        toutMedecins = iMedecinDAOLocal.findAll();
        toutMedecins = iMedecinDAOLocal.findAll();
        return "create.xhtml?faces-redirect=true";
    }

    public List<Integer> getIdChefService() {
        idChefList = new ArrayList<>();
        toutMedecins = iMedecinDAOLocal.findAll();
        idChefList = iMedecinDAOLocal.getAllIdMedecin();
        if (!idChefList.isEmpty()) {
            idChefList.set(0, idChefList.get(0));
        }
        return idChefList;
    }

    public String addService() {
        toutMedecins = iMedecinDAOLocal.findAll();
        String page = "create.xhtml?faces-redirect=true";
        Service service = new Service();
        if (!checked) {
            if (!designation.equals(null) && idChef != 0) {
                service.setDesignation(designation);
                Medecin chefService = iMedecinDAOLocal.find(idChef);
                service.setChefService(chefService);
                iServiceDAOLocal.create(service);
                page = "index.xhtml?faces-redirect=true";
            }
        } else {

            service.setDesignation(designation);
            iServiceDAOLocal.create(service);
            page = "index.xhtml?faces-redirect=true";
        }
        getServices();
        designation = null;
        return page;
    }


    public String getDataService(int id) {
        toutMedecins = iMedecinDAOLocal.findAll();
        Service s;
        s = iServiceDAOLocal.find(id);
        idService = s.getIdService();
        designation = s.getDesignation();
        idChef = s.getChefService().getIdMedecin();
        getServices();
        return "edit.xhtml?faces-redirect=true";
    }

    public String editService() {
        toutMedecins = iMedecinDAOLocal.findAll();
        Service s = new Service();
        s.setIdService(idService);
        s.setDesignation(designation);
        s.setChefService(iMedecinDAOLocal.find(this.idChef));
        iServiceDAOLocal.edit(s);
        getServices();
        return "index.xhtml?faces-redirect=true";
    }


    public String deleteService(int idService) {
        //toutMedecins = iMedecinDAOLocal.findAll();
        Service s = iServiceDAOLocal.find(idService);
        iServiceDAOLocal.remove(s);
        getServices();
        return "index.xhtml?faces-redirect=true";
    }

    //Medecin methods


    public String getDataMedecin(int idMedecin) {
        toutMedecins = iMedecinDAOLocal.findAll();
        medecin = iMedecinDAOLocal.find(idMedecin);
        this.idMedecin = idMedecin;
        // idService = m.getService().getIdService();
        nom = medecin.getNom();
        prenom = medecin.getPrenom();
        sexe = medecin.getSexe();
        dateNaissance = medecin.getDateNaissance();
        lieuNaissance = medecin.getLieuNaissance();
        email = medecin.getEmail();
        telephone = medecin.getTelephone();
        specialite = medecin.getSpecialite();
        grade = medecin.getGrade();
        Adresse adresse = medecin.getAdresse();
        numero = adresse.getNuemro();
        rue = adresse.getRue();
        ville = adresse.getVille();
        codePostale = adresse.getCodePostale();
        getMedecins(idService);
        return "edit.xhtml?faces-redirect=true";
    }


    public void getMedecins(int idService) {
        toutMedecins = iMedecinDAOLocal.findAll();
        this.idService = idService;
        lesMedecins = iMedecinDAOLocal.findMedecinsByService(idService);
    }

    public String getMedecinsPage(int idService) {
        getMedecins(idService);
        toutMedecins = iMedecinDAOLocal.findAll();
        this.idService = idService;
        return "/views/admin/medecin/index.xhtml?faces-redirect=true";
    }

    public String goToAddMedecin() {
        toutMedecins = iMedecinDAOLocal.findAll();
        getMedecins(this.idService);
        return "create.xhtml?faces-redirect=true";
    }

    public List<Sexe> getSexeMedecin() {
        List<Sexe> l = new ArrayList<>();
        l.clear();
        l.add(Sexe.masculin);
        l.add(Sexe.femenin);
        return l;
    }

    public String addMedecin() {
        toutMedecins = iMedecinDAOLocal.findAll();
        Medecin m = new Medecin();
        m.setNom(nom);
        m.setPrenom(prenom);
        m.setSexe(sexe);
        m.setDateNaissance(dateNaissance);
        m.setLieuNaissance(lieuNaissance);
        m.setEmail(email);
        m.setTelephone(telephone);
        m.setSpecialite(specialite);
        m.setGrade(grade);
        Adresse adresse = new Adresse();
        adresse.setNuemro(numero);
        adresse.setRue(rue);
        adresse.setCodePostale(codePostale);
        adresse.setVille(ville);
        m.setAdresse(adresse);
        m.setPassword("123456");
        Service s = iServiceDAOLocal.find(this.idService);
        Set<Service> lesServices = new HashSet<>();
        lesServices.add(s);
        m.setLesServices(lesServices);
        iMedecinDAOLocal.create(m);
        getMedecins(s.getIdService());
        return "index.xhtml?faces-redirect=true";
    }

    public String editMedecin() {
        //toutMedecins = iMedecinDAOLocal.findAll();
        Medecin m = new Medecin();
        m.setNom(nom);
        m.setPrenom(prenom);
        m.setSexe(sexe);
        m.setDateNaissance(dateNaissance);
        m.setLieuNaissance(lieuNaissance);
        m.setEmail(email);
        m.setTelephone(telephone);
        m.setSpecialite(specialite);
        m.setGrade(grade);
        m.setPassword(iMedecinDAOLocal.find(this.medecin.getIdMedecin()).getPassword());
        Adresse adresse = new Adresse();
        adresse.setNuemro(numero);
        adresse.setRue(rue);
        adresse.setCodePostale(codePostale);
        adresse.setVille(ville);
        m.setAdresse(adresse);
        Service s = iServiceDAOLocal.find(this.idService);
        Set<Service> lesServices = new HashSet<>();
        lesServices.add(s);
        m.setLesServices(lesServices);
        iMedecinDAOLocal.edit(m);
        getMedecins(this.idService);
        return "index.xhtml?faces-redirect=true";
    }

    public void sendMail(String email) {
        try {
            String host = "smtp.gmail.com";
            String user = "ehealth.esisba@gmail.com";
            String pass = "e-health.esi-sba";
            String from = "ehealth.esisba@gmail.com";


            String to = email;
            String subject = "Platform E-Health";
            String password = iMedecinDAOLocal.findPassword(email);
            String messageText = "Email: " + email + "\n" + "  Mot de passe: " + password;
            boolean sessionDebug = false;
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public int getIdServiceQuestionnaire() {
        return idServiceQuestionnaire;
    }

    public List<Integer> getIdServices() {
        idServices = new ArrayList<>();
        idServices = iServiceDAOLocal.getIdServices();
        return idServices;
    }


    public void setIdServiceQuestionnaire(int idServiceQuestionnaire) {
        this.idServiceQuestionnaire = idServiceQuestionnaire;
    }

    public String deleteMedecin(int idMedecin) {
        toutMedecins = iMedecinDAOLocal.findAll();
        Medecin m = iMedecinDAOLocal.find(idMedecin);
        iMedecinDAOLocal.remove(m);
        getMedecins(this.idService);
        return getMedecinsPage(this.idService);
    }


    // Modele Questionnaire methodes

    public void getModeleQusQestionnaires(int idService) {
        this.idService = idService;
        modelesQuestioniaresList = iModeleQuestionnaireDAOLocal.findModeleQuestionnareByService(this.idService);
    }

    public String getModelesQuestionnairesPage(int idService) {
        this.idService = idService;
        getModeleQusQestionnaires(idService);
        return "/views/admin/questionnaire/questionnaire.xhtml?faces-redirect=true";
    }

    public String addModeleQuestionnaire() {
        ModeleQuestionnaire mq = new ModeleQuestionnaire();
        mq.setQuestionnaire(this.modeleQuestionnairename);
        mq.setService(iServiceDAOLocal.find(this.idService));
        iModeleQuestionnaireDAOLocal.create(mq);
        getModelesQuestionnairesPage(this.idService);
        //    refreshQuestionsTable(idModeleQ);
        return "/views/admin/questionnaire/questionnaire.xhtml?faces-redirect=true";
    }


    //Modele question methods

    public void getQuestions(int idModeleQuestionnaire) {
        this.idModeleQuestionnaire = idModeleQuestionnaire;
        idModeleQ = idModeleQuestionnaire;
        LesModelesQuestions = iModeleQuestionDAOLocal.findQuestionsByQuestionnare(this.idModeleQuestionnaire);
    }


    public void refreshQuestionsTable(int idModeleQuestionnaire) {
        this.idModeleQuestionnaire = idModeleQuestionnaire;
        idModeleQ = idModeleQuestionnaire;
        getQuestions(this.idModeleQuestionnaire);
    }

    public String getModeleQuestionPage(int idModeleQuestionnaire) {
        getQuestions(idModeleQuestionnaire);
        return "questions.xhtml?faces-redirect=true";
    }

    public String addModeleQuestion() {
        ModeleQuestion mq = new ModeleQuestion();
        mq.setQuestion(question);
        mq.setModeleQuestionnaire(iModeleQuestionnaireDAOLocal.find(idModeleQ));
        iModeleQuestionDAOLocal.create(mq);
        getModeleQuestionPage(getIdModeleQ());
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteQuestion(int idModeleQuestion) {
        //  toutMedecins = iMedecinDAOLocal.findAll();
        ModeleQuestion mq = iModeleQuestionDAOLocal.find(idModeleQuestion);
        iModeleQuestionDAOLocal.remove(mq);
        getQuestions(this.idModeleQuestionnaire);
        return getModeleQuestionPage(this.idModeleQuestionnaire);
    }

    // modele CHoix methodes

    public void getChoices(int idModeleQuestion) {
        this.idModeleQuestion = idModeleQuestion;
        idModeleC = idModeleQuestion;
        LesModelesChoix = iModeleChoixDAOLocal.getChoixByQuestions(this.idModeleQuestion);
    }


    public String getModeleChoixPage(int idModeleQuestion) {
        getChoices(idModeleQuestion);
        int i = 1;
        for (ModeleChoix m : LesModelesChoix) {
            System.out.println("Choix: " + i + " " + m.getChoix());
            i++;
        }
        return "choix.xhtml?faces-redirect=true";
    }


    public String addModeleChoix() {
        ModeleChoix mc = new ModeleChoix();
        mc.setChoix(this.choix);
        mc.setModeleQuestion(iModeleQuestionDAOLocal.find(idModeleC));
        iModeleChoixDAOLocal.create(mc);
        getModeleChoixPage(getIdModeleC());
        return "choix.xhtml?faces-redirect=true";
    }

    public String deleteChoix(int idChoix) {
        //toutMedecins = iMedecinDAOLocal.findAll();
        // Service s = iServiceDAOLocal.find(idService);
        ModeleChoix c = iModeleChoixDAOLocal.find(idChoix);
        iModeleChoixDAOLocal.remove(c);
        getChoices(idModeleC);
        return "choix.xhtml?faces-redirect=true";
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getIdChef() {
        return idChef;
    }

    public void setIdChef(int idChef) {
        this.idChef = idChef;
    }

    public List<Medecin> getLesMedecins() {
        return lesMedecins;
    }

    public void setLesMedecins(List<Medecin> lesMedecins) {
        this.lesMedecins = lesMedecins;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Set<ModeleQuestionnaire> getLesModelsQuestionnaires() {
        return LesModelsQuestionnaires;
    }

    public void setLesModelsQuestionnaires(Set<ModeleQuestionnaire> lesModelsQuestionnaires) {
        LesModelsQuestionnaires = lesModelsQuestionnaires;
    }

    public List<Service> getLesServices() {
        return lesServices;
    }

    public void setLesServices(Set<Service> lesServices) {
        LesServices = lesServices;
    }

    public List<Integer> getIdChefList() {
        return idChefList;
    }

    public void setIdChefList(List<Integer> idChefList) {
        this.idChefList = idChefList;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public IMedecinDAOLocal getiMedecinDAOLocal() {
        return iMedecinDAOLocal;
    }

    public void setiMedecinDAOLocal(IMedecinDAOLocal iMedecinDAOLocal) {
        this.iMedecinDAOLocal = iMedecinDAOLocal;
    }

    public int getIdModeleQuestionnaire() {
        return idModeleQuestionnaire;
    }

    public void setIdModeleQuestionnaire(int idModeleQuestionnaire) {
        this.idModeleQuestionnaire = idModeleQuestionnaire;
    }

    public static int getIdModeleQ() {
        return idModeleQ;
    }

    public static void setIdModeleQ(int idModeleQ) {
        AdminController.idModeleQ = idModeleQ;
    }

    public String getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(String questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getModeleQuestionnaire() {
        return modeleQuestionnaire;
    }

    public void setModeleQuestionnaire(String modeleQuestionnaire) {
        this.modeleQuestionnaire = modeleQuestionnaire;
    }

    public String getModeleQuestionnairename() {
        return modeleQuestionnairename;
    }

    public void setModeleQuestionnairename(String modeleQuestionnairename) {
        this.modeleQuestionnairename = modeleQuestionnairename;
    }

    public List<ModeleQuestionnaire> getModelesQuestioniaresList() {
        return modelesQuestioniaresList;
    }

    public void setModelesQuestioniaresList(List<ModeleQuestionnaire> modelesQuestioniaresList) {
        this.modelesQuestioniaresList = modelesQuestioniaresList;
    }

    public List<ModeleQuestion> getLesModelesQuestions() {
        return LesModelesQuestions;
    }

    public void setLesModelesQuestions(List<ModeleQuestion> lesModelesQuestions) {
        LesModelesQuestions = lesModelesQuestions;
    }

    public IModeleQuestionnaireDAOLocal getiModeleQuestionnaireDAOLocal() {
        return iModeleQuestionnaireDAOLocal;
    }

    public void setiModeleQuestionnaireDAOLocal(IModeleQuestionnaireDAOLocal iModeleQuestionnaireDAOLocal) {
        this.iModeleQuestionnaireDAOLocal = iModeleQuestionnaireDAOLocal;
    }

    public int getIdModeleQuestion() {
        return idModeleQuestion;
    }

    public void setIdModeleQuestion(int idModeleQuestion) {
        this.idModeleQuestion = idModeleQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public IModeleQuestionDAOLocal getiModeleQuestionDAOLocal() {
        return iModeleQuestionDAOLocal;
    }

    public void setiModeleQuestionDAOLocal(IModeleQuestionDAOLocal iModeleQuestionDAOLocal) {
        this.iModeleQuestionDAOLocal = iModeleQuestionDAOLocal;
    }

    public int getIdModeleChoix() {
        return idModeleChoix;
    }

    public void setIdModeleChoix(int idModeleChoix) {
        this.idModeleChoix = idModeleChoix;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public static int getIdModeleC() {
        return idModeleC;
    }

    public static void setIdModeleC(int idModeleC) {
        AdminController.idModeleC = idModeleC;
    }

    public String getChoixJuste() {
        return ChoixJuste;
    }

    public void setChoixJuste(String choixJuste) {
        ChoixJuste = choixJuste;
    }

    public ModeleQuestion getModeleQuestion() {
        return modeleQuestion;
    }

    public void setModeleQuestion(ModeleQuestion modeleQuestion) {
        this.modeleQuestion = modeleQuestion;
    }

    public List<ModeleChoix> getLesModelesChoix() {
        return LesModelesChoix;
    }

    public void setLesModelesChoix(List<ModeleChoix> lesModelesChoix) {
        LesModelesChoix = lesModelesChoix;
    }

    public IModeleChoixDAOLocal getiModeleChoixDAOLocal() {
        return iModeleChoixDAOLocal;
    }

    public void setiModeleChoixDAOLocal(IModeleChoixDAOLocal iModeleChoixDAOLocal) {
        this.iModeleChoixDAOLocal = iModeleChoixDAOLocal;
    }

    public void setLesServices(List<Service> lesServices) {
        this.lesServices = lesServices;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public void setIdServices(List<Integer> idServices) {
        this.idServices = idServices;
    }

    public static int getIdServiceStatic() {
        return idServiceStatic;
    }

    public static void setIdServiceStatic(int idServiceStatic) {
        AdminController.idServiceStatic = idServiceStatic;
    }

    public IServiceDAOLocal getiServiceDAOLocal() {
        return iServiceDAOLocal;
    }

    public void setiServiceDAOLocal(IServiceDAOLocal iServiceDAOLocal) {
        this.iServiceDAOLocal = iServiceDAOLocal;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public List<Medecin> getToutMedecins() {
        return toutMedecins;
    }

    public void setToutMedecins(List<Medecin> toutMedecins) {
        this.toutMedecins = toutMedecins;
    }

    public Set<DossierMedical> getLesDossiersMedicaux() {
        return LesDossiersMedicaux;
    }

    public void setLesDossiersMedicaux(Set<DossierMedical> lesDossiersMedicaux) {
        LesDossiersMedicaux = lesDossiersMedicaux;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}


