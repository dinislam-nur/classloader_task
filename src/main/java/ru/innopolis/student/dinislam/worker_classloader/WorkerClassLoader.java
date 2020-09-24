package ru.innopolis.student.dinislam.worker_classloader;

import java.io.*;
import java.nio.file.Files;

/**
 * Класс лоадер, загружающий класс, реализующий интерфейс Worker.
 */
public class WorkerClassLoader extends ClassLoader {

    /**
     * Путь к директории откуда загрузить байт код класса.
     */
    public static final String PATH_TO_DIRECTORY = "target/classes/ru/innopolis/student/dinislam/worker/impl/";

    /**
     * Загрузка класса.
     *
     * @param name - имя класса.
     * @return - загруженный класс.
     * @throws ClassNotFoundException - если загружаемый класс не существует.
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            final byte[] bytes = Files.readAllBytes(
                    new File(PATH_TO_DIRECTORY + name + ".class")
                            .toPath());

            return defineClass(null, bytes, 0, bytes.length);

        } catch (IOException e) {
            return super.loadClass(name);
        }
    }
}
