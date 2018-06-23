package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.TraitementActuel;

import javax.ejb.Remote;

@Remote
public interface ITraitmentActuelDAO extends IGenericDAO<TraitementActuel> {
}
