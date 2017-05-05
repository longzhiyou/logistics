package lzy.module.security;


import lzy.common.exception.UnauthorizedException;
import lzy.module.auth.domain.UserEntity;
import lzy.module.auth.domain.UserInfo;
import lzy.module.auth.service.AuthService;
import lzy.utils.LicenseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * User: longzhiyou
 * Date: 2017/3/17
 * Time: 12:26
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private AuthService authService;



    @Override
//    @ExceptionHandler({UnauthorizedException.class})
    public UserDetails loadUserByUsername(String username) {

        UserEntity userEntity = authService.findUser(username);
        if (null==userEntity) {
            return null;
//            throw new UnauthorizedException(String.format("没有发现用户 '%s'.", username));
        }

        //验证序列号
        if (!LicenseGenerator.matches(userEntity.getLicense())){
            return null;
        }

        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setPassword(userEntity.getPassword());
        user.setEnabled(userEntity.getEnabled());

//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("bestskip"));
//
//        user.setAuthorities(authorities);
        return user;

    }
}
