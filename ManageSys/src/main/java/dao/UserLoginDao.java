package dao;

import javaBean.User;

public interface UserLoginDao {
    public User loadById(String id, String identity);
}
