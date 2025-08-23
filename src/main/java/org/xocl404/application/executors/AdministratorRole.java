package org.xocl404.application.executors;

import org.xocl404.domain.interfaces.IAdministratorRole;
import org.xocl404.domain.models.AtmSystem;
import org.xocl404.domain.models.BaseDto;

public class AdministratorRole implements IAdministratorRole {
    public BaseDto checkSystemPassword(AtmSystem atmSystem, String password) throws Exception {
        if (!atmSystem.checkPassword(password)) throw new Exception("Password is incorrect.");
        return new BaseDto();
    }
}
