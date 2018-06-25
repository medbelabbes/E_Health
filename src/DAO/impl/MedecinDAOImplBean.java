package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IMedecinDAO;
import DAO.IDAO.IMedecinDAOLocal;
import Entities.Medecin;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 * Created by amjad on 08/05/2018.
 */
@Stateful
public class MedecinDAOImplBean extends GenericFacade<Medecin> implements IMedecinDAO, IMedecinDAOLocal, Serializable {


    private Class<Medecin> entityMedecin;

    @PostConstruct
    public void init() {

    }

    @Override
    public List<Medecin> findByLogin(String email, String password) {
        Query query = em.createNamedQuery("FIND_BY_LOGIN_MEDECIN");

        query.setParameter("email", email);
        query.setParameter("password", password);
        HttpSession session;

        return query.getResultList();

    }

    @Override
    public boolean validate(String email, String password) {
        Query query = em.createNamedQuery("FIND_BY_LOGIN_MEDECIN");

        query.setParameter("email", email);
        query.setParameter("password", password);

        return !query.getResultList().isEmpty();
    }

    @Override
    public List<Medecin> checkChefService(int idMedecin) {
        Query query = em.createNamedQuery("CHECK_CHEF_SERVICE");

        query.setParameter("idMedecin", idMedecin);
        return query.getResultList();
    }

    @Override
    public List<Medecin> findFullNameMedecin() {
        Query query = em.createQuery("SELECT m.nom,m.prenom FROM Medecin m");
        return (List<Medecin>) query.getResultList();
    }

    @Override
    public int findIdByFullName(String nom, String prenom) {
        Query query = em.createQuery("Select m.idMedecin from Medecin m where m.nom =: nom and m.prenom =: prenom");
        query.setParameter("nom", nom);
        query.setParameter("prenom", prenom);
        return (Integer) query.getSingleResult();
    }

    @Override
    public List<Integer> getAllIdMedecin() {
//        Query query = em.createQuery("Select m.idMedecin from Medecin m");
        Query query = em.createQuery("Select m.idMedecin from Medecin m where m.idMedecin NOT IN (SELECT s.chefService.idMedecin from Service s )");
        return (List<Integer>) query.getResultList();
    }

    @Override
    public List<Medecin> findMedecinsByService(int idService) {
        Query query = em.createQuery("SELECT m FROM Medecin m  join m.LesServices services where services.idService = :idService");
        query.setParameter("idService", idService);
        return (List<Medecin>) query.getResultList();
    }

    @Override
    public String findPassword(String email) {
        Query query = em.createQuery("Select m.password from Medecin m where m.email =: email");
        query.setParameter("email", email);
        return (String) query.getSingleResult();
    }
}
