package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.ICompteDAO;
import DAO.IDAO.ICompteDAOLocal;
import Entities.Compte;

import javax.ejb.Stateless;

@Stateless(name = "CompteDAOImplEJB")
public class CompteDAOImplBean extends GenericFacade<Compte> implements ICompteDAO, ICompteDAOLocal {

}
