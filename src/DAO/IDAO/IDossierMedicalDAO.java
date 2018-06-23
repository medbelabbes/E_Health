package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.DossierMedical;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IDossierMedicalDAO extends IGenericDAO<DossierMedical> {
    List<DossierMedical> findAllByMed(int idM);
}
