package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Medecin;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IMedecinDAO extends IGenericDAO<Medecin> {

    List<Medecin> findByLogin(String email, String password);
    boolean validate(String email, String password);
    List<Medecin> checkChefService(int idMedecin);

    List<Medecin> findFullNameMedecin();

    int findIdByFullName(String nom, String prenom);

    List<Integer> getAllIdMedecin();

    List<Medecin> findMedecinsByService(int idService);

    String findPassword(String email);

}
