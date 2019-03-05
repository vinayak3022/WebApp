package com.example.vinayak.WebApp.Service;

import com.example.vinayak.WebApp.Converter.UserModelConverter;
import com.example.vinayak.WebApp.Entity.UserEntity;
import com.example.vinayak.WebApp.Model.UserModel;
import com.example.vinayak.WebApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserModelConverter userModelConverter;

    @Override
    public UserModel createOrUpdate(UserModel userModel) {

        UserModel userModelResult = new UserModel();
        int userId = userModel.getId();

        if (userId == 0) {
            UserEntity userEntity = userModelConverter.convertModelToEntity(userModel);
            userEntity.setDeleted(0);
            userEntity = userRepository.save(userEntity);

            userModelResult = userModelConverter.convertEntityToModel(userEntity);

        } else {

            UserEntity userEntityExisting = userRepository.findByIdAndDeleted(userId, 0);
            userEntityExisting.setName(userModel.getName());
            userEntityExisting.setEmail(userModel.getEmail());
            userEntityExisting.setPhone(userModel.getPhone());

            userEntityExisting = userRepository.save(userEntityExisting);

            userModelResult = userModelConverter.convertEntityToModel(userEntityExisting);
        }

        return userModelResult;
    }

    @Override
    public Collection<UserModel> findAll() {

        Collection<UserEntity> userEntities = userRepository.findAll();

         return userModelConverter.convertEntityToModel(userEntities);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel findById(Integer id) {

        UserModel userModel = null;
        UserEntity userEntity = userRepository.findByIdAndDeleted(id,0);

        if(userEntity != null){
            userModel = userModelConverter.convertEntityToModel(userEntity);
        }
        return userModel;
    }

    @Override
    public Collection<UserModel> list() {
        return null;
    }

    @Override
    public Collection<UserModel> list(Integer offset, Integer limit) {
        return null;
    }
}
