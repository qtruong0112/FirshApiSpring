package pqt03.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pqt03.spring.demo.domain.User;
import pqt03.spring.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;

    }

    public List<User> fetchAllUsers() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User reUser) {
        User currentUser = this.fetchUserById(reUser.getId());
        if (currentUser != null) {
            currentUser.setName(reUser.getName());
            currentUser.setEmail(reUser.getEmail());
            currentUser.setPassword(reUser.getPassword());
            return this.userRepository.save(currentUser);
        }
        return currentUser;
    }
}
