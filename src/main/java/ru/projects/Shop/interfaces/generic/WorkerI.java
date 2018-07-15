package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Worker;

public interface WorkerI {
	List<Worker> findAllWorker();
	Worker findWorkerById(Long id);
	Worker createWorker(Worker worker);
	Worker updateWorker(Worker worker);
	void deleteWorker(Worker worker);

}
