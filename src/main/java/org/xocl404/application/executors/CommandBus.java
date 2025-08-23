package org.xocl404.application.executors;

import org.xocl404.application.creators.HandlersCreator;
import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.interfaces.ICommandBus;
import org.xocl404.domain.models.BaseDto;

public class CommandBus implements ICommandBus {
    public BaseDto execute(BaseCommand command) throws Exception {
        return HandlersCreator.create().handle(command);
    }
}
