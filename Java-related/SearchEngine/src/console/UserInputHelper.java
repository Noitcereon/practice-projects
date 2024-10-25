package console;

import java.util.Scanner;

public class UserInputHelper implements IUserInputHelper {

    @Override
    public String askForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search query: ");
        return scanner.nextLine();
    }
}
