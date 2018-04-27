package com.ftimage.xy.security.config;

import com.ftimage.xy.security.dao.UserDao;
import com.ftimage.xy.security.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Member member = userDao.findByName(username);
       if(member == null){
           throw new UsernameNotFoundException("用户名不存在");
       }
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<String> actions = userDao.findAllActionByMid(member.getMid());
        actions.iterator().forEachRemaining(action  ->{
            GrantedAuthority  grantedAuthority = new SimpleGrantedAuthority(action);
            authorities.add(grantedAuthority);
        });

         return new User(member.getName(), member.getPassword(), authorities);
    }
}
