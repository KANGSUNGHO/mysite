package com.bit2020.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2020.mysite.repository.UserRepository;
import com.bit2020.mysite.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void join(UserVo userVo) {
		userRepository.save(userVo);
	}

	public UserVo getUser(UserVo vo) {
		return userRepository.findByEmailAndPassword(vo);
	}

	public UserVo getUser(Long no) {
		UserVo userVo = userRepository.findByNo(no);
		return userVo;
	}
	
	public void upadteUser(UserVo vo) {
		userRepository.update(vo);
	}

	public boolean existUser(String email) {
		Object userVo = userRepository.findByEmail(email);
//		System.out.println(userVo);
		return userVo != null;
	}


}
