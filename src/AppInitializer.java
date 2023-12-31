import java.util.Scanner;

/**
 * @author : Chavindu
 * created : 11/28/2023-2:39 PM
 **/

public class AppInitializer {
    public static void main(String[] args) {
        String[][] student = new String[100][2];
        int[][] studentMarks = new int[100][2];
        int[] total = new int[100];
        double[] average = new double[100];

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
                    addNewStudentWithMarks(student, studentMarks, i);
                    break;
                case 3:
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                    break;
                case 4:
                    clearConsole();
                    updateStudentDetails(student);
                    break;
                case 5:
                    clearConsole();
                    updateStudentMarks(student, studentMarks);
                    break;
                case 6:
                    clearConsole();
                    deleteStudent(student, studentMarks);
                    break;
                case 7:
                    clearConsole();
                    printStudentDetails(student, studentMarks, total, average);
                    break;
                case 8:
                    clearConsole();
                    printStudentRanks(student, studentMarks, total, average);
                    break;
                case 9:
                    clearConsole();
                    printBestInPrf(student, studentMarks, total);
                    break;
                case 10:
                    clearConsole();
                    printBestInDbms(student, studentMarks, total);
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

    public static void addNewStudentWithMarks(String[][] student, int[][] marks, int i) {
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
        marks[i][0] = scanner.nextInt();
        while (marks[i][0] < 0 || marks[i][0] > 100) {
            System.out.print("Invalid marks. please enter correct marks.\n");
            System.out.println();
            System.out.print("Programming Fundamentals marks    :");
            marks[i][0] = scanner.nextInt();
        }

        System.out.print("Databases Management Systems marks :");
        marks[i][1] = scanner.nextInt();
        while (marks[i][1] < 0 || marks[i][1] > 100) {
            System.out.print("Invalid marks. please enter correct marks.\n");
            System.out.println();
            System.out.print("Databases Management Systems marks :");
            marks[i][1] = scanner.nextInt();
        }

        i++;

        System.out.println("\nStudent has been added successfully. Do you want to add a new student (Y/n): ");
        String operate = scanner.next();
        if (operate.equals("n")) {
            clearConsole();
        } else if (operate.equals("Y")) {
            clearConsole();
            addNewStudentWithMarks(student, marks, i);
        } else if (operate.equals("y")) {
            clearConsole();
            addNewStudentWithMarks(student, marks, i);
        }

    }

    public static void addStudentMarks(String[][] student, int[][] studentMarks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tADD MARKS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);

        int index = 0;

        if (isDuplicate) {
            for (int j = 0; j < student.length; j++) {
                while (id.equals(student[j][0])) {
                    index = j;
                    break;
                }
            }

            if (studentMarks[index][0] > 0 && studentMarks[index][1] > 0) {

                System.out.println("Student Name  : " + student[index][1]);
                System.out.println("This student's marks have be already added.\nIf you want to update the marks, please use [4] Update Marks option.");
                System.out.println();
                System.out.print("Do you add marks for another student? (Y/n): ");
                char operate = scanner.next().charAt(0);
                if (operate == 'y') {
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                } else if (operate == 'Y') {
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                } else if (operate == 'n') {

                }
            } else if (studentMarks[index][0] == 0 && studentMarks[index][1] == 0) {

                System.out.println("Student Name  : " + student[index][1]);
                System.out.println();
                System.out.print("Programming Fundamentals marks    : ");
                studentMarks[index][0] = scanner.nextInt();
                while (studentMarks[index][0] < 0 || studentMarks[index][0] > 100) {
                    System.out.println("Invalid marks. please enter correct marks.\n");
                    System.out.print("Programming Fundamentals marks    : ");
                    studentMarks[index][0] = scanner.nextInt();
                }
                System.out.print("Databases Management System marks : ");
                studentMarks[index][1] = scanner.nextInt();
                while (studentMarks[index][1] < 0 || studentMarks[index][1] > 100) {
                    System.out.println("Invalid marks. please enter correct marks.\n");
                    System.out.print("Databases Management System marks : ");
                    studentMarks[index][1] = scanner.nextInt();
                }
                System.out.print("Do you add marks for another student? (Y/n): ");
                char operate = scanner.next().charAt(0);
                if (operate == 'y') {
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                } else if (operate == 'Y') {
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                } else if (operate == 'n') {
                    clearConsole();
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
                char operate = scanner.next().charAt(0);
                if (operate == 'y') {
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                } else if (operate == 'Y') {
                    clearConsole();
                    addStudentMarks(student, studentMarks);
                } else if (operate == 'n') {
                    clearConsole();
                }
            }
        }

    }

    public static void updateStudentDetails(String[][] student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);

        int index = 0;

        if (isDuplicate) {
            for (int j = 0; j < student.length; j++) {
                while (id.equals(student[j][0])) {
                    index = j;
                    break;
                }
            }

            System.out.println("Student Name  : " + student[index][1]);
            System.out.println();

            System.out.print("Enter the new Student Name  : ");
            student[index][1] = scanner.next();
            System.out.println();

            System.out.print("Student details has been updated successfully.\nDo you want to update another student details? (Y/n): ");

            char operate = scanner.next().charAt(0);

            if (operate == 'y') {
                clearConsole();
                updateStudentDetails(student);
            } else if (operate == 'Y') {
                clearConsole();
                updateStudentDetails(student);
            } else if (operate == 'n') {
                clearConsole();
            }
        } else {
            System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
            char operate = scanner.next().charAt(0);
            if (operate == 'y') {
                clearConsole();

            } else if (operate == 'Y') {
                clearConsole();

            } else if (operate == 'n') {
                clearConsole();
            }
        }
    }

