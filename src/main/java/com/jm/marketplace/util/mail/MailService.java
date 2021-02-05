package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.user.User;

import java.io.File;
import java.util.Collection;

/**
 * Интерфейс сервиса для отправки почтовых сообщений
 */
public interface MailService {

    /**
     * Метод для отправки почтового сообщение без вложения
     *
     * @param user    экземпляр класса User
     * @param subject тема сообщения
     * @param message тело сообщения
     */
    void send(User user, String subject, String message);

    /**
     * Метод для отправки почтового сообщение с вложением
     *
     * @param user    экземпляр класса User
     * @param subject тема сообщения
     * @param message тело сообщения
     * @param files   файл или файлы для отправки
     */
    void send(User user, String subject, String message, File... files);

    /**
     * Метод для отправки почтового сообщение без вложения нескольким пользователям
     *
     * @param users   коллекция экземпляров класса User
     * @param subject тема сообщения
     * @param message тело сообщения
     */
    void broadcast(Collection<User> users, String subject, String message);

    /**
     * Метод для отправки почтового сообщение с вложением нескольким пользователям
     *
     * @param users   коллекция экземпляров класса User
     * @param subject тема сообщения
     * @param message тело сообщения
     * @param files   файл или файлы для отправки
     */
    void broadcast(Collection<User> users, String subject, String message, File... files);
}
