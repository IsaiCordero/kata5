package software.ulpgc.kata5.control;

import software.ulpgc.kata5.control.pojo.RandomUserMe;
import software.ulpgc.kata5.control.pojo.RandomUserMeResponse;
import software.ulpgc.kata5.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class RandomUserMeAdapter implements UserAdapter<RandomUserMeResponse> {
    @Override
    public User adapt(RandomUserMeResponse randomUserMeResponse) {
        RandomUserMe userMe = randomUserMeResponse.getResults().getFirst();
        User user = adapt(userMe);
        user.setPhoto(downloadPhoto(userMe.getPicture().medium()));
        return user;
    }

    private byte[] downloadPhoto(String url) {
        try {
            URLConnection conn = new URI(url).toURL().openConnection();
            return conn.getInputStream().readAllBytes();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private User adapt(RandomUserMe userMe) {
        User user = new User(userMe.getName().first(),
                userMe.getName().last(),
                userMe.getEmail(),
                User.Gender.valueOf(firstUpperCase(userMe.getGender())));
        return user;
    }

    private String firstUpperCase(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
