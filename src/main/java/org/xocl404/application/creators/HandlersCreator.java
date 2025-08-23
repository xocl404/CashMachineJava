package org.xocl404.application.creators;

import org.xocl404.application.handlers.*;

public class HandlersCreator {
    public static IHandler create() {
        IHandler handler = new CheckSystemPasswordHandler()
                .addNext(new CreateNewUserHandler())
                .addNext(new CheckBalanceHandler())
                .addNext(new CheckOperationsHistoryHandler())
                .addNext(new TopUpHandler())
                .addNext(new WithdrawHandler());
        return handler;
    }
}
