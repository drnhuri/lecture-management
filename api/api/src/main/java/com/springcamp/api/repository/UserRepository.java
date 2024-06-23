package com.springcamp.api.repository;

import com.springcamp.api.entity.User;
import com.springcamp.api.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByIdentityNo(String identityNo);

    List<User>findAllByRole(Role role);

    List<User>findAllByRoleAndIdIsNotIn(Role role,List<Integer> idList);
}
