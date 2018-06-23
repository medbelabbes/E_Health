
package Controllers.security;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;



@Named(value = "navigationController")
@SessionScoped
public class NavigationController implements Serializable {

    private static final long serialVersionUID = 1L;


    public String redirectToLogin() {
        return "/loginPage.xhtml?faces-redirect=true";
    }
     

    public String toLogin() {
        return "/loginPage.xhtml";
    }
     

    public String redirectToInfo() {
        return "/info.xhtml?faces-redirect=true";
    }
     

    public String toInfo() {
        return "/info.xhtml";
    }
     
    
    public String redirectToWelcome() {
        return "/sc/dashboard.xhtml?faces-redirect=true";
    }
     
    
    public String toWelcome() {
        return "/sc/dashboard.xhtml";
    }

    public String toMedecin() {
        return "views/medecin/index.xhtml";
    }

    public String redirecttoMedecin() {
        return "views/medecin/index.xhtml?faces-redirect=true";
    }

    public String toAdmin() {
        System.out.println("routage web/views/admin/index.xhtml");
        return "web/views/admin/index.xhtml";
    }

    public String redirecttoAdmin() {
        return "views/admin/index.xhtml?faces-redirect=true";
    }
}
