package com.nuc.mapper;

import com.nuc.model.User;

import java.util.List;

/**
 * Created by Jiayiwu on 17/2/16.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface UserMapper {

    public int insertUser(User user);

    public int updateUser(User user);

    public int resetPass(int userID, String password);

    public User getUserById (int  id);

    public User getUserByUsername(String userName);

    public int removeUser(int userID);

    public List<User> getUserByMovieId(int movieId);
}
