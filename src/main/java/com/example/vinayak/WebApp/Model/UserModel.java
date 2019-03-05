package com.example.vinayak.WebApp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private int id;

    private String name;

    private String email;

    private String phone;
}
