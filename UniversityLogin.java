import java.util.Scanner;

public class UniversityLogin {

    void login(String username) {

        // This will cause NullPointerException if username is null
        System.out.println("Username length: " + username.length());

        System.out.println("Login successful");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Convert "null" input into actual null
        if (username.equalsIgnoreCase("null")) {
            username = null;
        }

        UniversityLogin user = new UniversityLogin();

        try {
            user.login(username);
        }
        catch (NullPointerException e) {
            System.out.println("Exception: Username cannot be null");
        }

        sc.close();
    }
}