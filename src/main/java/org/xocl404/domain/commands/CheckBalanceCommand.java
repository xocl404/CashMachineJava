package org.xocl404.domain.commands;

import org.xocl404.domain.models.AtmSystem;
import org.xocl404.domain.models.User;

public class CheckBalanceCommand extends BaseCommand {
    public final AtmSystem atmSystem;

    public final User user;

    public CheckBalanceCommand(AtmSystem atmSystem, User user) {
        this.atmSystem = atmSystem;
        this.user = user;
    }
}
