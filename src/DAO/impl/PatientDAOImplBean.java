package DAO.impl;

import DAO.GenericFacade;
import DAO.IDAO.IPatientDAO;
import DAO.IDAO.IPatientDAOLocal;
import Entities.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless(name = "PatientDAOImplEJB")
public class PatientDAOImplBean extends GenericFacade<Patient> implements IPatientDAO, IPatientDAOLocal {
    @PersistenceContext(unitName = "E_HealthPersistenceUnit2")
    EntityManager em;
}
