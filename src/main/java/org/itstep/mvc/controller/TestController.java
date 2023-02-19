package org.itstep.mvc.controller;

import org.itstep.mvc.model.User;
import org.itstep.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/insert")
    public @ResponseBody String insert(@RequestParam String userName,
                                       @RequestParam String userLastName,
                                       @RequestParam String email) {
        User user = new User(userName, userLastName, email);
        repository.save(user);
        return "INSERTED";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> showAll() {
        List<User> users = repository.findAll();
        return users;
    }


}
