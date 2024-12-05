import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SendMessageTest {

    private UserService userService;
    private MessageService messageService;
    private NotificationService notificationService;
    private SendMessage sendMessage;

    Long senderId = 1L;
    Long receiverId = 2L;
    String message = "Hello World";
    User sender = new User(senderId);
    User receiver = new User(receiverId);

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        messageService = mock(MessageService.class);
        notificationService = mock(NotificationService.class);
        sendMessage = new SendMessage(userService, messageService, notificationService);
    }

    @Test
    void sendMessageTrue() {
        when(userService.getUserById(receiverId)).thenReturn(receiver);
        when(userService.getUserById(senderId)).thenReturn(sender);
        when(messageService.checkMessage(sender, receiver, message)).thenReturn(true);
        sendMessage.sendMessage(message, senderId, receiverId);
        verify(messageService, times(1)).sendMessage(sender, receiver, message);
        verify(notificationService).notifyUser(receiver, message);
    }

    @Test
    void sendMessageFalse() {
        when(userService.getUserById(receiverId)).thenReturn(receiver);
        when(userService.getUserById(senderId)).thenReturn(sender);
        when(messageService.checkMessage(sender, receiver, message)).thenReturn(false);
        sendMessage.sendMessage(message, senderId, receiverId);
        verify(messageService, times(1)).sendMessage(sender, receiver, message);
        verify(notificationService, never()).notifyUser(any(),any());
    }
}