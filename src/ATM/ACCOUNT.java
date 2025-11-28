package ATM;

public class ACCOUNT {
    private String name;
    private String password;
    private String sex;
    private double balance;
    private String id;

    public ACCOUNT() {
    }

    public ACCOUNT(String name, String password, String sex, double balance, String id) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.balance = balance;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
