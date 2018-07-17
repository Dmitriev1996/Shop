package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import ru.projects.Shop.ejb.WorkerEJB;
import ru.projects.Shop.entity.Sex;
import ru.projects.Shop.entity.Worker;

public class WorkerTest extends ParentTest {
	
	@Test
	public void shouldWorker() throws Exception {
		Worker worker=new Worker();;
		worker.setSurname("Дмитриев");
		worker.setName("Александр");
		worker.setPatronymic("Андреевич");
		Sex sex=new Sex();
		sex.setSex("Мужской");
		worker.setSex(sex);
		worker.setDateOfBirth(new Date(16, 02, 1996));
		WorkerEJB workerejb=(WorkerEJB)ctx.lookup("java:global/classes/WorkerEJB!ru.projects.Shop.ejb.WorkerEJB");
		workerejb.createWorker(worker);
		assertEquals(1, workerejb.findAllWorker().size());
		Worker controlworker=workerejb.findWorkerById(1L);
		controlworker.setSurname("Петров");
		workerejb.updateWorker(controlworker);
		Worker updated=workerejb.findWorkerById(1L);
		assertEquals("Петров", updated.getSurname());
		workerejb.deleteWorker(updated);
		assertEquals(0, workerejb.findAllWorker().size());
	}

}
