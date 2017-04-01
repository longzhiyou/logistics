package lzy.module.auth.service;

import lzy.common.exception.UnauthorizedException;
import lzy.module.auth.domain.UserEntity;
import lzy.module.auth.domain.UserInfo;
import lzy.module.auth.repository.UserRepository;
import lzy.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统认证服务
 * User: longzhiyou
 * Date: 2016/11/21
 * Time: 10:18
 */
@Service
public class AuthService {


    @Autowired
    private UserRepository userRepository;


  public UserInfo addUser(UserEntity user){

      UserEntity entity = userRepository.findByUsername(user.getUsername());
      if (null!=entity) {
          throw new UnauthorizedException("用户名已存在");

        }

      UserEntity userEntity = new UserEntity();
      userEntity.setEnabled(true);
      userEntity.setUsername(user.getUsername());
      userEntity.setPassword(StringUtil.sha256Encrypt(user.getPassword()));
      UserEntity save = userRepository.save(userEntity);

      UserInfo info = new UserInfo();
      info.setEnabled(save.getEnabled());
      info.setUsername(save.getUsername());
      info.setId(save.getId());
      return info;


    }


}
