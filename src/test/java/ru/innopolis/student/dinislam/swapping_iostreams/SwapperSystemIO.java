package ru.innopolis.student.dinislam.swapping_iostreams;

import java.io.InputStream;
import java.io.PrintStream;

public class SwapperSystemIO {

    public static void swapAndReturn(InputStream inputStream, PrintStream output, Runnable task) {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        try {
            System.setIn(inputStream);
            System.setOut(output);

            task.run();
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }
}
