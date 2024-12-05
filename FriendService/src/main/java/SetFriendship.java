public class SetFriendship {

    private final UserService userService;
    private final FriendService friendService;

    public SetFriendship(UserService userService, FriendService friendService) {
        this.userService = userService;
        this.friendService = friendService;
    }

    public void sendFriendRequest(Long requesterId, Long recipientId) {
        User requester = userService.getUserById(requesterId);
        User recipient = userService.getUserById(recipientId);
        friendService.addFriend(requester, recipient);
    }

    public void removeFriendRequest(Long requesterId, Long recipientId) {
        User requester = userService.getUserById(requesterId);
        User recipient = userService.getUserById(recipientId);
        friendService.removeFriend(requester, recipient);
    }

    public void getAllFriendRequests(Long requesterId) {
        User requester = userService.getUserById(requesterId);
        friendService.getFriends(requester);
    }

}
