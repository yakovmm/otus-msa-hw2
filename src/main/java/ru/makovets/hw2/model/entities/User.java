package ru.makovets.hw2.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import ru.makovets.hw2.model.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users", schema = "test_hw2")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256)
    @NotBlank(message = "Username should not be empty")
    private String username;

    @Column
    @Nullable
    private String firstname;

    @Column
    @Nullable
    private String lastname;

    @Column
    @NotBlank(message = "Email must have text")
    @Pattern(regexp = "^[^@]+@[^@]+\\.[^@]+$", message = "Email format invalid, example: 'adress@email.com'")
    private String email;

    @Column
    @NotBlank(message = "Phone number must have text")
    @Pattern(regexp = "^(\\+\\d{1,2}( )?)?(\\d{3}[ ]?){2}\\d{2}[ ]?\\d{2}$",
            message = "Phone number format invalid, example: '+11 999 123 00 01' or '+119991230001'")
    private String phone;

    public User(UserDto userDto) {
        merge(userDto);
    }

    public void setPhone(String phone) {
        if (phone != null) {
            this.phone = phone.replace(" ", "");
        }
    }

    public void merge(UserDto userDto) {
        String dtoId = userDto.getId();
        if ((dtoId != null) && (dtoId.matches("\\d+"))) {
            setId(Long.valueOf(dtoId));
        }

        String dtoFirstname = userDto.getFirstname();
        if (StringUtils.hasLength(dtoFirstname)) {
            setFirstname(dtoFirstname);
        }

        String dtoLastname = userDto.getLastname();
        if (StringUtils.hasLength(dtoLastname)) {
            setLastname(dtoLastname);
        }

        String dtoEmail = userDto.getEmail();
        if (StringUtils.hasLength(dtoEmail)) {
            setEmail(dtoEmail);
        }

        String dtoUsername = userDto.getUsername();
        if (StringUtils.hasLength(dtoUsername)) {
            setUsername(dtoUsername);
        }

        String dtoPhone = userDto.getPhone();
        if (StringUtils.hasLength(dtoPhone)) {
            setPhone(dtoPhone);
        }
    }

    public void copy(UserDto userDto) {
        String dtoId = userDto.getId();
        if (dtoId != null) {
            setId(Long.valueOf(dtoId));
        }
        setFirstname(userDto.getFirstname());
        setLastname(userDto.getLastname());
        setEmail(userDto.getEmail());
        setUsername(userDto.getUsername());
        setPhone(userDto.getPhone());
    }

    public UserDto toDTO() {
        return UserDto.builder()
                .id(String.valueOf(id))
                .username(username)
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .build();
    }
}
