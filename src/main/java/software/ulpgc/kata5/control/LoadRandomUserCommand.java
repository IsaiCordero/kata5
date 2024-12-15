package software.ulpgc.kata5.control;

import software.ulpgc.kata5.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadRandomUserCommand implements Command {
    private final int count;
    private final List<User> users = new ArrayList<>();

    public LoadRandomUserCommand(int count) {
        this.count = count;
    }

    @Override
    public void execute() {
        users.clear();
        RandomUserMeProvider provider = new RandomUserMeProvider();
        for (int i = 0; i < count; i++) {
            try {
                users.add(provider.providerNew());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
