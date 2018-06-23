package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Choix;

import javax.ejb.Remote;

@Remote
public interface IChoixDAO extends IGenericDAO<Choix> {
}
