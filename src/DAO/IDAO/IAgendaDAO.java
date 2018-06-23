package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Agenda;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IAgendaDAO extends IGenericDAO<Agenda> {

   void updateAgendaMedecin(int idM,String idA);
   List<Agenda> allAgendaMedecin(int idM) ;

}
