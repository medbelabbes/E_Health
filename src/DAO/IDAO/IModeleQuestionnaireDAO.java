package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.ModeleQuestion;
import Entities.ModeleQuestionnaire;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IModeleQuestionnaireDAO extends IGenericDAO<ModeleQuestionnaire> {
    
    List<ModeleQuestionnaire> findModeleQuestionnareByService(int idService);

}
