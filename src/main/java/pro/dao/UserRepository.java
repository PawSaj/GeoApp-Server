package pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pro.model.entity.User;

@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT CASE WHEN count(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.username = :username AND u.password = :password")
    boolean userByNameAndPasswordExists(@Param(value = "username") String username, @Param(value = "password") String password);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findUserByUsername(@Param(value = "username") String username);


}
