package lzy;


import lzy.demo.Project;
import lzy.demo.ProjectRepositoryNestedSet;
import lzy.utils.IdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//@DataJpaTest
public class ProjectNestedSetTest {

    private static final Logger logger = LoggerFactory.getLogger(ProjectNestedSetTest.class);


    @Autowired
    ProjectRepositoryNestedSet projectRepositoryNestedSet;


    /**
     * 测试增加一个节点
     */
    @Test
    @Transactional
    @Rollback(false)
    public void saveNode() {

        Project parent = projectRepositoryNestedSet.findOne(857479240570896384L);

        Integer rgt = parent.getRgt();
        Integer lft = parent.getLft();
//        projectRepositoryNestedSet.updateRightValue(rgt);
//        projectRepositoryNestedSet.updateLeftValue(rgt);
//
//        Project node = new Project();
//        node.setName("horse");
//        node.setId(IdUtils.getId());
//        node.setParentId(parent.getId());
//        node.setLft(rgt);
//        node.setRgt(rgt+1);
//
//        projectRepositoryNestedSet.save(node);



    }

    @Test
    @Transactional
    @Rollback(false)
    public void initRootNode() {

        /**
         * 先只存储一棵树,不存储森林
         * root 初始化 lft=1 rgt=2 level=0,path="."
         * [2017-04-27 add by longzhiyou]
         */
        Project root = new Project();
        root.setId(IdUtils.getId());
        root.setName("root");
        root.setLft(1);
        root.setRgt(2);

        root.setLevel(0);
        root.setPath(".");

        projectRepositoryNestedSet.save(root);
    }

    @Test
    public void getRoot() {

        Project root = projectRepositoryNestedSet.getRoot();
        assertNotNull(root);
    }

    @Test
    public void getSubTree() {

        List<Project> subTree = projectRepositoryNestedSet.getSubTree(11);
        assertNotNull(subTree);
    }

    @Test
    public void getChildren() {

        List<Project> children = projectRepositoryNestedSet.getChildren(857470499125460992L);
        assertNotNull(children);
    }






} 
