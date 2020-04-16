package pl.haladyj.springsecurity2.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.haladyj.springsecurity2.model.User;
import pl.haladyj.springsecurity2.repository.UserRepository;
;import java.util.Optional;

public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);

        User u = user.orElseThrow(()-> new UsernameNotFoundException("User name not found"));

        return new SecurityUser(u);
    }
}
