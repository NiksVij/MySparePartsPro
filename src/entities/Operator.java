package entities;

/**
 * Created by prajapas on 7/13/2017.
 */
public class Operator {
    String userName;
    private String password;
    private boolean blocked;

    public Operator(String userName, String password, boolean blocked) {
        this.userName = userName;
        this.password = password;
        this.blocked = blocked;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
