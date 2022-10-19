package name.beptest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import name.beptest.dto.UserDTO;


public interface UserDao extends JpaRepository<UserDTO, Integer>{
	@Query(value = "SELECT	u.idx as idx, "
							+ "u.id as id, "
							+ "u.password as password, "
							+ "u.user_role as userRole "
					+ "FROM USER_TBL u "
					+ "WHERE u.id = :#{#userDto.id} "
					+ "AND u.password = :#{#userDto.password}", nativeQuery = true)
	List<UserDTO> loginUser(@Param("userDto")UserDTO userDto);
	
	UserDTO findByPasswordAndId(String password, String id);
}
