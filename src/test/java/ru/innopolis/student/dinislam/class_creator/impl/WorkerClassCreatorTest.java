package ru.innopolis.student.dinislam.class_creator.impl;

import org.junit.jupiter.api.Test;
import ru.innopolis.student.dinislam.swapping_iostreams.SwapperSystemIO;

import java.io.IOException;
import java.io.InputStream;


class WorkerClassCreatorTest {

    private final static String RESOURCE = "test_method_body.txt";

    @Test
    void createWorkerClassTest() {

        try (final InputStream inputStream = WorkerClassCreatorTest.class.getResourceAsStream(RESOURCE)) {
            SwapperSystemIO.swapAndReturn(inputStream, System.out,
                    () -> new WorkerClassCreator().create("SomeImpl"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}