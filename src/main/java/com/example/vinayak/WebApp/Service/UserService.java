package com.example.vinayak.WebApp.Service;

import com.example.vinayak.WebApp.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService extends BaseService<UserModel> {

    UserModel createOrUpdate(UserModel userModel);

    Collection<UserModel> findAll();

    void deleteUser(Integer id);
}
