package field.ryan.rfvhbackend.controllers;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import field.ryan.rfvhbackend.repositories.User;
import field.ryan.rfvhbackend.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return IterableUtils.toList(userRepository.findAll());
  }

  @PostMapping("/users")
  void addUser(@RequestBody User user) {
    userRepository.save(user);
  }

}
