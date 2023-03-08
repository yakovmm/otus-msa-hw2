package ru.makovets.hw2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.makovets.hw2.exceptions.ResourceNotFoundException;
import ru.makovets.hw2.exceptions.UserFieldChangeException;
import ru.makovets.hw2.model.entities.User;
import ru.makovets.hw2.model.UserDto;
import ru.makovets.hw2.repository.UserRepository;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class Utils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^(\\+\\d{1,2}( )?)?(\\d{3}[ ]?){2}\\d{2}[ ]?\\d{2}$");
    private final UserRepository repository;

    public void checkUserDtoFields(UserDto userdto) {
        User editedUser;
        if (StringUtils.hasLength(userdto.getUsername())) {
            editedUser = repository.getUserByUsername(userdto.getUsername());
            if ((editedUser != null) && (!editedUser.getId().toString().equals(userdto.getId()))) {
                throw new UserFieldChangeException(String.format("Username %s already taken", userdto.getUsername()));
            }
        }
        String email = userdto.getEmail();
        if (StringUtils.hasLength(email)) {
            if (notMatchPattern(EMAIL_PATTERN, email)) {
                throw new UserFieldChangeException("Email format invalid. For example: 'adress@email.com'");
            }
            editedUser = repository.getUserByEmail(email);
            if ((editedUser != null) && (!editedUser.getId().toString().equals(userdto.getId()))) {
                throw new UserFieldChangeException(String.format("User with email %s already exists", email));
            }
        }
        if (!StringUtils.hasLength(userdto.getUsername())) {
            throw new UserFieldChangeException("Username should not be empty");
        }
        String phone = userdto.getPhone();
        if (StringUtils.hasLength(phone) && notMatchPattern(PHONE_PATTERN, phone)) {
            throw new UserFieldChangeException(
                    "Phone number format invalid. For example: '+11 999 123 00 01' or '+119991230001'");
        }
    }

    public User getUserById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with ID %d is not found", id)));
    }

    private static boolean notMatchPattern(Pattern pattern, String text) {
        return !pattern.matcher(text).matches();
    }
}
