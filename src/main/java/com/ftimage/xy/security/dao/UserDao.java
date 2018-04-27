package com.ftimage.xy.security.dao;

import com.ftimage.xy.security.entity.Member;

import java.util.Set;

public interface UserDao {

    Member findByName(String name);

    Set<String> findAllRoleByMid(Integer mid);

    Set<String> findAllActionByMid(Integer mid);

}