    public static void updateStudentMarks(String[][] student, int[][] studentMarks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tUPDATE MARKS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);

        int index = 0;
        if (isDuplicate) {
            for (int j = 0; j < student.length; j++) {
                while (id.equals(student[j][0])) {
                    index = j;
                    break;
                }
            }

            if (studentMarks[index][0] == 0 && studentMarks[index][1] == 0) {

                System.out.println("Student Name  : " + student[index][1]);
                System.out.println("This student's marks yet to be added.\nDo you want to update the marks of another student? (Y/n) ");
                char operate = scanner.next().charAt(0);
                if (operate == 'y') {
                    clearConsole();
                    updateStudentMarks(student, studentMarks);
                } else if (operate == 'Y') {
                    clearConsole();
                    updateStudentMarks(student, studentMarks);
                } else if (operate == 'n') {

                }
            } else {

                System.out.println("Student Name  : " + student[index][1]);
                System.out.println();
                System.out.println("Programming Fundamentals Marks   : " + studentMarks[index][0]);
                System.out.println("Database Management System Marks : " + studentMarks[index][1]);
                System.out.println("\n");

                System.out.print("Enter New Programming Fundamentals marks    : ");
                studentMarks[index][0] = scanner.nextInt();
                while (studentMarks[index][0] < 0 || studentMarks[index][0] > 100) {
                    System.out.println("Invalid marks. please enter correct marks.\n");
                    System.out.print("Enter New Programming Fundamentals marks    : ");
                    studentMarks[index][0] = scanner.nextInt();
                }
                System.out.print("Enter Databases Management System marks : ");
                studentMarks[index][1] = scanner.nextInt();
                while (studentMarks[index][1] < 0 || studentMarks[index][1] > 100) {
                    System.out.println("Invalid marks. please enter correct marks.\n");
                    System.out.print("Enter New Databases Management System marks : ");
                    studentMarks[index][1] = scanner.nextInt();
                }
                System.out.print("Marks has been update successfully.\nDo you add marks for another student? (Y/n): ");
                char operate = scanner.next().charAt(0);
                if (operate == 'y') {
                    clearConsole();
                    updateStudentMarks(student, studentMarks);
                } else if (operate == 'Y') {
                    clearConsole();
                    updateStudentMarks(student, studentMarks);
                } else if (operate == 'n') {
                    clearConsole();
                }
            }
        } else {
            System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
            char operate = scanner.next().charAt(0);
            if (operate == 'y') {
                clearConsole();
                updateStudentMarks(student, studentMarks);
            } else if (operate == 'Y') {
                clearConsole();
                updateStudentMarks(student, studentMarks);
            } else if (operate == 'n') {
                clearConsole();
            }
        }
    }

    public static void deleteStudent(String[][] student, int[][] studentMarks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tDELETE STUDENT\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);

        int index = 0;
        if (isDuplicate) {
            for (int j = 0; j < student.length; j++) {
                while (id.equals(student[j][0])) {
                    index = j;
                    break;
                }
            }

            student[index][0] = null;
            student[index][1] = null;
            studentMarks[index][0] = 0;
            studentMarks[index][1] = 0;

            System.out.println("Student has been Deleted successfully.\nDo you want to deleted another student? (Y/n) ");
            char operate = scanner.next().charAt(0);
            if (operate == 'y') {
                clearConsole();
                deleteStudent(student, studentMarks);
            } else if (operate == 'Y') {
                clearConsole();
                deleteStudent(student, studentMarks);
            } else if (operate == 'n') {

            }
        } else {
            System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
            char operate = scanner.next().charAt(0);
            if (operate == 'y') {
                clearConsole();
                deleteStudent(student, studentMarks);
            } else if (operate == 'Y') {
                clearConsole();
                deleteStudent(student, studentMarks);
            } else if (operate == 'n') {
                clearConsole();
            }
        }
    }


    public static void printStudentDetails(String[][] student, int[][] studentMarks, int[] total, double[] average) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.print("Enter Student ID    : ");
        String id = scanner.next();
        boolean isDuplicate = checkDuplicate(student, id);

        int index = 0;

        if (isDuplicate) {
            for (int j = 0; j < student.length; j++) {
                while (id.equals(student[j][0])) {
                    index = j;
                    break;
                }
            }

            System.out.println("Student Name  : " + student[index][1]);

            if (studentMarks[index][0] == 0 && studentMarks[index][1] == 0) {
                System.out.println("This student's marks yet to be added.\nDo you want to update the marks of another student? (Y/n) ");
                char operate = scanner.next().charAt(0);
                if (operate == 'y') {
                    clearConsole();
                    printStudentDetails(student, studentMarks, total, average);
                } else if (operate == 'Y') {
                    clearConsole();
                    printStudentDetails(student, studentMarks, total, average);
                } else if (operate == 'n') {

                }
            } else {
                int tot = 0;
                for (int i = 0; i < total.length; i++) {
                    total[i] = studentMarks[i][0] + studentMarks[i][1];
                    average[i] = total[i] / 2.0;
                }
                tot = total[index];

                System.out.println("+----------------------------------+---------------------------+");
                System.out.println("| Programming Fundamentals Marks   |\t\t\t    " + studentMarks[index][0] + " |");
                System.out.println("| Database Management System Marks |\t\t\t    " + studentMarks[index][1] + " |");
                System.out.println("| Total Marks  \t\t\t   |\t\t\t   " + total[index] + " |");
                System.out.println("| avg. Marks  \t\t\t   |\t\t\t  " + average[index] + " |");
                for (int i = 0; i < student.length; i++) {
                    for (int j = total.length - 1; j > 0; j--) {
                        if (total[j - 1] < total[j]) {
                            int tempTot = total[j - 1];
                            total[j - 1] = total[j];
                            total[j] = tempTot;

                            double tempAvg = average[j - 1];
                            average[j - 1] = average[j];
                            average[j] = tempAvg;

                            String tempId = student[j - 1][0];
                            student[j - 1][0] = student[j][0];
                            student[j][0] = tempId;

                            String tempName = student[j - 1][1];
                            student[j - 1][1] = student[j][1];
                            student[j][1] = tempName;

                            int tempPrf = studentMarks[j - 1][0];
                            studentMarks[j - 1][0] = studentMarks[j][0];
                            studentMarks[j][0] = tempPrf;

                            int tempDbms = studentMarks[j - 1][1];
                            studentMarks[j - 1][1] = studentMarks[j][1];
                            studentMarks[j][1] = tempDbms;

                        }
                    }
                }
                int rank = 0;
                for (int i = 0; i < total.length; i++) {
                    if (tot == total[i]) {
                        rank = i;
                        break;
                    }
                }
                if (rank == 0) {
                    System.out.println("| Rank  \t\t\t   |\t\t       " + (rank + 1) + "(First)" + "|");
                    System.out.println("+----------------------------------+---------------------------+");
                } else if (rank == 1) {
                    System.out.println("| Rank  \t\t\t   |\t\t      " + (rank + 1) + "(Second)" + "|");
                    System.out.println("+----------------------------------+---------------------------+");
                } else if (rank == 2) {
                    System.out.println("| Rank  \t\t\t   |\t\t       " + (rank + 1) + "(Third)" + "|");
                    System.out.println("+----------------------------------+---------------------------+");
                } else if (rank == 99) {
                    System.out.println("| Rank  \t\t\t   |\t\t        " + (rank + 1) + "(Last)" + "|");
                    System.out.println("+----------------------------------+---------------------------+");
                } else {

                    System.out.println("| Rank  \t\t\t   |\t\t\t     " + (rank + 1) + " |");
                    System.out.println("+----------------------------------+---------------------------+");
                    System.out.println();
                }

            }


            System.out.println("\nDo you want to search another student details? (Y/n) ");
            char operate = scanner.next().charAt(0);
            if (operate == 'y') {
                clearConsole();
                printStudentDetails(student, studentMarks, total, average);
            } else if (operate == 'Y') {
                clearConsole();
                printStudentDetails(student, studentMarks, total, average);
            } else if (operate == 'n') {

            }
        } else {
            System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
            char operate = scanner.next().charAt(0);
            if (operate == 'y') {
                clearConsole();
                printStudentDetails(student, studentMarks, total, average);
            } else if (operate == 'Y') {
                clearConsole();
                printStudentDetails(student, studentMarks, total, average);
            } else if (operate == 'n') {
                clearConsole();
            }
        }
    }

    public static void printStudentRanks(String[][] student, int[][] studentMarks, int[] total, double[] average) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tPRINT STUDENTS' RANKS\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");


        for (int i = 0; i < total.length; i++) {
            total[i] = studentMarks[i][0] + studentMarks[i][1];
            average[i] = total[i] / 2.0;
        }
        for (int i = 0; i < student.length; i++) {
            for (int j = total.length - 1; j > 0; j--) {
                if (total[j - 1] < total[j]) {
                    int tempTot = total[j - 1];
                    total[j - 1] = total[j];
                    total[j] = tempTot;

                    double tempAvg = average[j - 1];
                    average[j - 1] = average[j];
                    average[j] = tempAvg;

                    String tempId = student[j - 1][0];
                    student[j - 1][0] = student[j][0];
                    student[j][0] = tempId;

                    String tempName = student[j - 1][1];
                    student[j - 1][1] = student[j][1];
                    student[j][1] = tempName;

                    int tempPrf = studentMarks[j - 1][0];
                    studentMarks[j - 1][0] = studentMarks[j][0];
                    studentMarks[j][0] = tempPrf;

                    int tempDbms = studentMarks[j - 1][1];
                    studentMarks[j - 1][1] = studentMarks[j][1];
                    studentMarks[j][1] = tempDbms;
                }
            }
        }
        int[] rank = new int[100];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = i;
        }
        int k = 0, j = 1;
        for (int i = 0; i < total.length; i++) {
            for (j = k + 1; j < total.length; j++) {
                if (total[i] == total[j]) {
                    rank[j] = i;
                    k++;
                }
            }
        }


        System.out.println("+-------+-----+----------------------------------------------------------+-----------+----------+");
        System.out.println("|Rank   |ID   |Name                                                      |Total Marks|Avg. Marks|");
        System.out.println("+-------+-----+----------------------------------------------------------+-----------+----------+");
        for (int i = 0; i < student.length; i++) {
            if (total[i] != 0) {
                System.out.println("|" + (rank[i] + 1) + "\t|" + student[i][0] + " |" + student[i][1] + "\t\t\t\t\t\t\t |\t " + total[i] + " |\t    " + average[i] + "|");
            }
        }
        System.out.println("+-------+-----+----------------------------------------------------------+-----------+----------+");
        System.out.print("Do you want to go back main menu? (Y/n) ");
        char operate = scanner.next().charAt(0);
        if (operate == 'y') {
            clearConsole();

        } else if (operate == 'Y') {
            clearConsole();

        } else if (operate == 'n') {
            clearConsole();
            printStudentRanks(student, studentMarks, total, average);
        }

    }

    public static void printBestInPrf(String[][] student, int[][] studentMarks, int[] total) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        for (int j = 0; j < studentMarks.length; j++) {
            for (int i = studentMarks.length - 1; 0 < i; i--) {
                if (studentMarks[i - 1][0] < studentMarks[i][0]) {
                    int tempPrf = studentMarks[i - 1][0];
                    studentMarks[i - 1][0] = studentMarks[i][0];
                    studentMarks[i][0] = tempPrf;

                    int tempDbms = studentMarks[i - 1][1];
                    studentMarks[i - 1][1] = studentMarks[i][1];
                    studentMarks[i][1] = tempDbms;

                    String tempId = student[i - 1][0];
                    student[i - 1][0] = student[i][0];
                    student[i][0] = tempId;

                    String tempName = student[i - 1][1];
                    student[i - 1][1] = student[i][1];
                    student[i][1] = tempName;

                    int tempTot = total[i - 1];
                    total[i - 1] = total[i];
                    total[i] = tempTot;
                }
            }
        }
        System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
        System.out.println("|ID     |Name                                                            |PF Marks   |DBMS Marks|");
        System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
        for (int j = 0; j < student.length; j++) {
            if (total[j] != 0) {
                System.out.println("|" + student[j][0] + "   |" + student[j][1] + "\t\t\t\t\t\t\t\t |" + studentMarks[j][0] + "         |" + studentMarks[j][1] + "        |");
            }
        }
        System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");

        System.out.print("Do you want to go back main menu? (Y/n) ");
        char operate = scanner.next().charAt(0);
        if (operate == 'y') {
            clearConsole();

        } else if (operate == 'Y') {
            clearConsole();

        } else if (operate == 'n') {
            clearConsole();
            printBestInPrf(student, studentMarks, total);
        }
    }

    public static void printBestInDbms(String[][] student, int[][] studentMarks, int[] total) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------\n");

        for (int j = 0; j < studentMarks.length; j++) {
            for (int i = studentMarks.length - 1; 0 < i; i--) {
                if (studentMarks[i - 1][1] < studentMarks[i][1]) {
                    int tempPrf = studentMarks[i - 1][0];
                    studentMarks[i - 1][0] = studentMarks[i][0];
                    studentMarks[i][0] = tempPrf;

                    int tempDbms = studentMarks[i - 1][1];
                    studentMarks[i - 1][1] = studentMarks[i][1];
                    studentMarks[i][1] = tempDbms;

                    String tempId = student[i - 1][0];
                    student[i - 1][0] = student[i][0];
                    student[i][0] = tempId;

                    String tempName = student[i - 1][1];
                    student[i - 1][1] = student[i][1];
                    student[i][1] = tempName;

                    int tempTot = total[i - 1];
                    total[i - 1] = total[i];
                    total[i] = tempTot;
                }
            }
        }
        System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
        System.out.println("|ID     |Name                                                            |DBMS Marks |PF Marks  |");
        System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");
        for (int j = 0; j < student.length; j++) {
            if (total[j] != 0) {
                System.out.println("|" + student[j][0] + "   |" + student[j][1] + "\t\t\t\t\t\t\t\t |" + studentMarks[j][1] + "         |" + studentMarks[j][0] + "        |");
            }
        }
        System.out.println("+-------+----------------------------------------------------------------+-----------+----------+");

        System.out.print("Do you want to go back main menu? (Y/n) ");
        char operate = scanner.next().charAt(0);
        if (operate == 'y') {
            clearConsole();

        } else if (operate == 'Y') {
            clearConsole();

        } else if (operate == 'n') {
            clearConsole();
            printBestInDbms(student, studentMarks, total);
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
