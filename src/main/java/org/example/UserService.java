package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService instance;
    private Map<String, String> users = new HashMap<>();

    private UserService() {
        // Tạo một số tài khoản mẫu
        users.put("user@gmail.com", "123");
    }

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User checkLogin(String email, String password) {
        if(users.containsKey(email) && users.get(email).equals(password)) {
            // Giả sử tất cả người dùng đều có cùng tên "User" để đơn giản
            return new User(email, "User");
        }
        return null;
    }
}
