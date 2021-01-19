package com.ittzg.enginner.concurrent._02.fork_join;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author: tazhigang
 * @date: 2021/1/19 10:07
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class FindDirsFiles {


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        FindDirsFilesTask findDirsFilesTask = new FindDirsFilesTask(new File("E:/"));


        pool.execute(findDirsFilesTask);

        findDirsFilesTask.join();//阻塞的方法
        System.out.println("Task end");
    }

    static class FindDirsFilesTask  extends RecursiveAction {

        private File file;

        public FindDirsFilesTask(File file) {
            this.file = file;
        }

        @Override
        protected void compute() {
            List<FindDirsFilesTask> subTasks = new ArrayList<>();
            File[] files = this.file.listFiles();
            if(files!=null){
                for (File file1 : files) {
                    if(file1.isDirectory()){
                        subTasks.add(new FindDirsFilesTask(file1));
                    }else{
                        //遇到文件，检查
                        if(file1.getAbsolutePath().endsWith("txt")) {
                            System.out.println("文件："+file1.getAbsolutePath());
                        }
                    }
                }
            }
            if(!subTasks.isEmpty()){
                for (FindDirsFilesTask subTask : invokeAll(subTasks)) {
                    subTask.join();
                }
            }
        }
    }

}
