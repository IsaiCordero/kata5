package software.ulpgc.kata5.control;

import software.ulpgc.kata5.model.User;

import java.io.IOException;

public interface UserProvider {
    User providerNew() throws IOException;
}
