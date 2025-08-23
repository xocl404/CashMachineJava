package org.xocl404.application.executors;

import org.xocl404.domain.interfaces.IUserRole;
import org.xocl404.domain.models.*;

public class UserRole implements IUserRole {
    public BaseDto addNewUser(AtmSystem atmSystem, User user) throws Exception {
        if (user.pinCode < 1000 || user.pinCode > 9999) throw new Exception("The Pin-code must consist of 4 digits.");
        atmSystem.repository.addUser(user.accountNumber, user.pinCode);
        return new NewAccountDto(user.accountNumber);
    }

    public BaseDto checkBalance(AtmSystem atmSystem, User user) throws Exception {
        if (!atmSystem.repository.isHaveAccountNumber(user.accountNumber)) throw new Exception("This account is not registered.");
        if (!atmSystem.repository.isCorrectPinCode(user.accountNumber, user.pinCode)) throw new Exception("Incorrect PIN-code.");
        return new BalanceDto(atmSystem.repository.getBalance(user.accountNumber));
    }

    public BaseDto checkOperationsHistory(AtmSystem atmSystem, User user) throws Exception {
        if (!atmSystem.repository.isHaveAccountNumber(user.accountNumber)) throw new Exception("This account is not registered.");
        if (!atmSystem.repository.isCorrectPinCode(user.accountNumber, user.pinCode)) throw new Exception("Incorrect PIN-code.");
        return new OperationsHistoryDto(atmSystem.repository.getOperationsHistory(user.accountNumber));
    }

    public BaseDto topUp(AtmSystem atmSystem, User user, int amount) throws Exception {
        if (!atmSystem.repository.isHaveAccountNumber(user.accountNumber)) throw new Exception("This account is not registered.");
        if (!atmSystem.repository.isCorrectPinCode(user.accountNumber, user.pinCode)) throw new Exception("Incorrect PIN-code.");
        atmSystem.repository.addOperation(user.accountNumber, amount);
        atmSystem.repository.updateBalance(user.accountNumber, atmSystem.repository.getBalance(user.accountNumber) + amount);
        return new BaseDto();
    }

    public BaseDto withdraw(AtmSystem atmSystem, User user, int amount) throws Exception {
        if (!atmSystem.repository.isHaveAccountNumber(user.accountNumber)) throw new Exception("This account is not registered.");
        if (!atmSystem.repository.isCorrectPinCode(user.accountNumber, user.pinCode)) throw new Exception("Incorrect PIN-code.");
        if (!atmSystem.repository.updateBalance(user.accountNumber,-amount)) throw new Exception("The balance is too low.");
        atmSystem.repository.addOperation(user.accountNumber, -amount);
        return new BaseDto();
    }
}
