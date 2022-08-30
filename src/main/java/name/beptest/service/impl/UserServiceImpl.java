package name.beptest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.beptest.dao.UserDao;
import name.beptest.dto.UserDTO;
import name.beptest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserDTO userDto) {
		userDao.save(userDto);
	}

	@Override
	public void allUser() {
		System.out.println(userDao.findAll());
	}
}
