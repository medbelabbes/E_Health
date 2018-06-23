package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Medecin;
import Entities.ModeleQuestion;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IModeleQuestionDAO extends IGenericDAO<ModeleQuestion> {
}
