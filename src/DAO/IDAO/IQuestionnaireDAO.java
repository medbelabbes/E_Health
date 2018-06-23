package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Questionnaire;

import javax.ejb.Remote;

@Remote
public interface IQuestionnaireDAO extends IGenericDAO<Questionnaire> {
}
