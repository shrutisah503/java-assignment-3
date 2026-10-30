public class BankTransaction extends Thread {

    int amount;

    BankTransaction(int amount) {
        this.amount = amount;
    }

    public void run() {

        if (amount >= 50000) {
            System.out.println(
                "High-value transaction processed first"
            );
        } else {
            System.out.println(
                "Low-value transaction processed later"
            );
        }
    }

    public static void main(String[] args) {

        BankTransaction transaction1 =
            new BankTransaction(5000);

        BankTransaction transaction2 =
            new BankTransaction(50000);

        transaction1.setPriority(Thread.MIN_PRIORITY);
        transaction2.setPriority(Thread.MAX_PRIORITY);

        transaction1.start();
        transaction2.start();
    }
}