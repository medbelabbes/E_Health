package Controllers.Medecin;

import DAO.IDAO.IMedecinDAO;
import DAO.IDAO.IMessageDAO;
import Entities.Message;

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
@Named(value = "messageController")
    @RequestScoped
    public class MessageController implements Serializable {

    @EJB
    IMedecinDAO iMedecinDAO;
    @PostConstruct
    public void init(){

        String email=iMedecinDAO.find(idMedecin).getEmail();
        messageList=iMessageDAO.findAllByMed(email);

        message.setEtat("Non lue");
        message.setIdSender(email);
    }

    @EJB
    IMessageDAO iMessageDAO;

    private Message selectedmessage;
    private List<Message> messageList;
    private List<Message> filtredMessages;
    private Message message=new Message();

    public IMessageDAO getiMessageDAO() {
        return iMessageDAO;
    }

    public void setiMessageDAO(IMessageDAO iMessageDAO) {
        this.iMessageDAO = iMessageDAO;
    }

    public Message getSelectedmessage() {
        return selectedmessage;
    }

    public void setSelectedmessage(Message selectedmessage) {
        this.selectedmessage = selectedmessage;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Message> getFiltredMessages() {
        return filtredMessages;
    }

    public void setFiltredMessages(List<Message> filtredMessages) {
        this.filtredMessages = filtredMessages;
    }

    public void readMsg(){
        selectedmessage.setEtat("lue");
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    public void addMsg() {

        iMessageDAO.create(message);
    }
}