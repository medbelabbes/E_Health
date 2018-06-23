package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Administrateur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IAdministrateurDAO extends IGenericDAO<Administrateur> {

    List<Administrateur> findByLogin(String email, String password);

}
