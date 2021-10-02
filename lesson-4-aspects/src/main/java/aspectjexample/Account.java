package aspectjexample;

public class Account {
    int balance = 20;

    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        extracted(amount);
        return true;
    }

    private void extracted(int amount) {
        balance = balance - amount;
    }

}
