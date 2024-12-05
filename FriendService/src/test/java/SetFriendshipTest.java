import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SetFriendshipTest {

    private UserService userService;
    private FriendService friendService;
    private SetFriendship setFriendship;

    Long requesterId = 1L;
    Long recipientId = 2L;
    User requester = new User(requesterId);
    User recipient = new User(recipientId);

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        friendService = mock(FriendService.class);
        setFriendship = new SetFriendship(userService, friendService);
    }

    @Test
    void testSendFriendRequest() {
        when(userService.getUserById(requesterId)).thenReturn(requester);
        when(userService.getUserById(recipientId)).thenReturn(recipient);
        setFriendship.sendFriendRequest(requesterId, recipientId);
        verify(friendService).addFriend(requester, recipient);
    }

    @Test
    void testRemoveFriendRequest() {
        when(userService.getUserById(requesterId)).thenReturn(requester);
        when(userService.getUserById(recipientId)).thenReturn(recipient);
        setFriendship.removeFriendRequest(requesterId, recipientId);
        verify(friendService).removeFriend(requester, recipient);
    }

    @Test
    void testGetAllFriendRequests() {
        when(userService.getUserById(requesterId)).thenReturn(requester);
        setFriendship.getAllFriendRequests(requesterId);
        verify(friendService).getFriends(requester);
    }

}