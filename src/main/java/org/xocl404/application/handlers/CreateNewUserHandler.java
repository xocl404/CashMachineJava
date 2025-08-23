package org.xocl404.application.handlers;

import org.xocl404.application.executors.UserRole;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.commands.CreateNewUserCommand;
import org.xocl404.domain.models.BaseDto;

public class CreateNewUserHandler extends BaseHandler{
    public BaseDto handle(BaseCommand command) throws Exception {
        if (command instanceof CreateNewUserCommand)
        {
            var userRole = new UserRole();
            return userRole.addNewUser(((CreateNewUserCommand) command).atmSystem, ((CreateNewUserCommand) command).user);
        }
        if (next == null) throw new Exception("Invalid command.");;

        return next.handle(command);
    }
}
