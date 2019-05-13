package co.pruebatecnica.masivian.users.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pruebatecnica.masivian.users.client.entities.User;
import co.pruebatecnica.masivian.users.client.entities.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllResultadoOperacion() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getResultadoOperacionById(int id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
    	userRepository.save(user);
    }

    public void delete(int id) {
    	userRepository.deleteById(id);
    }
}