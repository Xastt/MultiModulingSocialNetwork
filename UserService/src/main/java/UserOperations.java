import java.util.List;

public class UserOperations {
    private final UserService userService;

    public UserOperations(UserService userService) {
        this.userService = userService;
    }

    void addUser(User user) {
        userService.registerUser(user);
    }

    void getAllUsers() {
        List<User> users = userService.getUsers();
    }
}


