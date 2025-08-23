package org.xocl404.infrastructure.repositories;

import org.xocl404.application.interfaces.IRepository;
import org.xocl404.infrastructure.database.DataBase;

import java.util.ArrayList;

/**
 * Класс для работы с банкоматом.
 */
public class Repository implements IRepository {
    private final DataBase dataBase = new DataBase();

    /**
     * Метод, который проверяет наличие аккаунта в базе по его номеру
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @return boolean - результат проверки наличия аккаунта
     */
    public boolean isHaveAccountNumber(long accountNumber) {
        return dataBase.userList.containsKey(accountNumber);
    }

    /**
     * Метод, который проверяет правильность ввода ПИН-кода
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @param pinCode - ПИН-код, который вводит пользователь
     *
     * @return boolean - результат проверки правильности ПИН-кода
     */
    public boolean isCorrectPinCode(long accountNumber, int pinCode) {
        return dataBase.userList.get(accountNumber) == pinCode;
    }

    /**
     * Метод, который добавляет нового пользователя
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @param pinCode - ПИН-код, который вводит пользователь
     */
    public void addUser(long accountNumber, int pinCode) {
        dataBase.userList.put(accountNumber, pinCode);
        dataBase.accountList.put(accountNumber, 0);
        dataBase.operationList.put(accountNumber, new ArrayList<>());
    }

    /**
     * Метод, который возвращает баланс аккаунта
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @return int - возвращается запрашиваемый баланс
     */
    public int getBalance(long accountNumber)
    {
        return dataBase.accountList.get(accountNumber);
    }

    /**
     * Метод, добавляет в новую операцию в список операций
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @param amount - сумма операции
     */
    public void addOperation(long accountNumber, int amount) {
        dataBase.operationList.get(accountNumber).add(amount);
    }

    /**
     * Метод, который обновляет баланс пользователя
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @param amount - сумма изменения баланса
     *
     * @return boolean - результат изменения (успешность)
     */
    public boolean updateBalance(long accountNumber, int amount)
    {
        int newBalance = dataBase.accountList.get(accountNumber) + amount;

        if (newBalance < 0) return false;
        dataBase.accountList.remove(accountNumber);
        dataBase.accountList.put(accountNumber, newBalance);
        return true;
    }

    /**
     * Метод, возвращает историю операций пользователя
     *
     * @param accountNumber - номер аккаунта, который вводит пользователь
     *
     * @return boolean - результат изменения (успешность)
     */
    public ArrayList<Integer> getOperationsHistory(long accountNumber)
    {
        return dataBase.operationList.get(accountNumber);
    }
}
