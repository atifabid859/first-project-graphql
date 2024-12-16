package com.code.graphql.repository;

import com.code.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
