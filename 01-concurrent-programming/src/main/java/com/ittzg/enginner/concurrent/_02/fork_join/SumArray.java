package com.ittzg.enginner.concurrent._02.fork_join;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author: tazhigang
 * @date: 2021/1/19 10:01
 * @Email: tazhigang095@163.com
 * @desc:
 */
public class SumArray {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        int[] src = MakeArray.makeArray();

        SumTask innerFind = new SumTask(src,0,src.length-1);

        long start = System.currentTimeMillis();

        pool.invoke(innerFind);//同步调用
        System.out.println("Task is Running.....");

        System.out.println("The count is "+innerFind.join()
                +" spend time:"+(System.currentTimeMillis()-start)+"ms");




    }


    static class SumTask extends RecursiveTask<Integer> {

        private static final int THRESHOLD = MakeArray.ARRAY_LENGTH/10;

        private int[] src;
        private int fromIndex;
        private int toIndex;

        public SumTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if(toIndex-fromIndex<=THRESHOLD){
                int count = 0;
                for (int i = fromIndex; i <=toIndex ; i++) {
                    count =+ src[i];
                }
                return count;
            }else{
                int mid = (fromIndex+toIndex)/2;
                SumTask left = new SumTask(src, fromIndex, mid);
                SumTask right = new SumTask(src, mid+1, toIndex);
                invokeAll(left,right);
                return left.join()+right.join();
            }
        }
    }


    static class MakeArray{
        //数组长度
        public static final int ARRAY_LENGTH  = 1000000;

        public static int[] makeArray() {

            //new一个随机数发生器
            Random r = new Random();
            int[] result = new int[ARRAY_LENGTH];
            for(int i=0;i<ARRAY_LENGTH;i++){
                //用随机数填充数组
                result[i] =  r.nextInt(ARRAY_LENGTH*3);
            }
            return result;

        }
    }

}
