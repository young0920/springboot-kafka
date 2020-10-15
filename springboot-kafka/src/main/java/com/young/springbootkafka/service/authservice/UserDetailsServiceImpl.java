package com.young.springbootkafka.service.authservice;

import com.young.springbootkafka.mapper.UsersMapper;
import com.young.springbootkafka.pojo.Users;
import com.young.springbootkafka.pojo.auth.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource
	private UsersMapper usersMapper;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        Users user = usersMapper.findByUsername(username);

        if(user == null){
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }

        return new JwtUser(user);
    }

}
