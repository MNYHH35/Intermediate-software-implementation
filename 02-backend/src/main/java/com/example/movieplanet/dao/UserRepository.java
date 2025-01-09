package com.example.movieplanet.dao;

import com.example.movieplanet.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
      Optional<Users> findByUserEmail(String userEmail);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM Users u WHERE u.userEmail = :email AND u.password = :password")
    boolean existsByUserEmailAndPassword(@Param("email") String email, @Param("password") String password);

    // 查询用户是否是vip
    @Query("SELECT CASE WHEN u.role = 'VIP' THEN TRUE ELSE FALSE END FROM Users u WHERE u.userEmail = :email")
    boolean isUserVip(@Param("email") String email);

    // 查询用户是否是管理员
    @Query("SELECT CASE WHEN u.role = 'ADMIN' THEN TRUE ELSE FALSE END FROM Users u WHERE u.userEmail = :email")
    boolean isUserAdmin(@Param("email") String email);
}