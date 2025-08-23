package org.xocl404.domain.interfaces;

import org.xocl404.domain.models.AtmSystem;
import org.xocl404.domain.models.BaseDto;

public interface IAdministratorRole {
    BaseDto checkSystemPassword(AtmSystem atmSystem, String password) throws Exception;
}
