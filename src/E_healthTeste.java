import DAO.IDAO.IAdministrateurDAOLocal;
import Entities.Administrateur;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "E_healthTeste2", urlPatterns = "/E_healthTeste2")
public class E_healthTeste extends HttpServlet {
    @EJB
    private IAdministrateurDAOLocal Ea;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>E_Health Administrateur</title></head>");
            out.println("<body><h1>Ajouter un admnistrateur</h1>");
            Administrateur admin = new Administrateur();
            admin.setNom("Yahiaoui");
            admin.setPrenom(" Abdelkader");
            String emails = "Moh7@dlisvzeaz.be";
            admin.setEmail(emails);

            Set<String> telephones = new HashSet<>();
            telephones.add("065291229148985");
            telephones.add("07912120714144161");
            telephones.add("065851241279848");

//            admin.setTelephone(telephones);
//            admin.setPassword("1232245689");
            Ea.create(admin);

            List<Administrateur> set=Ea.findAll();


            out.println("<h1>Liste des adminstrateurs ( "+Ea.count()+" )</h1>");

            out.println("<ul>");

            for(Administrateur l:set)
                out.println("<li>"+l.getNom()+" "+l.getPrenom()+"</li>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
