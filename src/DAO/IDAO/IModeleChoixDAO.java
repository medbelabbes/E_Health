package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.ModeleChoix;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IModeleChoixDAO extends IGenericDAO<ModeleChoix> {
    List<ModeleChoix> getChoixByQuestions(int idModeleQuestion);
}
