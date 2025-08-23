package org.xocl404.application.handlers;

import org.xocl404.application.executors.UserRole;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.commands.CheckBalanceCommand;
import org.xocl404.domain.models.BaseDto;

public class CheckBalanceHandler extends BaseHandler {
    public BaseDto handle(BaseCommand command) throws Exception {
        if (command instanceof CheckBalanceCommand)
        {
            UserRole userRole = new UserRole();
            return userRole.checkBalance(((CheckBalanceCommand) command).atmSystem, ((CheckBalanceCommand) command).user);
        }
        if (next == null) throw new Exception("Invalid command.");

        return next.handle(command);
    }
}
