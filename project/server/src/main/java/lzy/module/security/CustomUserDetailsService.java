package lzy.module.security;


import lzy.module.auth.domain.UserEntity;
import lzy.module.auth.domain.UserInfo;
import lzy.module.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: longzhiyou
 * Date: 2017/3/17
 * Time: 12:26
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        /**
//         *  从数据库获取用户信息,以后要增加缓存机制
//         * [2017-03-17 add by longzhiyou]
//         */
//
//
        UserEntity userEntity = userRepository.findByUsername(username);
        if (null==userEntity) {
            throw new UsernameNotFoundException(String.format("没有发现用户 '%s'.", username));
        }

        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setPassword(user.getPassword());
        user.setEnabled(true);
//        user.setEnabled(user.isEnabled());

//        user.setMemberId(2);
//        user.setPersonId(2);
//        user.setUsername("longzhiyou");
//        user.setPassword("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");


//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("bestskip"));
//
//        user.setAuthorities(authorities);
        return user;

    }
}
