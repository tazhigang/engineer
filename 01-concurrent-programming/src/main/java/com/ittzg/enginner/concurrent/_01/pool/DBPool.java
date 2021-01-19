package com.ittzg.enginner.concurrent._01.pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: tazhigang
 * @date: 2021/1/19 9:12
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class DBPool {

    private static final LinkedList<Connection> dbPool = new LinkedList<>();



    public DBPool(int initializationSize) {
        if(initializationSize==0){
            initializationSize = 10;
        }
        for (int i = 0; i < initializationSize; i++) {
            dbPool.addLast(SqlConnection.fetchConnection());
        }
    }

    /**
     * 超时等待获取链接
     * @return
     */
    public static Connection getConn(long timeOut){

        synchronized (dbPool){
            try {
                if(timeOut<=0){
                    if(dbPool.isEmpty()){
                        dbPool.wait();
                    }
                    return dbPool.removeFirst();
                }else{

                    long overTime = System.currentTimeMillis()+timeOut;
                    long remainTime = timeOut;

                    while (dbPool.isEmpty()&&remainTime>=0){
                        dbPool.wait(remainTime);
                        remainTime=overTime-System.currentTimeMillis();
                    }

                    if(dbPool.isEmpty()){
                        return null;
                    }else{
                        return dbPool.removeFirst();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    public static void releaseConn(Connection connection){
        if(connection!=null){
            synchronized (dbPool){
                dbPool.addLast(connection);
                dbPool.notifyAll();
            }
        }
    }



}
