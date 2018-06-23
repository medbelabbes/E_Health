package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IModeleQuestionnaireDAO;
import DAO.IDAO.IModeleQuestionnaireDAOLocal;
import Entities.ModeleQuestionnaire;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless(name = "ModeleQuestionnaireImplEJB")
public class ModeleQuestionnaireImplBean extends GenericFacade<ModeleQuestionnaire> implements IModeleQuestionnaireDAO, IModeleQuestionnaireDAOLocal, Serializable {

    @Override
    public List<ModeleQuestionnaire> findModeleQuestionnareByService(int idService) {
        Query query = em.createQuery("SELECT q FROM ModeleQuestionnaire q WHERE q.service.idService =: idService");
        query.setParameter("idService", idService);
        return (List<ModeleQuestionnaire>) query.getResultList();
    }
}
