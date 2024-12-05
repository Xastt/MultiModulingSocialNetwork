public interface PostService {
    void createPost(User userId, String content, Post post, Photo photo);
    Post getPostById(Long post);
}
