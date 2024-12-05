import lombok.*;

@Setter
@Getter
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int age;
    private String gender;

    public User(String name, String email, String password, int age, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public User(Long requesterId) {}
}
