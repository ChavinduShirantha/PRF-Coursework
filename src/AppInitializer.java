import java.util.Scanner;

/**
 * @author : Chavindu
 * created : 11/28/2023-2:39 PM
 **/

public class AppInitializer {
    public static void main(String[] args) {
        dashboardMenu();
    }

    public static void dashboardMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM \t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------\n");
        System.out.print("[1] Add New Student");
        System.out.println("\t\t\t\t\t[2] Add New Student With Marks");
        System.out.print("[3] Add Marks");
        System.out.println("\t\t\t\t\t\t[4] Update Student Details");
        System.out.print("[5] Update Marks");
        System.out.println("\t\t\t\t\t[6] Delete Student");
        System.out.print("[7] Print Student Details");
        System.out.println("\t\t\t\t[8] Print Student Ranks");
        System.out.print("[9] Best in Programming Fundamentals");
        System.out.println("\t\t\t[10] Best in Database Management Systems\n");
        System.out.print("Enter an option to continue > ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                addNewStudent();
                break;
            default:
                clearConsole();
                dashboardMenu();
                break;
        }
    }

    public static void addNewStudent() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

}
