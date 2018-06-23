package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Question;

import javax.ejb.Remote;

@Remote
public interface IQuestionDAO extends IGenericDAO<Question> {
}
