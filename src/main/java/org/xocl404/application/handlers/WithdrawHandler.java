package org.xocl404.application.handlers;

import org.xocl404.application.executors.UserRole;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.commands.WithdrawCommand;
import org.xocl404.domain.models.BaseDto;

public class WithdrawHandler extends BaseHandler {
    public BaseDto handle(BaseCommand command) throws Exception {
        if (command instanceof WithdrawCommand)
        {
            var userRole = new UserRole();
            return userRole.withdraw(((WithdrawCommand) command).atmSystem, ((WithdrawCommand) command).user, ((WithdrawCommand) command).amount);
        }
        if (next == null) throw new Exception("Invalid command.");;

        return next.handle(command);
    }
}
