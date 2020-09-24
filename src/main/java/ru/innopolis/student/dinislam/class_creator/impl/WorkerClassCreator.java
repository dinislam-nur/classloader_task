package ru.innopolis.student.dinislam.class_creator.impl;

import ru.innopolis.student.dinislam.class_creator.api.ClassCreator;
import ru.innopolis.student.dinislam.work_method_reader.MethodWorkReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс, создающий реализацию интерфейса Worker.
 */
public class WorkerClassCreator implements ClassCreator {

    /**
     * Название пакета в исходном коде класса.
     */
    private static final String PACKAGE = "package ru.innopolis.student.dinislam.worker.impl;";

    /**
     * Импорт класса, необходимое для исходного кода класса.
     */
    private static final String IMPORT = "import ru.innopolis.student.dinislam.worker.api.Worker;";

    /**
     * Директория, в которой будет создан класс.
     */
    private static final String DIRECTORY = "./src/main/java/ru/innopolis/student/dinislam/worker/impl/";

    /**
     * Создает файл с исходным кодом класса, реализующего интерфейс Worker, в пакете worker.
     *
     * @param className - имя класса.
     */
    @Override
    public void create(String className) {

        final File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir();
        }
        final File file = new File(dir, className + ".java");
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file))) {
            writer.write(getBodyOfClass(className));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Дает строковое представление исзодного кода файла .java класса, реализующего интерфейс Worker.
     *
     * @param className - имя класса.
     * @return - строковое представление тела файла .java класса, реализующего интерфейс Worker.
     */
    private String getBodyOfClass(String className) {
        return PACKAGE + doubleSeparator() +
                IMPORT + doubleSeparator() +
                "public class " + className + " implements Worker {" + doubleSeparator() +
                "\t@Override" + System.lineSeparator() +
                "\tpublic void doWork() {" + System.lineSeparator() +
                "\t\t" + MethodWorkReader.readMethodBody(System.in) + System.lineSeparator() +
                "\t}" + System.lineSeparator() +
                "}";
    }

    /**
     * Двойной переход строки.
     *
     * @return - Двойной переход строки.
     */
    private String doubleSeparator() {
        return System.lineSeparator() + System.lineSeparator();
    }
}
