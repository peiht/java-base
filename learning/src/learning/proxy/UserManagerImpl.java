package learning.proxy;

public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String id, String password) {
        System.out.println(".: ������adduser����");

    }

    @Override
    public void delUser(String id) {
        System.out.println(".:������deluser����");

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
