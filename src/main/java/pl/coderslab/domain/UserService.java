package pl.coderslab.domain;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
