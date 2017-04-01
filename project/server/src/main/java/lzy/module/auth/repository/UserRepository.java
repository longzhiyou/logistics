package lzy.module.auth.repository;

import lzy.module.auth.domain.UserEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * User: longzhiyou
 * Date: 2016/11/8
 * Time: 20:04
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Cacheable
    UserEntity findFirstByUsername(String username);
}
