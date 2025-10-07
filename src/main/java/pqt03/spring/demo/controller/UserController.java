package pqt03.spring.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pqt03.spring.demo.domain.User;
import pqt03.spring.demo.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User crateNewUser(
            @RequestBody User postManUser
    ) {

        // User user = new User();
        // user.setName("John Doe");
        // user.setEmail("pqt@gmail.com");
        // user.setPassword("123");
        User pqtUser = this.userService.handleCreateUser(postManUser);

        return pqtUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        this.userService.handleDeleteUser(id);
        return "User deleted successfully";
    }
}
