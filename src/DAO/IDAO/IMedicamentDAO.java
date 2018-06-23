package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Medicament;

import javax.ejb.Remote;

@Remote
public interface IMedicamentDAO extends IGenericDAO<Medicament> {
}
