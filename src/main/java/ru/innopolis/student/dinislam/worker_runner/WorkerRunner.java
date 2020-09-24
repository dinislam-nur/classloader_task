package ru.innopolis.student.dinislam.worker_runner;

import ru.innopolis.student.dinislam.class_creator.impl.WorkerClassCreator;
import ru.innopolis.student.dinislam.worker.api.Worker;
import ru.innopolis.student.dinislam.worker_classloader.WorkerClassLoader;
import ru.innopolis.student.dinislam.worker_compiler.WorkerCompiler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Класс для запуска метода doWork реализации Worker.
 */
public class WorkerRunner {

    /**
     * Запускае медот doWork в рантайме.
     * Тело метода читается из консоли, пишется файл .java с исходным кодом в пакете реализации.
     * Этот файл компилируется в .class файл и загружается класслоадером в рантайме. У загруженного
     * класса вызывается метод doWork().
     *
     * @param className - имя класса, реализующего интерфейс Worker.
     */
    public void runWorker(String className) {

        new WorkerClassCreator().create(className);

        WorkerCompiler.compile(className);

        final WorkerClassLoader workerClassLoader = new WorkerClassLoader();
        try {
            final Class<?> workerImplementation = workerClassLoader.loadClass(className);
            final Constructor<?>[] constructor = workerImplementation.getDeclaredConstructors();
            Worker worker = (Worker) constructor[0].newInstance();
            worker.doWork();
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не скомпилировался");
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Ошибка инстанцирования класса реализации Worker");
            e.printStackTrace();
        }
    }
}
