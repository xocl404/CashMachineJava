package org.xocl404;

import org.junit.jupiter.api.Test;
import org.xocl404.application.creators.CommandsCreator;
import org.xocl404.application.executors.CommandBus;
import org.xocl404.domain.models.AtmSystem;
import org.xocl404.infrastructure.repositories.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void PinCodeCheck() {
        AtmSystem atmSystem = new AtmSystem("1234", new Repository());
        var commandBus = new CommandBus();
        var commandsCreator = new CommandsCreator();
        String message = "";
        try {
            commandBus.execute(commandsCreator.createCreateNewUserCommand(atmSystem, 12345));
        } catch (Exception exception) {
            message = exception.getMessage();
        }
        assertEquals("The Pin-code must consist of 4 digits.", message);
    }

    @Test
    public void IncorrectPinCodeCheck() {
        AtmSystem atmSystem = new AtmSystem("1234", new Repository());
        var commandBus = new CommandBus();
        var commandsCreator = new CommandsCreator();
        String message = "";
        try {
            commandBus.execute(commandsCreator.createCreateNewUserCommand(atmSystem, 1234));
            commandBus.execute(commandsCreator.createCheckBalanceCommand(atmSystem, 2, 1111));
        } catch (Exception exception) {
           message = exception.getMessage();
        }
        assertEquals("Incorrect PIN-code.", message);
    }

    @Test
    public void IncorrectAccountNumberCheck(){
        AtmSystem atmSystem = new AtmSystem("1234", new Repository());
        var commandBus = new CommandBus();
        var commandsCreator = new CommandsCreator();
        String message = "";
        try {
            commandBus.execute(commandsCreator.createCheckBalanceCommand(atmSystem, 5, 1111));
        } catch (Exception exception) {
            message = exception.getMessage();
        }
        assertEquals("This account is not registered.", message);
    }

    @Test
    public void negativeBalanceCheck(){
        AtmSystem atmSystem = new AtmSystem("1234", new Repository());
        var commandBus = new CommandBus();
        var commandsCreator = new CommandsCreator();
        String message = "";
        try {
            commandBus.execute(commandsCreator.createCreateNewUserCommand(atmSystem, 1234));
            commandBus.execute(commandsCreator.createWithdrawCommand(atmSystem, 3, 1234, 45));
        } catch (Exception exception) {
            message = exception.getMessage();
        }
        assertEquals("The balance is too low.", message);
    }
}
