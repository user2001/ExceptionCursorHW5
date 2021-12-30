
import java.util.Scanner;

public class ExceptionCursor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login.(It must contains minimum one digit, one letter and underline sign.Login's length should be less than 20 symbols)");
        String login = scanner.nextLine();
        System.out.println("Enter your password.(It must contains minimum one digit, one letter and underline sign.Login's length should be less than 20 symbols)");
        String password = scanner.nextLine();
        System.out.println("Confirm your password");
        String confirmPassword = scanner.nextLine();
        try {
            putLogin(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Wrong login, try again");
            e.getStackTrace();
        } catch (WrongPasswordException e2) {
            System.out.println("Wrong password, try again");
            e2.getStackTrace();

        }
    }

    public static boolean putLogin(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String patternPassword = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[_])(?=\\S+$).{0,20}";
        if ((login.matches(patternPassword)) && (password.matches(patternPassword) && confirmPassword.equals(password))) {
            return true;
        } else if (!login.matches(patternPassword)) {
            throw new WrongLoginException();
        } else if (!password.matches(patternPassword) ) {
            throw new WrongPasswordException();
        } else if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }return false;
    }
}
