package day30;

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email service sending message: " + message);
    }
}

class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sms service sending message: " + message);
    }
}

class MessageSender {
    private final MessageService messageService;

    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendMessage(String message) {
        messageService.sendMessage(message);
    }
}

public class DIPDemo {
    public static void main(String[] args) {
        MessageSender emailMessageSender = new MessageSender(new EmailService());
        emailMessageSender.sendMessage("Hello World");

        MessageSender smsMessageSender = new MessageSender(new SmsService());
        smsMessageSender.sendMessage("Hello World");
    }
}
