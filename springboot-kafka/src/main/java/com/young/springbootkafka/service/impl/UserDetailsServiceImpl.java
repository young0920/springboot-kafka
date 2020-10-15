package com.young.springbootkafka.service.impl;

import com.young.springbootkafka.mapper.UsersMapper;
import com.young.springbootkafka.pojo.JwtUser;
import com.young.springbootkafka.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersMapper usersMapper;
	
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	
        Users user = usersMapper.findByUsername(s);
        
        return new JwtUser(user);
    }

}
