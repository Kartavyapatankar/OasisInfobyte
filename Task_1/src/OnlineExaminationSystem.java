import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public void updateProfile(String newPassword) {
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }
}

class MCQs {
    private String[] questions;
    private String[][] options;
    private char[] answers;

    public MCQs(String[] questions, String[][] options, char[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
    }

    public void displayQuestions() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        System.out.println("Timer started. You have 5 minutes for the exam.");
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5 * 60 * 1000; // 5 minutes

        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((char) ('A' + j) + ". " + options[i][j]);
            }

            char choice = '-';
            do {
                System.out.print("Enter your choice (A/B/C/D): ");
                choice = Character.toUpperCase(scanner.nextLine().charAt(0));
            } while (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D');

            if (choice == answers[i]) {
                score++;
            }

            if (System.currentTimeMillis() >= endTime) {
                System.out.println("Time's up! Automatic submission.");
                break;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.length);
        scanner.close();
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String username = "user";
        String password = "password";

    
        String[] questions = {"Q1. What is the capital of France?", "Q2. Who wrote Hamlet?", "Q3. What is the chemical symbol for gold?"};
        String[][] options = {{"A. Paris", "B. London", "C. Rome", "D. Madrid"}, {"A. Shakespeare", "B. Dickens", "C. Hemingway", "D. Austen"}, {"A. Au", "B. Ag", "C. Hg", "D. Fe"}};
        char[] answers = {'A', 'A', 'A'};

       
        User user = new User(username, password);

        
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();
        if (!user.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Invalid username or password!");
            return;
        }

        
        System.out.print("Do you want to update your password? (yes/no): ");
        String updatePassword = scanner.nextLine();
        if (updatePassword.equalsIgnoreCase("yes")) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.updateProfile(newPassword);
        } 	

         	
        MCQs mcqs = new MCQs(questions, options, answers);
        mcqs.displayQuestions();

        
        System.out.println("Session closed. Logging out...");
        scanner.close();
    }
}
