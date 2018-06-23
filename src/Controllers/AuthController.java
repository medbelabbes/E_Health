package Controllers;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.regex.Pattern;

/**
 * Created by amjad on 06/05/2018.
 */
@Named
@javax.enterprise.context.ApplicationScoped
public class AuthController {


        private String email;
        private String password;
        private boolean emailValidate = false;
        private boolean passwordValidate = false;


    public AuthController() {
    }

    public AuthController(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isEmailValidate() {
            return this.emailValidate;
        }

        public void setEmailValidate(boolean emailValidate) {
            this.emailValidate = emailValidate;
        }

        public boolean isPasswordValidate() {
            return this.passwordValidate;
        }

        public void setPasswordValidate(boolean passwordValidate) {
            this.passwordValidate = passwordValidate;
        }

        public void validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            if(value != null) {
                String data = value.toString();
                Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);
                if(!pattern.matcher(data).matches()) {
                    if(this.isEmailValidate()) {
                        this.setEmailValidate(false);
                    }

                    FacesMessage message = new FacesMessage("⊗");
                    throw new ValidatorException(message);
                } else {
                    this.setEmail(data);
                    this.setEmailValidate(true);
                }
            }
        }

        public void validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            if(value != null) {
                String data = value.toString();
                if(data.length() < 5) {
                    if(this.isEmailValidate()) {
                        this.setEmailValidate(false);
                    }

                    FacesMessage message = new FacesMessage("⊗");
                    throw new ValidatorException(message);
                } else {
                    this.setEmail(data);
                    this.setEmailValidate(true);
                }
            }
        }

        public String validateUsernamePassword() {
          /*  boolean valid = LoginDbUtil.validate(this.getEmail(), this.getPassword());
            if(valid) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("email", this.getEmail());
                String page = null;
                if(SessionUtils.getCompteType().equals("etudiant")) {
                    EtudiantDbUtil.loadEtudiantData();
                    ContraintesDbUtil.loadContraintes();
                    SoutenanceController.loadSoutnanceConstraintes();
                    page = "/studentSession.xhtml";
                    return page;
                } else {
                    if(SessionUtils.getCompteType().equals("enseignant")) {
                        EnseignantDbUtil.loadEnseignantData();
                    }

                    page = "/teacherSession.xhtml";
                    return page;
                }
            } else {
                return "/Modals/identificationError.xhtml";
            }*/
          return null;
        }

        public String logout() {
           /* HttpSession session = SessionUtils.getSession();
            session.invalidate();
            return "/loginPage.xhtml?faces-redirect=true";*/
           return null;
        }
}
