package Controllers;

/**
 * Created by amjad on 06/05/2018.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.Calendar;

@Named
@ViewScoped
public class LoginLayoutController {
    int year;

    public LoginLayoutController() {
    }

    public int getYear() {
        return this.year = Calendar.getInstance().get(1);
    }
}
