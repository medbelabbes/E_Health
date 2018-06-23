package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IDossierMedicalDAO;
import DAO.IDAO.IDossierMedicalDAOLocal;
import Entities.DossierMedical;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless(name = "DossierMedicalDAOImplEJB")
public class DossierMedicalDAOImplBean extends GenericFacade<DossierMedical> implements IDossierMedicalDAO, IDossierMedicalDAOLocal {


    @Override
    public List<DossierMedical> findAllByMed(int idM) {
        Query query = em.createNamedQuery("FIND_ALL_BY_MEDECIN");

        query.setParameter("idMedecin",idM);

        return query.getResultList();

    }

}
