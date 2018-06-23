package Controllers.security;


import DAO.IDAO.IAdministrateurDAO;
import DAO.IDAO.IMedecinDAO;
import Entities.Administrateur;
import Entities.Medecin;
import sessionutil.SessionUtils;
import util.JsfUtil;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

@Named(value = "userSessionController")
@SessionScoped
public class UserSessionController implements Serializable {



    private String email;
    private boolean emailValidate = false;
    private boolean passwordValidate = false;
    private String password;
    private boolean loggedIn;
    private String compte;

    public static int idMedecin;


    @EJB
    private IMedecinDAO iMedecinDAOLocal;

    @EJB
    private IAdministrateurDAO iAdministrateurDAO;



    public void validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value != null) {
            String data = value.toString();
            Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);
            if(!pattern.matcher(data).matches()) {
                if(this.isEmailValidate()) {
                    setEmailValidate(false);
                }

                FacesMessage message = new FacesMessage("⊗");
                throw new ValidatorException(message);
            } else {
                setEmail(data);
                setEmailValidate(true);
            }
        }
    }

    public void validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value != null) {
            String data = value.toString();
            if(data.length() < 5) {
                if(this.isEmailValidate()) {
                    setEmailValidate(false);
                }

                FacesMessage message = new FacesMessage("⊗");
                throw new ValidatorException(message);
            } else {
                setEmail(data);
                setEmailValidate(true);
            }
        }
    }


    public String doLogin() {
        String page = null;
        if (email == null || password == null) {
            JsfUtil.addErrorMessage("InvalidLogin");
            return "views/errors/identificationError.xhtml";
        }
        HttpSession session = SessionUtils.getSession();

        List<Administrateur> administrateurs=iAdministrateurDAO.findByLogin(email,password);
        List<Medecin> medecins=iMedecinDAOLocal.findByLogin(email,password);

        if(!administrateurs.isEmpty()) {
            session.setAttribute("email", this.getEmail());

            session.setAttribute("compteType", "administrateur");
            page = "views/admin/services/index.xhtml";
            return page;

        } else if(!medecins.isEmpty()){
            session.setAttribute("email", this.getEmail());
            idMedecin=medecins.get(0).getIdMedecin();

            List<Medecin> chefservices =iMedecinDAOLocal.checkChefService(medecins.get(0).getIdMedecin());
            if(!chefservices.isEmpty()){
                session.setAttribute("compteType", "chefService");
                compte="CHEF SERVICE Page";
                return "views/chefservice/index.xhtml?faces-redirect=true";

            }

                session.setAttribute("compteType", "medecin");
            compte="Medecin Page";
                return "views/medecin/index.xhtml?faces-redirect=true";

        }else return "views/errors/identificationError.xhtml";

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEmailValidate() {
        return emailValidate;
    }

    public void setEmailValidate(boolean emailValidate) {
        this.emailValidate = emailValidate;
    }

    public boolean isPasswordValidate() {
        return passwordValidate;
    }

    public void setPasswordValidate(boolean passwordValidate) {
        this.passwordValidate = passwordValidate;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }
}
