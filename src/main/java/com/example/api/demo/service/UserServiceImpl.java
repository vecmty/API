package com.example.api.demo.service;

import com.example.api.demo.model.User;
import com.example.api.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

//    private List<User> users = new ArrayList<>();
//    private long counter = 1;

/*    @Override
    public User create(User user) {
        long id = counter++;
        user.setId(id);
        users.add(user);
        return user;
    }

 */

    @Override
    public User create(User user) { ;
        userRepository.save(user);
        return user;
    }

/*    @Override
    public void delete(Long id) {
        int index = getIndex(id);
        users.remove(index);
    }
 */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

/*    @Override
    public User getById(Long id) {
        int index = getIndex(id);
        return users.get(index);
    }

 */

    @Override
    public User getById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null){
            return null;
        }
        return result;
    }

    /*
    @Override
    public User findByUsername(String name) {
        userRepository.findByUsername(name);

    }

     */

 /*   private int getIndex(Long id) {
        for (int i = 0; i < users.size(); i++) {
            User dbUser = users.get(i);
            Long userId = dbUser.getId();
            if (userId.equals(id)) {
                return i;
            }
        }
        throw new MyNotFoundException(String.format("User not found with id = %d", id));
    }


  */


/*    @Override
    public List<User> getAll() {
        return users;
    }

 */

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        return result;
    }

/*
    @Override
    public User update(User user, Long id) {
        int index = getIndex(id);
        user.setId(id);
        User dbUser = users.get(index);
        BeanUtils.copyProperties(user, dbUser);
        return dbUser;
    }

 */

}
