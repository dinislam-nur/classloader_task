package ru.innopolis.student.dinislam.worker.impl;

import ru.innopolis.student.dinislam.worker.api.Worker;

public class SomeImpl implements Worker {

	@Override
	public void doWork() {
		System.out.println("Hello, friend!!!");
	}
}