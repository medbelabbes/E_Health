package Entities;

import Entities.Types.EtatCompte;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(unique = true)
    private String login;

    @NotNull
    @Size(min = 8, max = 45)
    private String password;

    @NotNull
    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private EtatCompte etat;

    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] avatar;

    //Un patient à un seul compte
    @OneToOne
    @JoinColumn(name = "idPatient")
    private Patient patient;

    public Compte() {
    }

    public Compte(@NotNull @Size(min = 3, max = 15) String login, @NotNull @Size(min = 8, max = 45) String password, @NotNull EtatCompte etat, byte[] avatar, Patient patient) {
        this.login = login;
        this.password = password;
        this.etat = etat;
        this.avatar = avatar;
        this.patient = patient;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EtatCompte getEtat() {
        return etat;
    }

    public void setEtat(EtatCompte etat) {
        this.etat = etat;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
