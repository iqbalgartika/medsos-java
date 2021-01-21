package medsos.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public Map<String, String> signUp(@RequestBody ApplicationUser newUser) {
        HashMap<String, String> map = new HashMap<>();
        ApplicationUser user = applicationUserRepository.findByUsername(newUser.getUsername());
        if (user != null) {
            map.put("message", "User already exist!");
            return map;
        }

        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        applicationUserRepository.save(newUser);

        map.put("message", "User created!");
        map.put("id", newUser.getId());
        map.put("username", newUser.getUsername());
        return map;
    }
}