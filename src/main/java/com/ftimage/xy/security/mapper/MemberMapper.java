package com.ftimage.xy.security.mapper;

import com.ftimage.xy.security.entity.Member;

public interface MemberMapper {

    Member selectByName(String name);

    Member selectById(Integer id);


}
