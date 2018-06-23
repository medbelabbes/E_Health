package Controllers.Medecin;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "viewController")
@ViewScoped
public class ViewController implements Serializable {
    //field password and it's getter and setter

    private String password="ddsdsds";
    private boolean showPassword = false;


    public void toggle(){
        showPassword=!showPassword;
        System.out.println("show password "+showPassword);
    }
    public boolean isShowPassword(){
        return showPassword;
    }

    public void setShowPassword(boolean showPassword) {
        this.showPassword = showPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}