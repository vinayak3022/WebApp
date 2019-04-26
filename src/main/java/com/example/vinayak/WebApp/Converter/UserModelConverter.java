package com.example.vinayak.WebApp.Converter;

import com.example.vinayak.WebApp.Entity.UserEntity;
import com.example.vinayak.WebApp.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserModelConverter implements Converter<UserEntity, UserModel> {
    @Override
    public UserEntity convertModelToEntity(UserModel model) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(model.getName());
        userEntity.setEmail(model.getEmail());
        userEntity.setPhone(model.getPhone());
        userEntity.setId(model.getId());
        return userEntity;
    }

    @Override
    public UserModel convertEntityToModel(UserEntity entity) {
        UserModel userModel = new UserModel();
        userModel.setId(entity.getId());
        userModel.setName(entity.getName());
        userModel.setEmail(entity.getEmail());
        userModel.setPhone(entity.getPhone());

        return userModel;
    }

    @Override
    public Collection<UserEntity> convertModelToEntity(Collection<UserModel> modelList) {
        List<UserEntity> userEntityList = new ArrayList<>();
        for (UserModel modelDto : modelList) {
            userEntityList.add(convertModelToEntity(modelDto));
        }
        return userEntityList;
    }

    @Override
    public Collection<UserModel> convertEntityToModel(Collection<UserEntity> entityList) {
        List<UserModel> userModelList = new ArrayList<>();
        for (UserEntity userEntity : entityList) {
            userModelList.add(convertEntityToModel(userEntity));
        }
        return userModelList;
    }
}
