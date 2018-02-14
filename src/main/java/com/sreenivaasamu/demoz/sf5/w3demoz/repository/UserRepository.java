package com.sreenivaasamu.demoz.sf5.w3demoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sreenivaasamu.demoz.sf5.w3demoz.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

    @Override
    void delete(User user);

}
