package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IServiceDAO;
import DAO.IDAO.IServiceDAOLocal;
import Entities.Service;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "ServiceDAOImplEJB")
public class ServiceDAOImplBean extends GenericFacade<Service> implements IServiceDAO, IServiceDAOLocal {

    @Override
    public List<Integer> getIdServices(){
        Query query = em.createQuery("Select s.idService from Service s ");
        return (List<Integer>) query.getResultList();
    }
}
