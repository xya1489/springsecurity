package com.ftimage.xy.security.dao.impl;

import com.ftimage.xy.security.dao.UserDao;
import com.ftimage.xy.security.entity.Member;
import com.ftimage.xy.security.mapper.ActionMapper;
import com.ftimage.xy.security.mapper.MemberMapper;
import com.ftimage.xy.security.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ActionMapper actionMapper;

    @Override
    public Member findByName(String name) {
        return memberMapper.selectByName(name);
    }

    @Override
    public Set<String> findAllRoleByMid(Integer mid) {
        return roleMapper.selectByMid(mid);
    }

    @Override
    public Set<String> findAllActionByMid(Integer mid) {
        return actionMapper.selectByMid(mid);
    }
}
