class RailwayBooking {

    int availableSeats;

    RailwayBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    synchronized void bookSeat(int seats) {

        if (seats <= availableSeats) {

            System.out.println(
                Thread.currentThread().getName()
                + " booked " + seats
                + " seat(s) successfully"
            );

            availableSeats = availableSeats - seats;

        } else {

            System.out.println(
                Thread.currentThread().getName()
                + " booking failed. Not enough seats"
            );
        }
    }
}


class User1 extends Thread {

    RailwayBooking booking;

    User1(RailwayBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookSeat(1);
    }
}


class User2 extends Thread {

    RailwayBooking booking;

    User2(RailwayBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookSeat(2);
    }
}


public class TicketBooking {

    public static void main(String[] args) {

        RailwayBooking booking = new RailwayBooking(2);

        User1 user1 = new User1(booking);
        User2 user2 = new User2(booking);

        user1.setName("User1");
        user2.setName("User2");

        user1.start();
        user2.start();
    }
}