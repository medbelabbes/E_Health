package DAO.IDAO;

import Entities.ModeleQuestion;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IModeleQuestionDAOLocal extends IModeleQuestionDAO {
    List<ModeleQuestion> findQuestionsByQuestionnare(int idQuestionnaire);
}
