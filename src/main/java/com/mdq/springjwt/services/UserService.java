package com.mdq.springjwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdq.springjwt.models.User;
import com.mdq.springjwt.repository.UserRepository;





@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public List<User> findAll() {return userRepository.findAll();}

    public User save(User entity) {return userRepository.save(entity);}

    public Optional<User> findById(Long id) {return userRepository.findById(id);}

    public void deleteById(Long id){
    	userRepository.deleteById(id);
    }
    public void update(User user){
    	userRepository.save(user);
    }
    
   

}
