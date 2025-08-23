package org.xocl404.domain.interfaces;

import org.xocl404.domain.commands.*;
import org.xocl404.domain.models.AtmSystem;

public interface ICommandsCreator {
    CheckSystemPasswordCommand createCheckSystemPasswordCommand(AtmSystem atmSysytem, String password);

    CreateNewUserCommand createCreateNewUserCommand(AtmSystem atmSystem, int pinCode);

    CheckBalanceCommand createCheckBalanceCommand(AtmSystem atmSystem, long accountNumber, int pinCode);

    CheckOperationsHistoryCommand createCheckOperationsHistoryCommand(AtmSystem atmSystem, long accountNumber, int pinCode);

    TopUpCommand createTopUpCommand(AtmSystem atmSystem, long accountNumber, int pinCode, int amount);

    WithdrawCommand createWithdrawCommand(AtmSystem atmSystem, long accountNumber, int pinCode, int amount);
}
