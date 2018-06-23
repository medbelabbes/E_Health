package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IModeleChoixDAO;
import DAO.IDAO.IModeleChoixDAOLocal;
import Entities.ModeleChoix;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "ModeleChoixImplEJB")
public class ModeleChoixImplBean extends GenericFacade<ModeleChoix> implements IModeleChoixDAO, IModeleChoixDAOLocal {

    @Override
    public List<ModeleChoix> getChoixByQuestions(int idModeleQuestion) {
        Query query = em.createQuery("SELECT c FROM ModeleChoix  c WHERE c.modeleQuestion.idModeleQuestion =: idModeleQuestion");
        query.setParameter("idModeleQuestion", idModeleQuestion);
        return (List<ModeleChoix>) query.getResultList();
    }
}
