public class SendMessage {
    private final UserService userService;
    private final MessageService messageService;
    private final NotificationService notificationService;

    public SendMessage(UserService userService, MessageService messageService, NotificationService notificationService) {
        this.userService = userService;
        this.messageService = messageService;
        this.notificationService = notificationService;
    }

    public void sendMessage(String message, Long senderId, Long receiverId) {
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        messageService.sendMessage(sender, receiver, message);
        if(messageService.checkMessage(sender, receiver, message)){
            notificationService.notifyUser(receiver, message);
        }
    }
}
