package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Forum;

public interface ForumI {
	List<Forum> findAllForum();
	Forum findForumById(Long id);
	Forum createForum(Forum forum);
	Forum updateForum(Forum forum);
	void deleteForum(Forum forum);

}
