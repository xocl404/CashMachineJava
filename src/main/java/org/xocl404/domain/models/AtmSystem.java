package org.xocl404.domain.models;

import org.xocl404.application.interfaces.IRepository;

import java.util.Objects;

/**
 * Класс для работы с банкоматом.
 */
public class AtmSystem {
    private final String systemPassword;

    public final IRepository repository;

    public AtmSystem(String systemPassword, IRepository repository) {
        this.systemPassword = systemPassword;
        this.repository = repository;
    }

    /**
     * Метод, который проверяет правильность пароля администратора
     *
     * @param password - пароль, который пользователь вводит в качестве пароля администратора
     *
     * @return boolean - результат проверки правильности пароля
     */
    public boolean checkPassword(String password) {
        return Objects.equals(password, systemPassword);
    }

}
