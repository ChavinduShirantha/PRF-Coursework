import java.util.Scanner;

/**
 * @author : Chavindu
 * created : 11/28/2023-2:39 PM
 **/

public class AppInitializer {
    public static void main(String[] args) {
        String[][] student = new String[100][2];
        int[][] studentMarks = new int[100][2];

        int i = 0;
        while (true) {
            clearConsole();
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
                    addNewStudent(student, i);
                    break;
                case 2:
                    clearConsole();
                    addNewStudentWithMarks(student,studentMarks, i);
                    break;
            }
        }
    }


    public static boolean checkDuplicate(String[][] student, String id) {
        for (int i = 0; i < student.length; i++) {
            if (id.equals(student[i][0])) {
                return true;
            }
        }
        return false;
    }

    public static void addNewStudent(String[][] student, int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);
        while (isDuplicate) {
            System.out.println("The Student ID already exists\n");
            System.out.print("Enter Student ID    : ");
            id = scanner.next();
            isDuplicate = checkDuplicate(student, id);
        }

        System.out.print("Enter Student Name  : ");
        String name = scanner.next();

        student[i][0] = id;
        student[i][1] = name;
        i++;
        System.out.println("\nStudent has been added successfully. Do you want to add a new student (Y/n): ");
        String operate = scanner.next();
        if (operate.equals("n")) {
            clearConsole();
        } else if (operate.equals("Y")) {
            clearConsole();
            addNewStudent(student, i);
        } else if (operate.equals("y")) {
            clearConsole();
            addNewStudent(student, i);
        }
    }

    private static void addNewStudentWithMarks(String[][] student,int[][]marks, int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);
        while (isDuplicate) {
            System.out.println("The Student ID already exists\n");
            System.out.print("Enter Student ID    : ");
            id = scanner.next();
            isDuplicate = checkDuplicate(student, id);
        }

        System.out.print("Enter Student Name  : ");
        String name = scanner.next();

        student[i][0] = id;
        student[i][1] = name;

        System.out.println();
        System.out.print("Programming Fundamentals marks    :");
        marks[i][0]=scanner.nextInt();
        while(marks[i][0]<0 || marks[i][0]>100){
            System.out.print("Invalid marks. please enter correct marks.\n");
            System.out.println();
            System.out.print("Programming Fundamentals marks    :");
            marks[i][0]=scanner.nextInt();
        }

        System.out.print("Databases Management Systems marks :");
        marks[i][1]=scanner.nextInt();
        while(marks[i][1]<0 || marks[i][1]>100){
            System.out.print("Invalid marks. please enter correct marks.\n");
            System.out.println();
            System.out.print("Databases Management Systems marks :");
            marks[i][1]=scanner.nextInt();
        }

        i++;

        System.out.println("\nStudent has been added successfully. Do you want to add a new student (Y/n): ");
        String operate = scanner.next();
        if (operate.equals("n")) {
            clearConsole();
        } else if (operate.equals("Y")) {
            clearConsole();
            addNewStudentWithMarks(student,marks, i);
        } else if (operate.equals("y")) {
            clearConsole();
            addNewStudentWithMarks(student,marks, i);
        }

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
