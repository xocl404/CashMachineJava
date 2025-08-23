package org.xocl404.domain.commands;

import org.xocl404.domain.models.AtmSystem;

public class CheckSystemPasswordCommand extends BaseCommand {
    public final AtmSystem atmSystem;

    public final String password;

    public CheckSystemPasswordCommand (AtmSystem atmSystem, String password) {
        this.atmSystem = atmSystem;
        this.password = password;
    }
}
