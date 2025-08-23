package org.xocl404.application.handlers;

import org.xocl404.application.executors.UserRole;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.commands.CheckOperationsHistoryCommand;
import org.xocl404.domain.models.BaseDto;

public class CheckOperationsHistoryHandler extends BaseHandler{
    public BaseDto handle(BaseCommand command) throws Exception {
        if (command instanceof CheckOperationsHistoryCommand)
        {
            var userRole = new UserRole();
            return userRole.checkOperationsHistory(((CheckOperationsHistoryCommand) command).atmSystem, ((CheckOperationsHistoryCommand) command).user);
        }
        if (next == null) throw new Exception("Invalid command.");

        return next.handle(command);
    }
}
