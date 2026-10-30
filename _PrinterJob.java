class PrinterJob implements Runnable {

    int jobNumber;
    String studentName;

    PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    public void run() {

        System.out.println(
            "Printing job " + jobNumber +
            " by " + studentName
        );

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Printing interrupted");
        }
    }

    public static void main(String[] args) {

        PrinterJob job1 = new PrinterJob(1, "Student A");
        PrinterJob job2 = new PrinterJob(2, "Student B");
        PrinterJob job3 = new PrinterJob(3, "Student C");

        Thread t1 = new Thread(job1);
        Thread t2 = new Thread(job2);
        Thread t3 = new Thread(job3);

        t1.start();
        t2.start();
        t3.start();
    }
}