package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Operation;

import javax.ejb.Remote;

@Remote
public interface IOperationDAO extends IGenericDAO<Operation> {
}
