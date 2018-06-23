import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "TesteWeb",urlPatterns = "/TesteWeb")
public class TesteWeb extends HttpServlet {

//    @EJB
//    private IEmployeDAOLocal Ec;
//    @EJB
//    private IDepartementDAOLocal Dc;
//    @EJB
//    private IProjetDAOLocal Pc;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html;charset-UTF-8");
//        PrintWriter out = response.getWriter();
//        try{
//            out.println("<html><head><Title>Servler SearchClient</Title></head>");
//            //out.println("<body>");
//            out.println("<body><h1>Ajouter un Departement ,3 employés 2 projets</h1>");
//          /*  Departement departement3=new Departement(2,"departement15","SBA5");
//
//
//            Dc.create(departement3);
//
//           Projet projet1=new Projet(1);
//
//            Pc.create(projet1);
//            Projet projet2=new Projet(2);
//
//
//            Pc.create(projet2);*/
//        /*    Employe e=new Employe();
//
//            e.setIdEmploye(1);
//            e.setNumeroSocial(25);
//            e.setNom("Yahiaoui"); e.setPrenom("Abdelkader");
//            e.setEmail("a.yahiaoui1@esi-sba.dz");
//            e.setAdresse(new Adresse("ha",26,"at"));
//            e.setSexe(Civility.homme);
//            Ec.create(e);
//*/
//            /*Employe e2=new Employe(2,"Ali","Yahiaoui",Civility.homme,"a.yahiaoui2@gmail.com");
//            Employe e3=new Employe(3,"Amjad","Yahiaoui2",Civility.homme,"a.yahiaoui3@gmail.com");
//*/
//
//
//            List<Departement> departements=Dc.findAll();
//            out.println("<h1>Liste des departements ( "+Dc.count()+" )</h1>");
//
//            out.println("<ul>");
//            for(Departement l:departements)
//                out.println("<li>"+l.getNom()+" "+l.getVille()+"</li>");
//            out.println("</ul>");
//
//            List<Projet> projets=Pc.findAll();
//            out.println("<h1>Liste des projets ( "+Pc.count()+" )</h1>");
//
//            out.println("<ul>");
//            for(Projet l:projets)
//                out.println("<li>"+l.getDateDebut()+" "+l.getDateDebut()+"</li>");
//            out.println("</ul>");
//
//
//            List<Employe> set=Ec.findAll();
//
//
//            out.println("<h1>Liste des employées ( "+Ec.count()+" )</h1>");
//
//            out.println("<ul>");
//
//            for(Employe l:set)
//                out.println("<li>"+l.getNom()+" "+l.getPrenom()+"</li>");
//
//
//            out.println("</ul></body></html>");
//        }finally {
//            out.close();
//        }
//    }
}
