package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Service;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IServiceDAO extends IGenericDAO<Service> {
    public List<Integer> getIdServices();
}
