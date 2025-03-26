package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO registerUser(UserVO uvo);

	UserVO getUser(long id);

	List<UserVO> getAllUsers();

}