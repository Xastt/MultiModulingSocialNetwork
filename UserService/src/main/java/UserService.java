import java.util.List;

public interface UserService {
    void registerUser(User user);
    User getUserById(Long id);
    List<User> getUsers();
}
