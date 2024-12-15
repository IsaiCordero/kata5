package software.ulpgc.kata5;

import software.ulpgc.kata5.control.LoadRandomUserCommand;
import software.ulpgc.kata5.model.User;

public class Main {
    public static void main(String[] args) {
        LoadRandomUserCommand command = new LoadRandomUserCommand(15);
        command.execute();
        for(User user : command.getUsers()) {
            System.out.println(user.getName() + " " + user.getEmail());
        }
    }
}
