import lombok.*;

@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long userId;

    public Post(Long id, String title, String content, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
