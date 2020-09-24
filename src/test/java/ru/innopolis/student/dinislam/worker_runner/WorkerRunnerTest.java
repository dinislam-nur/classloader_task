package ru.innopolis.student.dinislam.worker_runner;

import org.junit.jupiter.api.Test;
import ru.innopolis.student.dinislam.swapping_iostreams.SwapperSystemIO;

import java.io.IOException;
import java.io.InputStream;


class WorkerRunnerTest {

    public static final String RESOURCE = "test_method_body_for_runner.txt";

    @Test
    void runWorkerTest() {

        try (final InputStream input = WorkerRunnerTest.class.getResourceAsStream(RESOURCE)) {
            SwapperSystemIO.swapAndReturn(input, System.out,
                    () -> new WorkerRunner().runWorker("WorkerImpl"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}