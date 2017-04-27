package lzy.common.domain.nsm;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 重点:
 * 1.目前必须添加@NoRepositoryBean
 * 2.必须用springframework中的Transactional 注解
 * 3.id,lft,rgt 必须是固定的名字
 * Drawbacks:Nested sets are very slow for inserts
 * because it requires updating left and right domain values for all records in the table after the insert.
 * Created by longzhiyou on 2016-03-02.
 */
@NoRepositoryBean
public interface JpaNestedSetRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {


    @Query("select node from #{#entityName} node WHERE lft=1")
    T getRoot();

    /**
     * 获取直接子节点列表
     * @param nodeId 节点主键
     * @return
     */
    @Query("select node from #{#entityName} node WHERE parent_id=?1")
    List<T> getChildren(Long nodeId);

    @Query("select node from #{#entityName} node WHERE lft=rgt-1")
    List<T> getAllLeaf();

    /**
     * @return
     */
    @Query("SELECT node FROM #{#entityName} node,#{#entityName} parent " +
            "WHERE parent.lft = ?1 AND node.lft BETWEEN parent.lft AND parent.rgt ORDER BY node.lft")
    List<T> getSubTree(Integer lft);





    @Modifying
    @Query("UPDATE #{#entityName} node SET node.rgt = node.rgt + 2 WHERE node.rgt >=?1")
    int updateRightValue(Integer rgt);

    @Modifying
    @Query("UPDATE #{#entityName} node SET node.lft = node.lft + 2 WHERE node.lft >=?1")
    int updateLeftValue(Integer lft);


    /**
     create
         build()
         destroy()
         upgrade()
     retrieve
         getRoot()
         getParent()
         getDescendants()
         getLeaves()
         getLevels()
         getPath()
         getChildren()
         getFirstNChildren()
         getFirstChild()
         getLastChild()
         getChildAtIndex()
         getTree()
         getSize()
         getTreeHeight()
         getNodeData()
     insert
         appendChild()
         insertAfter()
         insertBefore()
         insertChildAtIndex()
     edit
         updateNode()
     move
         movefter()
         moveBefore()
         moveNodeAtIndex()
     delete
         deleteNode()
         clean()
         cleanAll()
         closeGaps()
     data liberation
         import()
         export()
     * [2017-04-27 add by longzhiyou]
     */


}
