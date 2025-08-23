package org.xocl404.application.creators;

import org.xocl404.domain.commands.*;
import org.xocl404.domain.interfaces.ICommandsCreator;
import org.xocl404.domain.models.AtmSystem;
import org.xocl404.domain.models.User;

public class CommandsCreator implements ICommandsCreator {
    public CheckSystemPasswordCommand createCheckSystemPasswordCommand(AtmSystem atmSysytem, String password) {
        return new CheckSystemPasswordCommand(atmSysytem, password);
    }

    public CreateNewUserCommand createCreateNewUserCommand(AtmSystem atmSystem, int pinCode) {
        return new CreateNewUserCommand(atmSystem, new User(pinCode));
    }

    public CheckBalanceCommand createCheckBalanceCommand(AtmSystem atmSystem, long accountNumber, int pinCode)
    {
        return new CheckBalanceCommand(atmSystem, new User(accountNumber, pinCode));
    }

    public CheckOperationsHistoryCommand createCheckOperationsHistoryCommand(AtmSystem atmSystem, long accountNumber, int pinCode)
    {
        return new CheckOperationsHistoryCommand(atmSystem, new User(accountNumber, pinCode));
    }

    public TopUpCommand createTopUpCommand(AtmSystem atmSystem, long accountNumber, int pinCode, int amount)
    {
        return new TopUpCommand(atmSystem, new User(accountNumber, pinCode), amount);
    }

    public WithdrawCommand createWithdrawCommand(AtmSystem atmSystem, long accountNumber, int pinCode, int amount)
    {
        return new WithdrawCommand(atmSystem, new User(accountNumber, pinCode), amount);
    }
}
