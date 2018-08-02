package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;



public class UserListConverter implements Converter<String, User> {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User convert(String source) {
        User group = userRepository.findById(Long.parseLong(source));
        return  group;
    }

}
