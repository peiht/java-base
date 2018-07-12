package design_pattern.factory;

/**
 * @author peiht
 * 工厂模式适合的大量的产品需要创建的时候，并且有共同的接口，可以使用工厂模式进行创建
 * 一般来说使用静态工厂，因为不需要实例化工厂类
 */
public class SendFactory {

    //普通工厂方法
    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else {
            System.out.println("请输入正确类型");
            return  null;
        }
    }

    //多个工厂方法的模式
    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }

    //静态工厂方法模式
    /*public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }*/
}
