package Controllers.Medecin;

import DAO.IDAO.IConsigneDAO;
import DAO.IDAO.IMedecinDAO;
import DAO.IDAO.IOperationDAO;
import DAO.IDAO.IPatientDAO;
import Entities.Consigne;
import Entities.Medecin;
import Entities.Operation;
import Entities.Patient;
import Entities.Types.OperationType;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "operationController")
@RequestScoped
public class OperationController implements Serializable {


    private Patient patient=new Patient();
    private Medecin medecin=new Medecin();
    private Operation operation=new Operation();
    private Consigne consigne=new Consigne();

    @EJB
    IOperationDAO iOperationDAO;
    @EJB
    IConsigneDAO iConsigneDAO;
    @EJB
    IMedecinDAO iMedecinDAO;
    @EJB
    IPatientDAO iPatientDAO;
    private DualListModel<String> oper;
    private List<Medecin> medecins;
    private List<Operation> operations;
    private List<Patient> patients;
    private Operation selectedOperation;
    private List<Operation> filteredoperations;

    @PostConstruct
    public void init() {
        medecins=iMedecinDAO.findAll();
operations=iOperationDAO.findAll();
patients=iPatientDAO.findAll();
operation.setPatient(patient);operation.setMedecin(medecin);
        List<String> operationsSource = new ArrayList<String>();
        List<String> operationsTarget = new ArrayList<String>();

       operationsSource=allMedcecins();


        oper = new DualListModel<String>(operationsSource, operationsTarget);


    }

    public List<String> allMedcecins(){
        List<String> list=new ArrayList<>();
        for (int i=0;i<medecins.size();i++){
            list.add(medecins.get(i).toString());
        }
        return list;
    }public List<String> allOperations(){
        List<String> list=new ArrayList<>();
        for (int i=0;i<operations.size();i++){
            list.add(operations.get(i).toString());
        }
        return list;
    }public List<String> allPatients(){
        List<String> list=new ArrayList<>();
        for (int i=0;i<patients.size();i++){
            list.add(patients.get(i).toString());
        }
        return list;
    }public List<Patient> allPatientsM(){
//        List<String> list=new ArrayList<>();
//        for (int i=0;i<patients.size();i++){
//            list.add(patients.get(i).toString());
//        }
        return patients;
    }

    public DualListModel<String> getOper() {
        return oper;
    }

    public void setOper(DualListModel<String> oper) {
        this.oper = oper;
    }

//    public void onTransfer(TransferEvent event) {
//        StringBuilder builder = new StringBuilder();
//        for(Object item : event.getItems()) {
//            builder.append(((Theme) item).getName()).append("<br/>");
//        }
//
//        FacesMessage msg = new FacesMessage();
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        msg.setSummary("Items Transferred");
//        msg.setDetail(builder.toString());
//
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }

    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void save() throws IOException {
//        System.out.println("Save patient "+ etudiant.getNom()+" "+etudiant.getPrenom()+" "+etudiant.getEmail());
//       patient.setIdPatient(99);
//        etudiant.setClasse(selectedClasse);
        iOperationDAO.create(operation);

      //  System.out.println("id MEDECINE "+oper.getTarget().get(0).charAt(0)+"id Patient ");
        FacesMessage msg = new FacesMessage("Successful", "Operation creer avec succées :" );
        FacesContext.getCurrentInstance().addMessage(null, msg);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
//        return "views/admin/index";

    }

    public Operation getSelectedOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(Operation selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getFilteredoperations() {
        return filteredoperations;
    }

    public void setFilteredoperations(List<Operation> filteredoperations) {
        this.filteredoperations = filteredoperations;
    }
    public void delete(){
        iOperationDAO.remove(operation);
    }

    public String routeAjouterConsigne(){
        String page = "ajouterVisite.xhtml?faces-redirect=true";
        return page;
    }

    public Consigne getConsigne() {
        return consigne;
    }

    public void setConsigne(Consigne consigne) {
        this.consigne = consigne;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public List<Consigne> getAllConsignesPre(int id) {

        List<Consigne> consigneList=iConsigneDAO.operationConsignesPre(id);
        System.out.println("size consignePre list"+consigneList.size());

        return  consigneList;
    } public List<Consigne> getAllConsignesPost(int id) {

        List<Consigne> consigneList=iConsigneDAO.operationConsignesPost(id);
        System.out.println("size consignePost list"+consigneList.size());

        return  consigneList;
    }

    public void addConsignePre(int id) throws IOException {

        consigne.setOperation(OperationType.PreOperation);

        id=selectedOperation.getIdOperation();
        System.out.println("ooooo"+id);
          iConsigneDAO.create(consigne);

        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + patient.getNom()+" "+patient.getPrenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
//        return "views/admin/index";

    }
    public String routeAjouterConsignePre(){

        String page = "ajouterConsignePre.xhtml?faces-redirect=true";
        return page;
    } public String routeAjouterConsignePost(){

        String page = "ajouterConsignePost.xhtml?faces-redirect=true";
        return page;
    }


}