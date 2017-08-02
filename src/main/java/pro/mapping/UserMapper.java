package pro.mapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pro.dto.UserDto;
import pro.model.entity.User;

@Component
public class UserMapper  {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public UserDto map(User user) {
        logger.debug("map, user={}", user);
        if(user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
