import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MakePostTest {

    private PhotoService photoService;
    private PostService postService;
    private UserService userService;
    private MakePost makePost;

    Long userId = 1L;
    Long postId = 2L;
    Long photoId = 3L;
    String title = "test";
    String content = "Wow, it works 0_0 !";
    User user = new User(userId);
    Photo photo = new Photo(photoId, userId);
    Post post = new Post(postId, title, content, userId);

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        postService = mock(PostService.class);
        photoService = mock(PhotoService.class);
        makePost = new MakePost(userService, photoService, postService);
    }

    @Test
    void makePost() {
        when(userService.getUserById(userId)).thenReturn(user);
        when(photoService.getPhotoById(photoId)).thenReturn(photo);
        when(postService.getPostById(postId)).thenReturn(post);
        makePost.makePost(userId, postId, photoId, content);
        verify(postService).createPost(user, content, post, photo);
    }
}