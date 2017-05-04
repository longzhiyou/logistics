package lzy.module.auth.repository;

import lzy.module.auth.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User: longzhiyou
 * Date: 2016/11/8
 * Time: 20:04
 */
//@CacheConfig(cacheNames = "users")
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {

    //将缓存保存进andCache，并使用参数中的bid加上一个字符串(这里使用方法名称)作为缓存的key
//    @Cacheable(value="findFirstByUsername")
    UserEntity findFirstByUsername(String username);

}
