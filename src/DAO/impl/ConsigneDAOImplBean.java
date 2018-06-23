package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IConsigneDAO;
import DAO.IDAO.IConsigneDAOLocal;
import Entities.Consigne;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "ConsigneDAOImplEJB")
public class ConsigneDAOImplBean extends GenericFacade<Consigne> implements IConsigneDAO, IConsigneDAOLocal {
    @Override
    public List<Consigne> operationConsignesPre(int idOper) {
        Query query = em.createQuery("SELECT m FROM Consigne m  where m.operation.idOperation = :idOperation AND m.Operation='PreOperation'");
        query.setParameter("idOperation", idOper);
        return query.getResultList();
    }
    @Override
    public List<Consigne> operationConsignesPost(int idOper) {
        Query query = em.createQuery("SELECT m FROM Consigne m  where m.operation.idOperation = :idOperation AND m.Operation='PostOperation'");
        query.setParameter("idOperation", idOper);
        return query.getResultList();
    }
}
