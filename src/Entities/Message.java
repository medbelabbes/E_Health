package Entities;

import javax.persistence.*;
import java.io.Serializable;
@NamedQueries({
        @NamedQuery(
                name = "FIND_ALL_MESSAGES_BY_MEDECIN", query = "SELECT a FROM Message a WHERE a.idSendTo = :idMedecin ")
})
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;



    private String Titre;
    private String etat;
    private String msg;
    private String idSender;
    private String idSendTo;


    public Message() {
    }

    public Message(String titre, String etat, String msg, String idSender, String idSendTo) {
        Titre = titre;
        this.etat = etat;
        this.msg = msg;
        this.idSender = idSender;
        this.idSendTo = idSendTo;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getIdSendTo() {
        return idSendTo;
    }

    public void setIdSendTo(String idSendTo) {
        this.idSendTo = idSendTo;
    }

}
