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
        UserEntity userEntity = new UserEntity().builder()
                .name(model.getName())
                .email(model.getEmail())
                .phone(model.getPhone())
                .build();
        userEntity.setId(model.getId());
        return userEntity;
    }

    @Override
    public UserModel convertEntityToModel(UserEntity entity) {
        UserModel userModel = UserModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();

        return userModel;
    }

    @Override
    public Collection<UserEntity> convertModelToEntity(Collection<UserModel> modelList) {
        List<UserEntity> vehicleEntityList = new ArrayList<>();
        for (UserModel modelDto : modelList) {
            vehicleEntityList.add(convertModelToEntity(modelDto));
        }
        return vehicleEntityList;
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
