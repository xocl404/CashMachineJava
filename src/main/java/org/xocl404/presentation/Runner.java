package org.xocl404.presentation;

import org.xocl404.application.creators.CommandsCreator;
import org.xocl404.application.executors.CommandBus;
import org.xocl404.domain.models.*;

import java.util.Scanner;

public class Runner {
    public static void run(AtmSystem atmSystem, Scanner input) {
        while (true)
        {
            boolean stop = false;
            System.out.println("Select the role: administrator or user.");
            String role = input.nextLine();
            switch (role)
            {
                case "administrator":
                {
                    administratorRun(atmSystem, input);
                    break;
                }

                case "user":
                {
                    userRun(atmSystem, input);
                    break;
                }

                case "stop":
                {
                    stop = true;
                    break;
                }

                default:
                    System.out.println(String.format("Unknown role: %s!", role));
            }
            if (stop) break;
        }
    }

    private static void administratorRun(AtmSystem atmSystem, Scanner input)
    {
        var commandCreator = new CommandsCreator();
        var commandBus = new CommandBus();
        System.out.println("Enter the system password:");
        String password = input.nextLine();
        try {
            commandBus.execute(commandCreator.createCheckSystemPasswordCommand(atmSystem, password));
            System.out.println("Password is correct.");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void userRun(AtmSystem atmSystem, Scanner input)
    {
        var commandCreator = new CommandsCreator();
        var commandBus = new CommandBus();
        System.out.println("If you want to log in, write 'log in', if you want to register, write 'register'");
        String context = input.nextLine();
        switch (context)
        {
            case "register":
                System.out.println("Enter the pin-code:");
                int pinCode = Integer.parseInt(input.nextLine());
                try {
                    BaseDto dto = commandBus.execute(commandCreator.createCreateNewUserCommand(atmSystem, pinCode));
                    System.out.println(String.format("Your account number is %s",((NewAccountDto) dto).accountNumber));
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            case "log in":
                System.out.println("Enter the account number:");
                long accountNumber = Long.parseLong(input.nextLine());
                System.out.println("Enter the pin-code:");
                pinCode = Integer.parseInt(input.nextLine());
                System.out.println("If you want to check the account balance, write 'balance', " +
                        "if you want to top up your account, write '+', " +
                        "if you want to withdraw money from the account, write '-', " +
                        "if you want to check the history of operations, write 'history'");
                String command = input.nextLine();
                switch (command)
                {
                    case "balance":
                        try {
                            BaseDto dto = commandBus.execute(commandCreator.createCheckBalanceCommand(atmSystem, accountNumber, pinCode));
                            System.out.println(String.format("Your balance is %s",((BalanceDto) dto).balance));
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case "+":
                        System.out.println("Enter the amount:");
                        int amount = Integer.parseInt(input.nextLine());
                        try {
                            commandBus.execute(commandCreator.createTopUpCommand(atmSystem, accountNumber, pinCode, amount));
                            System.out.println("Balance update was successful");
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case "-":
                        System.out.println("Enter the amount:");
                        amount = Integer.parseInt(input.nextLine());
                        try {
                            commandBus.execute(commandCreator.createWithdrawCommand(atmSystem, accountNumber, pinCode, amount));
                            System.out.println("Balance update was successful");
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case "history":
                        try {
                            BaseDto dto = commandBus.execute(commandCreator.createCheckOperationsHistoryCommand(atmSystem, accountNumber, pinCode));
                            System.out.println("Operations history:");
                            for (int operation : ((OperationsHistoryDto) dto).operationsHistory) {
                                System.out.println(operation);
                            }
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    default:
                        System.out.println(String.format("Invalid input: %s", command));
                }
                break;

            default:
                System.out.println(String.format("Invalid input: %s", context));
        }
    }
}
