package ru.innopolis.student.dinislam.work_method_reader.api;

import org.junit.jupiter.api.Test;
import ru.innopolis.student.dinislam.work_method_reader.MethodWorkReader;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MethodWorkReaderTest {

    @Test
    void readFromConsoleMethodBodyTest() {
        String body ="        final StringBuilder stringBuilder = new StringBuilder();\n" +
                "        try (BufferedReader reader = new BufferedReader(\n" +
                "                                        new InputStreamReader(inputStream))) {\n" +
                "            reader.lines()\n" +
                "                    .forEachOrdered(string -> stringBuilder.append(string)\n" +
                "                                                            .append(System.lineSeparator()));\n" +
                "        } catch (IOException e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "        return stringBuilder.toString();\n";
        final byte[] bytes = body.getBytes();

        final String result = MethodWorkReader.readMethodBody(new ByteArrayInputStream(bytes));

        assertArrayEquals(body.trim().split("\\s+"), result.split("\\s+"));
    }

}