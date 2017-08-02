package pro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.dao.UserRepository;
import pro.dto.UserDto;
import pro.mapping.UserMapper;
import pro.model.entity.User;

@Service
@Transactional
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

//    @PreAuthorize("hasAuthority('ADIMN')")
    public UserDto getUserByUsername(String username) {
        logger.debug("getUserByUsername, username={}", username);
        User user = userRepository.findUserByUsername(username);
        return userMapper.map(user);
    }

    public boolean userByNameAndPasswordExists(String username, String password) {
        return userRepository.userByNameAndPasswordExists(username, password);
    }

    public void insertUserToDatabase(User user) {
        userRepository.save(user);
    }
}
