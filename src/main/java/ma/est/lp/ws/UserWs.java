package ma.est.lp.ws;


import ma.est.lp.bean.User;
import ma.est.lp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserWs {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("user")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("user/{userId}")
    public User save(@PathVariable long userId, @RequestBody User user) {
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("user/{userId}")
    public int save(@PathVariable long userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable long userId) {
        return userService.getUserById(userId);
    }
}
