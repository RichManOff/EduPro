package com.example.diplomaproject.service;

import com.example.diplomaproject.configuration.Encoder;
import com.example.diplomaproject.model.Role;
import com.example.diplomaproject.model.User;
import com.example.diplomaproject.repository.RoleRepository;
import com.example.diplomaproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountDetailsService implements UserDetailsService {
    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private Encoder encoder;
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Account with such username doesn't exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

    public boolean signup(User account) {
            User accountDB = userRepository.findByUsername(account.getUsername());
            if (accountDB != null) {
                log.info("User already exists.");
                return false;
            }

            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                // Handle case where "ROLE_USER" role is not found in the database
                log.error("Default role not found in the database.");
                return false;
            }

            account.setRoles(Collections.singleton(userRole));
            account.setPassword(encoder.passwordEncoder().encode(account.getPassword()));
            userRepository.save(account);

            log.info("User registered successfully.");
            return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public boolean getAccountByUsername(String username, String password) {
        log.info("Checking user account with username: {}", username);
        User userOptional = findByUsername(username);
        log.info("Retrieved user: {}", userOptional);
        if (userOptional == null) {
            log.info("useer nit found");
            return false; // User not found
        }

        if (!encoder.passwordEncoder().matches(password, userOptional.getPassword())) {
            log.info("pass nit found", userOptional.getPassword());

            return false; // Incorrect password
        }
        log.info(" user successful: {}", userOptional);

        return true; // Username and password are correct
    }



    public List<User> getAll(){
        ArrayList<User> accounts = (ArrayList<User>) userRepository.findAll();

        return accounts;
    }


    public void create(User user) {
        userRepository.save(user);
    }

    public void update(User account) {
        userRepository.save(account);
    }

    public void delete(long id){
        User account = new User();
        account.setId(id);
        userRepository.delete(account);
    }

    public User findUserById(Long id) {
        Optional<User> accountOptional = userRepository.findById(id);
        if(accountOptional.isPresent()){
            User account = accountOptional.get();
            return account;
        }
        return null;
    }


}
