import java.util.Scanner;

public class MultipleChoiceTest {
    public static void main(String[] args) {
        Test_Grader();
    }
    
    public static void Test_Grader() {
        Scanner keyboard = new Scanner(System.in);

        char[] list_of_correct_answers = create_list_of_correct_answers();
        char[] user_answers = create_user_answers(keyboard);

        int number_of_questions = user_answers.length;
        
        for (int i = 0; i < number_of_questions; i++) {
            while (!answer_is_valid(user_answers[i])) {
                
                System.out.println("Invalid input. Please enter A, B, C, D, E, or X only.");
                System.out.print("Question " + (i + 1) + ": ");
                user_answers[i] = Character.toUpperCase(keyboard.next().charAt(0));
                if (!answer_is_valid(user_answers[i])) {
                    System.out.println("Invalid input. Please enter A, B, C, D, E, or X only.");
                }
            }
        }

        int total_answers_correct = total_answers_correct(list_of_correct_answers, user_answers);
        int total_answers_incorrect = total_answers_incorrect(list_of_correct_answers, user_answers);
        int total_answer_missed = total_answer_missed(list_of_correct_answers, user_answers);
        
        int[] correct_answers = correct_answers(list_of_correct_answers, user_answers);
        int[] incorrect_answers = incorrect_answers(list_of_correct_answers, user_answers);
        int[] answers_missed = answers_missed(list_of_correct_answers, user_answers);
        
        boolean test_passed = test_passed(total_answers_correct);

        display_results(total_answers_correct, total_answers_incorrect, total_answer_missed,
                       correct_answers, incorrect_answers, answers_missed, test_passed);
    }
    
    public static void display_results(int total_answers_correct, int total_answers_incorrect, int total_answer_missed,
                                      int[] correct_answers, int[] incorrect_answers,
                                      int[] answers_missed, boolean test_passed) {

        System.out.println("Total Correct: " + total_answers_correct);
        System.out.println("Total Incorrect: " + total_answers_incorrect);
        System.out.println("Total Missed: " + total_answer_missed);
        
        System.out.println("Questions Correct: ");
        for (int question : correct_answers) {
            System.out.print(question + " ");
        }
        System.out.println();
        
        System.out.println("Questions Incorrect: ");
        for (int question : incorrect_answers) {
            System.out.print(question + " ");
        }
        System.out.println();
        
        System.out.println("Questions Missed: ");
        for (int question : answers_missed) {
            System.out.print(question + " ");
        }
        System.out.println();
        
        // Display test result
        if (test_passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
    
    public static char[] create_list_of_correct_answers() {
        char[] list_of_correct_answers = {
            'B', 'D', 'E', 'A', 'C', 'A', 'B', 'E', 'C', 'D',
            'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'E', 'A',
            'E', 'B', 'C', 'A', 'D'
        };
        return list_of_correct_answers;
    }
    
    public static boolean answer_is_valid(char answer) {
        char lower_case_answer = answer;
        if (answer >= 'A' && answer <= 'Z') 
        {
            lower_case_answer = (char) (answer - 'A' + 'a');
        }
        return lower_case_answer == 'a' || lower_case_answer == 'b' ||
               lower_case_answer == 'c' || lower_case_answer == 'd' ||
               lower_case_answer == 'e' || lower_case_answer == 'x';
    }

    public static char[] create_user_answers(Scanner scanner) {
        char[] user_answers = new char[25];
        System.out.println("Enter student answers for each question (A, B, C, D, E, X):");
        for (int i = 0; i < user_answers.length; i++) {
            char answer;
            do {
                System.out.print("Question " + (i + 1) + ": ");
                String input = scanner.next();
                if (input.length() == 1) {
                    answer = input.charAt(0);
                    if (!answer_is_valid(answer)) {
                        System.out.println("Invalid input. Please enter A, B, C, D, E, or X only.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a single character: A, B, C, D, E, or X.");
                    answer = ' ';
                }
            } while (!answer_is_valid(answer));
            user_answers[i] = Character.toUpperCase(answer);
        }
        return user_answers;
    }
    
    public static boolean InputValidation(char[] user_answers) {
        for (char answer : user_answers) {
            if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D' && answer != 'X') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean test_passed(int total_answers_correct) {
        return total_answers_correct >= 20;
    }
    
    public static int total_answers_correct(char[] list_of_correct_answers, char[] user_answers) {
        int count = 0;
        for (int i = 0; i < list_of_correct_answers.length; i++) {
            if (list_of_correct_answers[i] == user_answers[i]) {
                count++;
            }
        }
        return count;
    }
    
    public static int total_answers_incorrect(char[] list_of_correct_answers, char[] user_answers) {
        int count = 0;
        for (int i = 0; i < list_of_correct_answers.length; i++) {
            if (user_answers[i] != 'X' && list_of_correct_answers[i] != user_answers[i]) {
                count++;
            }
        }
        return count;
    }
    
    public static int total_answer_missed(char[] list_of_correct_answers, char[] user_answers) {
        int count = 0;
        for (int i = 0; i < list_of_correct_answers.length; i++) {
            if (user_answers[i] == 'X') {
                count++;
            }
        }
        return count;
    }
    
    public static int[] correct_answers(char[] list_of_correct_answers, char[] user_answers) {
        int[] questions = new int[total_answers_correct(list_of_correct_answers, user_answers)];
        int index = 0;
        for (int i = 0; i < list_of_correct_answers.length; i++) {
            if (list_of_correct_answers[i] == user_answers[i]) {
                questions[index] = i + 1;
                index++;
            }
        }
        return questions;
    }
    
    public static int[] incorrect_answers(char[] list_of_correct_answers, char[] user_answers) {
        int[] questions = new int[total_answers_incorrect(list_of_correct_answers, user_answers)];
        int index = 0;
        for (int i = 0; i < list_of_correct_answers.length; i++) {
            if (user_answers[i] != 'X' && list_of_correct_answers[i] != user_answers[i]) {
                questions[index] = i + 1;
                index++;
            }
        }
        return questions;
    }
    
    public static int[] answers_missed(char[] list_of_correct_answers, char[] user_answers) {
        int[] questions = new int[total_answer_missed(list_of_correct_answers, user_answers)];
        int index = 0;
        for (int i = 0; i < list_of_correct_answers.length; i++) {
            if (user_answers[i] == 'X') {
                questions[index] = i + 1;
                index++;
            }
        }
        return questions;
    }
}
