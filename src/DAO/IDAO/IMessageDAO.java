package DAO.IDAO;

import DAO.IGenericDAO;
import Entities.Message;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IMessageDAO extends IGenericDAO<Message> {
    List<Message> findAllByMed(String idM);

}
