/**
 * @author : Chavindu
 * created : 11/28/2023-2:39 PM
 **/

public class AppInitializer {
    public static void main(String[] args) {
        dashboardMenu();
    }

    public static void dashboardMenu(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM \t\t\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------------------\n");
        System.out.print("[1] Add New Student");
        System.out.println("\t\t\t\t\t\t\t[2] Add New Student With Marks");
        System.out.print("[3] Add Marks");
        System.out.println("\t\t\t\t\t\t\t\t[4] Update Student Details");
        System.out.print("[5] Update Marks");
        System.out.println("\t\t\t\t\t\t\t[6] Delete Student");
        System.out.print("[7] Print Student Details");
        System.out.println("\t\t\t\t\t[8] Print Student Ranks");
        System.out.print("[9] Best in Programming Fundamentals");
        System.out.println("\t\t[10] Best in Database Management Systems\n");
        System.out.print("Enter an option to continue > ");
    }
}
