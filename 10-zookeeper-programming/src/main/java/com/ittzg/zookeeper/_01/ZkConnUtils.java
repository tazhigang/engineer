package com.ittzg.zookeeper._01;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: tazhigang
 * @date: 2021-01-27 00:41
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class ZkConnUtils {

    private static final String ip = "172.16.216.150";
    private static final int port = 2181;
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static final ZooKeeper getConn() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(ip, port, watchedEvent -> {
                Watcher.Event.KeeperState watchedEventState = watchedEvent.getState();
                System.out.println(watchedEventState);
                if (Watcher.Event.KeeperState.SyncConnected.equals(watchedEventState)) {
                    countDownLatch.countDown();
                }
                if(watchedEvent.getType().equals(Watcher.Event.EventType.NodeDataChanged)){
                    System.out.println("数据变更的路径是:"+watchedEvent.getPath());
                }
            });
            System.out.println("before:" + zooKeeper.getState());
            countDownLatch.await();
            System.out.println("after:" + zooKeeper.getState());
            return zooKeeper;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
