package com.ittzg.zookeeper._01;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: tazhigang
 * @date: 2021-01-27 00:54
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class ZkOpTest {


    @Test
    public void testGetConn() throws KeeperException, InterruptedException {

        ZooKeeper zooKeeper = ZkConnUtils.getConn();
        System.out.println(zooKeeper);
        zooKeeper.create("/test","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.CONTAINER);

    }

    @Test
    public void testGetChildren() throws KeeperException, InterruptedException {
        List<String> children = ZkConnUtils.getConn().getChildren("/test", true);

        System.out.println(children);
    }

    @Test
    public void setData() throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZkConnUtils.getConn();
        zooKeeper.getData("/test",true,new Stat());
        zooKeeper.setData("/test", "test3".getBytes(),-1);
        zooKeeper.setData("/test", "test4".getBytes(),-1);

    }

}
