package lzy;


import lzy.demo.Project;
import lzy.demo.ProjectRepositoryNestedSet;
import lzy.module.auth.domain.UserEntity;
import lzy.module.auth.repository.UserRepository;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.entity.PartyRoleType;
import lzy.module.party.entity.Person;
import lzy.module.party.repository.PartyRepository;
import lzy.module.party.repository.PartyRoleTypeRepository;
import lzy.module.party.repository.RoleTypeRepository;
import lzy.module.party.service.PersonService;
import lzy.utils.IdWorker;
import lzy.utils.LicenseGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
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
//        node.setId(IdWorker.getId());
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
        root.setId(IdWorker.getId());
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
