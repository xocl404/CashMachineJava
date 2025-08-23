package org.xocl404.domain.interfaces;

import org.xocl404.domain.models.AtmSystem;
import org.xocl404.domain.models.BaseDto;
import org.xocl404.domain.models.User;

public interface IUserRole {
    BaseDto addNewUser(AtmSystem atmSystem, User user) throws Exception;

    BaseDto checkBalance(AtmSystem atmSystem, User user) throws Exception;

    BaseDto checkOperationsHistory(AtmSystem atmSystem, User user) throws Exception;

    BaseDto topUp(AtmSystem atmSystem, User user, int amount) throws Exception;

    BaseDto withdraw(AtmSystem atmSystem, User user, int amount) throws Exception;
}
