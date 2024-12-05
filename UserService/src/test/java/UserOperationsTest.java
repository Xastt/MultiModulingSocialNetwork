import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class UserOperationsTest {

    private UserService userService;
    private UserOperations userOperations;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        userOperations = new UserOperations(userService);
    }

    @Test
    void addUser() {
        String name = "Jackie";
        String email = "jackie@mail.ru";
        String password = "passforus";
        int age = 99;
        String gender = "male";
        User user = new User(name, email, password, age, gender);
        userOperations.addUser(user);
        verify(userService).registerUser(user);
    }

    @Test
    void getAllUsers() {
        List<User> mockUserList = new ArrayList<>();
        mockUserList.add(new User("Alice", "alice@example.com", "pass123", 25, "Female"));
        mockUserList.add(new User("Bob", "bob@example.com", "pass456", 29, "Male"));
        when(userService.getUsers()).thenReturn(mockUserList);
        userOperations.getAllUsers();
        verify(userService).getUsers();
    }
}