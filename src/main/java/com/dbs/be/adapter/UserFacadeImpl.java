package com.dbs.be.adapter;

import com.dbs.be.domain.user.User;
import com.dbs.be.port.repository.UserRepository;
import com.dbs.be.port.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserRepository userRepository;
    @Override
    public User getUser(String id) {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else throw new RuntimeException("Cant find user!");
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
