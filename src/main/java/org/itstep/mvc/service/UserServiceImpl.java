package org.itstep.mvc.service;

import org.itstep.mvc.model.User;
import org.itstep.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            System.out.println("user not found with id = " + id);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
        System.out.println("saving user with id = " + user.getId());
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
        System.out.println("User with ID = " + id + " has been removed");
    }

    @Override
    public Page<User> pagination(int page, int size, String sortByField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortByField).ascending() : Sort.by(sortByField).descending();
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        return userRepository.findAll(pageable);
    }
}
