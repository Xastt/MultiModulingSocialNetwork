public interface MessageService {
    void sendMessage(User fromUserId, User toUserId, String message);
    boolean checkMessage(User fromUserId, User toUserId, String message);
}
