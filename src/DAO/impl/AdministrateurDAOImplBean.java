package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IAdministrateurDAO;
import DAO.IDAO.IAdministrateurDAOLocal;
import Entities.Administrateur;

import javax.ejb.Stateful;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;


@Stateful(name = "AdministrateurDAOImplEJB")
public class AdministrateurDAOImplBean extends GenericFacade<Administrateur> implements IAdministrateurDAO, IAdministrateurDAOLocal {

    @Override
    public List<Administrateur> findByLogin(String email, String password) {
        Query query = em.createNamedQuery("FIND_BY_LOGIN_ADMIN");

        query.setParameter("email",email);
        query.setParameter("password",password);
        HttpSession session;

        return query.getResultList();

    }
}
