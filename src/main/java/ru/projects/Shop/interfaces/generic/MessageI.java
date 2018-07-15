package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Message;

public interface MessageI {
	List<Message> findAllMesage();
	Message findMessageById(Long id);
	Message createMessage(Message message);
	Message updateMessage(Message message);
	void deleteMessage(Message message);

}
