package com.springcamp.api.service.impl;

import com.springcamp.api.common.GeneralException;
import com.springcamp.api.entity.User;
import com.springcamp.api.entity.enums.Role;
import com.springcamp.api.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements com.springcamp.api.service.UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User save(User user){
        if(user.getId() == null){
            if(user.getIdentityNo() == null || user.getIdentityNo().length() != 11){
                throw new GeneralException("Invalid Identity No");
            }
            if(userRepository.existsByIdentityNo(user.getIdentityNo())){
                throw new GeneralException("Identity No Already Exists");
            }
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id){
        return userRepository.findById(id).orElseThrow(()->new GeneralException("User not found"));
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id){
        if (!userRepository.existsById(id)){
            throw new GeneralException("User Not Found!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> ids) {
        if (ids.isEmpty()) {
            return getUsersByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdIsNotIn(Role.STUDENT,ids);
    }

}
