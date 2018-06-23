package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Consigne;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IConsigneDAO extends IGenericDAO<Consigne> {
    List<Consigne> operationConsignesPre(int idOper) ;
    List<Consigne> operationConsignesPost(int idOper) ;
}
