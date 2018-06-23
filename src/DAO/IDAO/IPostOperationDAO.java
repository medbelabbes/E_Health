package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.PostOperation;

import javax.ejb.Remote;

@Remote
public interface IPostOperationDAO extends IGenericDAO<PostOperation> {
}
