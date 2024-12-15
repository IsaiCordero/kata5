package software.ulpgc.kata5.control;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import software.ulpgc.kata5.control.pojo.RandomUserMeResponse;
import software.ulpgc.kata5.model.User;

import java.io.IOException;

public class RandomUserMeProvider implements UserProvider{
    private static final String URLRANDOMUSER = "https://randomuser.me/api/";

    @Override
    public User providerNew() throws IOException {
        String text = Jsoup.connect(URLRANDOMUSER).ignoreContentType(true).get().text();
        RandomUserMeResponse response = new Gson().fromJson(text, RandomUserMeResponse.class);
        return new RandomUserMeAdapter().adapt(response);
    }
}
