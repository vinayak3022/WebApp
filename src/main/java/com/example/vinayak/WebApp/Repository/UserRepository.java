package com.example.vinayak.WebApp.Repository;

import com.example.vinayak.WebApp.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    public List<UserEntity> findAll();

    public UserEntity findByIdAndDeleted(Integer id, Integer deleted);

    public List<UserEntity> findByDeleted(Integer deleted);

    public List<UserEntity> findByNameAndDeleted(String name, Integer deleted);

    public List<UserEntity> findByEmailAndDeleted(String email, Integer deleted);

    public void deleteById(Integer id);
}
