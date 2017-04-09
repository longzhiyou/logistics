package lzy.module.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 这个接口负责从安全上下文中获取系统的用户信息。
 * User: longzhiyou
 * Date: 2017/1/12
 * Time: 11:05
 */
public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public String getCurrentAuditor() {

        String userName ="admin";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return userName;
        }
        //获取登陆用户的用户名
        userName =  ((UserDetails) authentication.getPrincipal()).getUsername();
        return userName;
    }
}
