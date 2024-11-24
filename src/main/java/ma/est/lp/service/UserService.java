package ma.est.lp.service;

import ma.est.lp.bean.User;
import ma.est.lp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    public User updateUser(User updateUser,Long id) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        return userDao.save(user);
    }


    public int deleteUser(Long id) {
        User user = userDao.findById(id).orElse(null);
        if (user == null) {
            return 0;
        }
        userDao.deleteById(user.getId());
        return 1;
    }
}
