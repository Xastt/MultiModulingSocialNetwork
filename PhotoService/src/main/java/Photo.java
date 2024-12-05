import lombok.*;

@Getter
@Setter
public class Photo {
    private Long id;
    private Long userId;
    private int[] data;

    public Photo(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }
}
