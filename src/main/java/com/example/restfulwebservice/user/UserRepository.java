package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository<다룰 Entity, 기본 키 타입>
public interface UserRepository extends JpaRepository<User, Integer> {
}
