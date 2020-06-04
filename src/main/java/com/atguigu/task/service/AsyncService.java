package com.atguigu.task.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务：日常比较常见
 * 异步任务；这些方法将在执行的时候，将会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他的操作。
 */
@Service
public class AsyncService {

    // 告诉spring这是一个异步方法
    @Async
    public void hello(){
        try {

            // 利用线程睡眠三秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中....");
    }
}
