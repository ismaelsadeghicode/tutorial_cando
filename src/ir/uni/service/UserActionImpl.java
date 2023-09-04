package ir.uni.service;

import ir.uni.App;
import ir.uni.model.User;

import java.util.Set;

public class UserActionImpl implements UserAction<User> {

    @Override
    public void create(User user) {
        App.users.add(user);
    }

    @Override
    public void delete(User user) {
        App.users.remove(user);
    }

    @Override
    public void update(User user) {
        User user1 = findByUsername(user.getUsername());
        delete(user1);
        App.users.add(user);
    }

    @Override
    public Set<User> read() {
        return App.users;
    }

    @Override
    public User findByUsername(String username) {
        User result = new User();
        for (User user : App.users) {
            if (user.getUsername().equals(username)) {
                result = user;
            }
        }
        return result;
    }
}
