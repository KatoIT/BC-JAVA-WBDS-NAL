package com.nal.service.role;

import com.nal.model.Role;
import com.nal.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}

