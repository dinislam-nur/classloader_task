package ru.innopolis.student.dinislam.worker.impl;

import ru.innopolis.student.dinislam.worker.api.Worker;

public class WorkerImpl implements Worker {

	@Override
	public void doWork() {
		for (int i = 0; i < 10; i++) {
    System.out.println("i = " + i + ";");
}
	}
}