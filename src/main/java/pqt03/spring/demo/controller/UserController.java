package pqt03.spring.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pqt03.spring.demo.domain.User;
import pqt03.spring.demo.service.UserService;
import pqt03.spring.demo.service.error.IdInvalidException;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(
            @RequestBody User postManUser
    ) {

        // User user = new User();
        // user.setName("John Doe");
        // user.setEmail("pqt@gmail.com");
        // user.setPassword("123");
        User pqtUser = this.userService.handleCreateUser(postManUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(pqtUser);
    }

    

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws IdInvalidException {
        if (id >= 1500) {
            throw new IdInvalidException("ID is invalid, must be less than 1500");
        }
        this.userService.handleDeleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {

        User prtUser = this.userService.fetchUserById(id);
        // ResponseEntity.ok(prtUser);
        return ResponseEntity.status(HttpStatus.OK).body(prtUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.fetchAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUserByBody(@RequestBody User user) {
        User pqt = this.userService.handleUpdateUser(user);
        if (pqt != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pqt);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
