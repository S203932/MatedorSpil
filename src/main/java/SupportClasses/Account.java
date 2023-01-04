package SupportClasses;
// Class is written by Patrick Machalet s203932
public class Account {
    private int pengebeholdning;

    public Account() {
        initializeAccount();

    }

    public Boolean initializeAccount() {
        this.pengebeholdning = 1000;
        return true;
    }

    public Boolean setAccount(int pengebeholdning) {
        this.pengebeholdning = pengebeholdning;
        return true;
    }


    public void subtractionAccount(int subtractValue) {
        this.pengebeholdning = pengebeholdning - subtractValue;
        if(this.pengebeholdning<0) {
            this.pengebeholdning = 0;
        }

    }

    public void additionKonto(int additionValue) {
        this.pengebeholdning = pengebeholdning + additionValue;
        if(this.pengebeholdning<0) {
            this.pengebeholdning = 0;
        }

    }

    public void transactionAccount(int transactionValue) {
        this.pengebeholdning = pengebeholdning + transactionValue;
        if(this.pengebeholdning<0) {
            this.pengebeholdning = 0;
        }
    }

    public int getPengebeholdning() {
        return pengebeholdning;
    }

    public String toString() {
        String value = "pengeBeholdning: "+pengebeholdning;
        return value;
    }

}
