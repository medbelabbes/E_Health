package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IVisiteDAO;
import DAO.IDAO.IVisiteDAOLocal;
import Entities.Keys.KeyDossierMedical;
import Entities.Visite;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by amjad on 08/05/2018.
 */
@Stateful
public class VisiteDAOImplBean extends GenericFacade<Visite> implements IVisiteDAO,IVisiteDAOLocal,Serializable {

    @PostConstruct
    public void init(){

    }


    @Override
    public List<Visite> dosMedVisites(KeyDossierMedical idDosMed) {
        Query query = em.createQuery("SELECT m FROM Visite m  where m.dossierMedical.idDossierMedical = :idMed");
        query.setParameter("idMed", idDosMed);
        return (List<Visite>) query.getResultList();
    }
}
