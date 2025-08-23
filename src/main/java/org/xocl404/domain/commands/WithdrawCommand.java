package org.xocl404.domain.commands;

import org.xocl404.domain.models.AtmSystem;
import org.xocl404.domain.models.User;

public class WithdrawCommand extends BaseCommand {
    public final AtmSystem atmSystem;

    public final User user;

    public final int amount;

    public WithdrawCommand (AtmSystem atmSystem, User user, int amount) {
        this.atmSystem = atmSystem;
        this.user = user;
        this.amount = amount;
    }
}
