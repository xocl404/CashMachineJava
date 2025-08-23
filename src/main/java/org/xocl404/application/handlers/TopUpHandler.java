package org.xocl404.application.handlers;

import org.xocl404.application.executors.UserRole;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.commands.TopUpCommand;
import org.xocl404.domain.models.BaseDto;

public class TopUpHandler extends BaseHandler {
    public BaseDto handle(BaseCommand command) throws Exception {
        if (command instanceof TopUpCommand)
        {
            var userRole = new UserRole();
            return userRole.topUp(((TopUpCommand) command).atmSystem, ((TopUpCommand) command).user, ((TopUpCommand) command).amount);
        }
        if (next == null) throw new Exception("Invalid command.");

        return next.handle(command);
    }
}
