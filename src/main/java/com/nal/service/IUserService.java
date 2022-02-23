package com.nal.service;

import com.nal.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IGeneralService<User>{
    Page<User> findAll(Pageable pageable);
}
