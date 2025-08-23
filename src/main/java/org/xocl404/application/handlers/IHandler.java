package org.xocl404.application.handlers;

import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.models.BaseDto;

public interface IHandler {
    IHandler addNext(IHandler handler);

    BaseDto handle(BaseCommand command) throws Exception;
}
