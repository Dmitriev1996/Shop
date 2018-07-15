package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Message;
import ru.projects.Shop.interfaces.local.MessageLocal;

@Stateless
@Local(MessageLocal.class)
@LocalBean
public class MessageEJB implements MessageLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Message> findAllMesage() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllMessage", Message.class).getResultList();
	}

	@Override
	public Message findMessageById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Message.class, id);
	}

	@Override
	public Message createMessage(Message message) {
		// TODO Auto-generated method stub
		em.persist(message);
		return message;
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return em.merge(message);
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		em.remove(em.merge(message));
	}

}
