package lzy.demo;

import lzy.common.domain.nsm.JpaNestedSetRepository;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */

public interface ProjectRepositoryNestedSet extends JpaNestedSetRepository<Project, Long> {

//    @Modifying(clearAutomatically = true)                                           // (5)
//    @Query(value = "update Orders o set o.comments = :comments where o.orderNumber = :orderNumber")
//    Integer updateComments(@Param("orderNumber") Long orderNumber, @Param("comments") String comments);

}