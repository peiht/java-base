package learning.proxy;

public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String id, String password) {
        System.out.println(".: 调用了adduser方法");

    }

    @Override
    public void delUser(String id) {
        System.out.println(".:调用了deluser方法");

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
