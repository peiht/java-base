package design_pattern.builder;

import design_pattern.factory.MailSender;
import design_pattern.factory.Sender;
import design_pattern.factory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiht
 * 建造者模式
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }

    public static void main(String[] args){
        Builder builder = new Builder();
        builder.produceMailSender(10);
        System.out.println(builder.list);
    }
}
