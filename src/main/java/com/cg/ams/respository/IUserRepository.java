package com.cg.ams.respository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByLogin(String login);

	List<UserEntity> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String firstname, String lastname);

	List<UserEntity> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String firstname, String lastname,
			Pageable pageable);
}
