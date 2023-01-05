package SupportClasses;
// Class is written by Patrick Machalet s203932

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

    public void additionKonto(int additionValue) {
        this.amount = amount + additionValue;
        if(this.amount <0) {
            this.amount = 0;
        }

    }

    public void transactionAccount(int transactionValue) {
        this.amount = amount + transactionValue;
        if(this.amount <0) {
            this.amount = 0;
        }
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        String value = "pengeBeholdning: "+ amount;
        return value;
    }

}
