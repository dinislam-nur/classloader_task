package ru.innopolis.student.dinislam.work_method_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Интерфейс, читающий блок кода для метода doWork реализации интерфейса Worker.
 */
public interface MethodWorkReader {

    /**
     * Читает блок кода для метода doWork реализации интерфейса Worker из InputStream.
     *
     * @param inputStream - входной поток.
     * @return - строковое представление блока кода.
     */
    static String readMethodBody(InputStream inputStream) {
        final StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream))) {
            reader.lines()
                    .forEachOrdered(string -> stringBuilder.append(string)
                            .append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }
}
