package com.anshuman.service;

import com.anshuman.config.JwtProvider;
import com.anshuman.model.User;
import com.anshuman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromToken(jwt);
        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user==null)
            throw new Exception("User not found");
        return user;
    }

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty())
            throw new Exception("User not found");
        return optionalUser.get();
    }

    @Override
    public User updateUserProjectSize(User user, int number) throws Exception {
        user.setProjectSize(user.getProjectSize()+number);
        return userRepository.save(user);
    }
}
