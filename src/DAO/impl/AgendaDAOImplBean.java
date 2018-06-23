package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IAgendaDAO;
import DAO.IDAO.IAgendaDAOLocal;
import Entities.Agenda;

import javax.ejb.Stateful;
import javax.persistence.Query;
import java.util.List;

@Stateful(name = "AgendaDAOImplEJB")
public class AgendaDAOImplBean extends GenericFacade<Agenda> implements IAgendaDAO, IAgendaDAOLocal {



    @Override
    public void updateAgendaMedecin(int idM,String idA) {
        Query query = em.createNamedQuery("UPDATE_AGENDA_MEDECIN");
        query.setParameter("idMed", idM);
        query.setParameter("idAgenda", idA);
        query.executeUpdate();

    }

    @Override
    public List<Agenda> allAgendaMedecin(int idM) {
        Query query = em.createNamedQuery("FIND_ALL_AGENDA_MEDECIN");
        query.setParameter("idMed", idM);
        return (List<Agenda>) query.getResultList();
    }
}
