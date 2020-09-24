package ru.innopolis.student.dinislam.worker_compiler;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.Arrays;

/**
 * Интерфейс, компилирующий класс, реализующий интерфейс Worker.
 */
public interface WorkerCompiler {

    /**
     * Директория, откуда читать заивисимости и куда записывать скомпилированный класс.
     */
    String TARGET_CLASSES = "./target/classes";

    /**
     * Директория, октуда искать исходный код класса.
     */
    String WORKER_IMPLEMENTATION_DIR = "src/main/java/ru/innopolis/student/dinislam/worker/impl/";

    /**
     * Компилируют исходный код в байт код класса, реализующего интерфейс Worker.
     *
     * @param className - имя класса.
     */
    static void compile(String className) {
        final JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        final StandardJavaFileManager standardFileManager = javac.getStandardFileManager(null, null, null);
        final Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager
                .getJavaFileObjects(
                        new File(WORKER_IMPLEMENTATION_DIR + className + ".java"));

        final JavaCompiler.CompilationTask task = javac.getTask(
                null,
                null,
                null,
                Arrays.asList("-cp", TARGET_CLASSES, "-d", TARGET_CLASSES),
                null,
                javaFileObjects);
        task.call();
    }
}
