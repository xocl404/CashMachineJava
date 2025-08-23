package org.xocl404.application.handlers;

import org.xocl404.application.executors.AdministratorRole;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.commands.CheckSystemPasswordCommand;
import org.xocl404.domain.models.BaseDto;

public class CheckSystemPasswordHandler extends BaseHandler {
    public BaseDto handle(BaseCommand command) throws Exception {
        if (command instanceof CheckSystemPasswordCommand)
        {
            var administratorRole = new AdministratorRole();
            return administratorRole.checkSystemPassword(((CheckSystemPasswordCommand) command).atmSystem, ((CheckSystemPasswordCommand) command).password);
        }
        if (next == null) throw new Exception("Invalid command.");;

        return next.handle(command);
    }
}
