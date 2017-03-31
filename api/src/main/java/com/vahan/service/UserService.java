package com.vahan.service;

import com.vahan.domain.User;
import com.vahan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

/**
 * Created by TCE\vahany on 3/29/17.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private SequenceDao sequenceDao;

    private static final String USER_SEQ_KEY = "user_seq";

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public User getUserById(long id){

       return userRepository.getUserById(id);
    }


    public void saveUser(String name, String password) {

        User user = new User();

        user.setId(sequenceDao.getNextSequenceId(USER_SEQ_KEY));

        user.setName(name.toLowerCase());

      //  user.setPassword(passwordEncoder().encode(password));

        user.setPassword(password);

        userRepository.save(user);
    }

    public boolean nameExists(String name){

        User user = userRepository.getUserByName(name.toLowerCase());

        if (user == null) return false;

        else return true;
    }

    public boolean userExists(String name, String password) {

        User user = userRepository.getUserByName(name.toLowerCase());

        if (user == null) return false;

        else {

        //    String encodedPassword = passwordEncoder().encode(password);

         //   if (user.getPassword().equals(encodedPassword)) return true;

            if (user.getPassword().equals(password))return true;

            else return false;


        }
    }
}
