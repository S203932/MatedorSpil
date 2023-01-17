package SupportClasses;
public class Account {
    private int amount;

    public Account() {
        initializeAccount();

    }

    public Boolean initializeAccount() {
        this.amount = 1000;
        return true;
    }

    public Boolean setAccount(int amount) {
        this.amount = amount;
        return true;
    }


    public void subtractionAccount(int subtractValue) {
        this.amount = amount - subtractValue;
        if(this.amount <0) {
            this.amount = 0;
        }

    }

    public void additionAccount(int additionValue) {
        this.amount = amount + additionValue;
        if(this.amount <0) {
            this.amount = 0;
        }

    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        String value = "pengebeholdning: "+ amount;
        return value;
    }

}
