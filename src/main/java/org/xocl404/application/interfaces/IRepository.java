package org.xocl404.application.interfaces;

import java.util.ArrayList;

public interface IRepository {
    boolean isHaveAccountNumber(long accountNumber);

    boolean isCorrectPinCode(long accountNumber, int pinCode);

    void addUser(long accountNumber, int pinCode);

    int getBalance(long accountNumber);

    void addOperation(long accountNumber, int amount);

    boolean updateBalance(long accountNumber, int amount);

    ArrayList<Integer> getOperationsHistory(long accountNumber);
}
