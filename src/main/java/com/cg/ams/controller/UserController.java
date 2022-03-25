package com.cg.ams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.UserEntity;
import com.cg.ams.service.IUserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	// Generic Success Message
	static final String GEN_SUCCESS_MESSAGE = "Option successful!";

	@Autowired
	IUserService userService;

	@PostMapping(path = "/add")
	ResponseEntity<String> addUser(@Valid @RequestBody UserEntity userEntity) {
		long id = userService.add(userEntity);
		String returnMsg = "User added with ID: ";

		return new ResponseEntity<>(returnMsg + id, HttpStatus.CREATED);
	}

	@PutMapping(path = "/update")
	ResponseEntity<String> updateUser(@Valid @RequestBody UserEntity userEntity) {
		userService.update(userEntity);

		return new ResponseEntity<>(GEN_SUCCESS_MESSAGE, HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete")
	ResponseEntity<String> deleteUser(@Valid @RequestBody UserEntity userEntity) {
		userService.delete(userEntity);

		return new ResponseEntity<>(GEN_SUCCESS_MESSAGE, HttpStatus.OK);
	}

	@GetMapping(path = "/login/{login}")
	ResponseEntity<UserEntity> getUserByLogin(@PathVariable("login") String login) {
		return new ResponseEntity<>(userService.findByLogin(login), HttpStatus.OK);
	}

	@GetMapping(path = "/id/{id}")
	ResponseEntity<UserEntity> getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<>(userService.findByPk(id), HttpStatus.OK);
	}

	@GetMapping(path = "/search")
	ResponseEntity<List<UserEntity>> search(@RequestParam("name") String name) {

		return new ResponseEntity<>(userService.search(name), HttpStatus.OK);
	}

	@GetMapping(path = "/search/{name}")
	ResponseEntity<List<UserEntity>> search(@PathVariable String name,
			@RequestParam(value = "page", defaultValue = "0") int pageNo,
			@RequestParam(value = "size", defaultValue = "10") int pageSize) {
		return new ResponseEntity<>(userService.search(name, pageNo, pageSize), HttpStatus.OK);
	}

	@GetMapping(path = "/authenticate")
	ResponseEntity<UserEntity> authenticate(@RequestBody UserEntity userEntity) {
		return new ResponseEntity<>(userService.authenticate(userEntity), HttpStatus.OK);
	}

	@PatchMapping(path = "/change-password/{id}")
	ResponseEntity<String> changePassword(@PathVariable("id") long id, @RequestParam("oldPassword") String oldPassword,
			@RequestBody String newPassword) {
		userService.changePassword(id, oldPassword, newPassword);
		return new ResponseEntity<>("Password Changed Successfully!", HttpStatus.OK);
	}

	@PostMapping(path = "/register")
	ResponseEntity<String> registerUser(@Valid @RequestBody UserEntity userEntity) {
		long id = userService.registerUser(userEntity);
		return new ResponseEntity<>("User registered with id: " + id, HttpStatus.OK);
	}

	@PatchMapping(path = "/forgot-password/{login}")
	ResponseEntity<String> forgetPassword(@PathVariable("login") String login, @RequestBody String newPassword) {
		userService.forgetPassword(login, newPassword);
		return new ResponseEntity<>(GEN_SUCCESS_MESSAGE, HttpStatus.OK);
	}
}
