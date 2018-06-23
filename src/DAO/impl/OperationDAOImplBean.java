package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IOperationDAO;
import DAO.IDAO.IOperationDAOLocal;
import Entities.Operation;

import javax.ejb.Stateless;

@Stateless(name = "OperationDAOImplEJB")
public class OperationDAOImplBean extends GenericFacade<Operation> implements IOperationDAO, IOperationDAOLocal {


}
