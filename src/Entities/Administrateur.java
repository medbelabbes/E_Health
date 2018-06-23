package Entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@NamedQueries({
        @NamedQuery(
                name = "FIND_BY_LOGIN_ADMIN", query = "SELECT a FROM Administrateur a WHERE a.email = :email AND a.password = :password ")
})
@Entity
public class Administrateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministarteur;

    @NotNull
    @Size(min = 3,max = 25)
    private String nom;

    @NotNull
    @Size(min = 3,max = 25)
    private String prenom;


    @Column(unique = true)
    private String email;

    private String telephone;

    @NotNull
    @Size(min = 8,max = 25)
    private String password;

    @Embedded
    private Adresse adresse;

    public Administrateur() {
    }

    public Administrateur(@NotNull @Size(min = 3, max = 25) String nom, @NotNull @Size(min = 3, max = 25) String prenom, String email, String telephone, @NotNull @Size(min = 8, max = 25) String password, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.adresse = adresse;
    }

    public int getIdAdministarteur() {
        return idAdministarteur;
    }

    public void setIdAdministarteur(int idAdministarteur) {
        this.idAdministarteur = idAdministarteur;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


}
