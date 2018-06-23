package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Keys.KeyDossierMedical;
import Entities.Visite;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IVisiteDAO extends IGenericDAO<Visite> {
    List<Visite> dosMedVisites(KeyDossierMedical idDosMed) ;
}
