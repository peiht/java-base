package design_pattern.factory;

public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("mail sender");
    }
}
