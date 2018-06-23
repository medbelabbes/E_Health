package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.PreOperation;

import javax.ejb.Remote;

@Remote
public interface IPreOperationDAO extends IGenericDAO<PreOperation> {
}
