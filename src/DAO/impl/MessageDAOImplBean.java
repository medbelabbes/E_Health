package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IMessageDAO;
import DAO.IDAO.IMessageDAOLocal;
import Entities.Message;

import javax.ejb.Stateful;
import javax.persistence.Query;
import java.util.List;

@Stateful(name = "MessageDAOImplEJB")
public class MessageDAOImplBean extends GenericFacade<Message> implements IMessageDAO, IMessageDAOLocal {

    @Override
    public List<Message> findAllByMed(String idM) {
        Query query = em.createNamedQuery("FIND_ALL_MESSAGES_BY_MEDECIN");

        query.setParameter("idMedecin",idM);

        return query.getResultList();

    }


}
