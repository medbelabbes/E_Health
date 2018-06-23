package sessionutil;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created by amjad on 09/05/2018.
 */
public class SessionUtils {
    public SessionUtils() {
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static String getEmail() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session.getAttribute("email").toString();
    }

    public static String getCompteType() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session.getAttribute("compteType").toString();
    }


}
