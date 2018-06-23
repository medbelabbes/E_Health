package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Patient;

import javax.ejb.Remote;

@Remote
public interface IPatientDAO extends IGenericDAO<Patient> {
}
