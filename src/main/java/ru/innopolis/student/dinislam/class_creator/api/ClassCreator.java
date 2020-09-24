package ru.innopolis.student.dinislam.class_creator.api;

/**
 * Интерфейс для создания java класса.
 */
public interface ClassCreator {

    /**
     * Создает java класс с именем className.
     *
     * @param className - имя класса.
     */
    void create(String className);
}
