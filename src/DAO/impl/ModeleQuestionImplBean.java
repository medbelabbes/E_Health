package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IModeleQuestionDAO;
import DAO.IDAO.IModeleQuestionDAOLocal;
import Entities.Medecin;
import Entities.ModeleQuestion;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless(name = "ModeleQuestionImplEJB")
public class ModeleQuestionImplBean extends GenericFacade<ModeleQuestion> implements IModeleQuestionDAO, IModeleQuestionDAOLocal {


    @Override
    public List<ModeleQuestion> findQuestionsByQuestionnare(int idQuestionnaire) {
        Query query = em.createQuery("SELECT q FROM ModeleQuestion q WHERE q.modeleQuestionnaire.idModeleQuestionnaire =: idQuestionnaire");
        query.setParameter("idQuestionnaire", idQuestionnaire);
        return (List<ModeleQuestion>) query.getResultList();
    }
}
