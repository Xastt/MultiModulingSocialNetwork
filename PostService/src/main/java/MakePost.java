public class MakePost {
    private final UserService userService;
    private final PhotoService photoService;
    private final PostService postService;

    public MakePost(UserService userService, PhotoService photoService, PostService postService) {
        this.userService = userService;
        this.photoService = photoService;
        this.postService = postService;
    }

    public void makePost(Long userId, Long postId, Long photoId, String content) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);
        Photo photo = photoService.getPhotoById(photoId);
        postService.createPost(user, content, post, photo);
    }
}
