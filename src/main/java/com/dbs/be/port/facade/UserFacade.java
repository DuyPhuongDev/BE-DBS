package com.dbs.be.port.facade;

import com.dbs.be.domain.user.User;

import java.util.List;

public interface UserFacade {
    User getUser(String id);

    List<User> getAll();
}
