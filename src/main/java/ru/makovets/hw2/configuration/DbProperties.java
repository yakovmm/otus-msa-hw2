package ru.makovets.hw2.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.StringJoiner;

@Slf4j
@ToString
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.datasource")
public class DbProperties {

    private static final String ERROR_MSG_PATTERN = "Environment variable %s is empty. Please set it";
    private String username;
    private String password;
    private String url;

    @PostConstruct
    public void printInit() {
        log.info(toString());
        StringJoiner errors = new StringJoiner(", ");
        if (url.equals("${DB_HOST}")) {
            errors.add("DB_HOST");
        }
        if (username.equals("${DB_USER}")) {
            errors.add("DB_USER");
        }
        if (password.equals("${DB_PASSWORD}")) {
            errors.add("DB_PASSWORD");
        }
        if (errors.length() > 0) {
            throw new IllegalArgumentException(String.format(ERROR_MSG_PATTERN, errors));
        }
    }
}
