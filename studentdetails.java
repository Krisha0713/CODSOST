import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid! Enter marks between 0 and 100: ");
                marks[i] = sc.nextInt();
            }

            totalMarks += marks[i];
        }

        
        double average = (double) totalMarks / numSubjects;

        
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        
        System.out.println("\n📊 Result:");
        System.out.println("Total Marks = " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage = %.2f%%\n", average);
        System.out.println("Grade = " + grade);

        sc.close();
    }
}
