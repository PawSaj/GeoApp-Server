package pro.security;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pro.dto.UserDto;
import pro.service.UserService;

@Component
public class MyUserDetailService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("loadUserByUsername, username={}", username);

        UserDto user = userService.getUserByUsername(username);

        if(user == null) {
            //throw new UsernameNotFoundException("User not found");
            return null;
        }

        return new User(user.getUsername(), "", Collections.singletonList(new SimpleGrantedAuthority("ROLE")));
    }


}
