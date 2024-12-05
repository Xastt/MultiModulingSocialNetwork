import java.util.List;

public interface FriendService {
    void addFriend(User userId, User friendId);
    void removeFriend(User userId, User friendId);
    List<User> getFriends(User userId);
}
