package name.beptest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import name.beptest.dto.UserDTO;


public interface UserDao extends JpaRepository<UserDTO, Integer>{

}
