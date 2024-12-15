package software.ulpgc.kata5.control;

import software.ulpgc.kata5.model.User;

public interface UserAdapter<T> {
    User adapt(T t);
}
