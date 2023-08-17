import java.util.Scanner;

public class checkpassword 
{
    public static void main(String[] args) 
    {
        checkInput(); //CALLS FOR METHOD THAT STARTS THE CHECK_PASSWORD PROCESS
    }

    public static void checkInput() //METHOD THAT CONTAINS ALL THE VALIDATIONS INSIDE WHILE LOOP TO CHECK FOR ENTERED CHARACTERS
    {
        Scanner keyboard = new Scanner(System.in);
        boolean is_password_valid = false;

        while (!is_password_valid) // PROCESS THE WHILE LOOP UNTIL THE USER ENTERS THE VALID PASSWORD WHILE DISPLAYING WARNING ONE BY ONE
        {
            System.out.print("Enter a password: ");
            String password = keyboard.nextLine();
            String validation_message = validate_input(password);

            if (validation_message == "") 
            {
                is_password_valid = true;
            } else {
                System.out.println("Invalid password: " + validation_message);
            }
        }

        System.out.println("Password is valid!");
    }

    public static String validate_input(String password) //DISPLAYS THE SPECIFIED WARNING MESSAGES 
    {
        if (!checkLength(password)) 
        {
            return "Password should be at least 14 characters long.";
        }
        if (check_lower_case(password) < 2) 
        {
            return "At least 2 different lowercase characters are required.";
        }
        if (check_upper_case(password) < 2) 
        {
            return "At least 2 different uppercase characters are required.";
        }
        if (check_digit(password) < 2) 
        {
            return "At least 2 different digits are required.";
        }
        if (check_special_character(password) < 2) 
        {
            return "At least 2 different special characters are required.";
        }

        return "";
    }

    public static boolean checkLength(String password) //VALIDATION FOR LENGTH OF THE PASSWORD
    {
        return password.length() >= 14;
    }

    public static int check_lower_case(String password) // VALIDATION FOR LOWER CASE LETTERS
    {
        int count = 0;
        char lastChar = 0;

        for (int i = 0; i < password.length(); i++) 
        {
            char ch = password.charAt(i);
            if (ch >= 'a' && ch <= 'z' && ch != lastChar) 
            {
                count++;
                lastChar = ch;
            }
        }
        return count;
    }

    public static int check_upper_case(String password) // VALIDATION FOR UPPER CASE LETTERS
    {
        int count = 0;
        char lastChar = 0;

        for (int i = 0; i < password.length(); i++) 
        {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z' && ch != lastChar) 
            {
                count++;
                lastChar = ch;
            }
        }
        return count;
    }

    public static int check_digit(String password) // VALIDATION FOR DIGITS
    {
        int count = 0;
        char lastChar = 0;

        for (int i = 0; i < password.length(); i++) 
        {
            char ch = password.charAt(i);
            if (ch >= '0' && ch <= '9' && ch != lastChar) 
            {
                count++;
                lastChar = ch;
            }
        }
        return count;
    }

    public static int check_special_character(String password) // VALIDATION FOR SPECIAL CHARACTERS
    {
        int count = 0;
        char lastChar = 0;

        for (int i = 0; i < password.length(); i++) 
        {
            char ch = password.charAt(i);
            if (((ch >= 33 && ch <= 47) || (ch >= 58 && ch <= 64) || (ch >= 91 && ch <= 96) || (ch >= 123 && ch <= 126)) && ch != lastChar) 
            {
                count++;
                lastChar = ch;
            }
        }
        return count;
    }
}
