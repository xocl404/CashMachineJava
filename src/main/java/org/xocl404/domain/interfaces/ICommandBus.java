package org.xocl404.domain.interfaces;

import org.xocl404.domain.commands.BaseCommand;
import org.xocl404.domain.models.BaseDto;

public interface ICommandBus {
    BaseDto execute(BaseCommand command) throws Exception;
}
