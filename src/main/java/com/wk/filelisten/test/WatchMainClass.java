package com.wk.filelisten.test;

import com.wk.filelisten.FileListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2018/2/6.
 */
public class WatchMainClass {
    private static void FileListenterClass() throws Exception{
        // 监控目录
        String rootDir = "D:\\temp";
        // 轮询间隔 1 秒
        long interval = TimeUnit.SECONDS.toMillis(1);
        // 创建一个文件观察器用于处理文件的格式
        FileAlterationObserver observer = new FileAlterationObserver(rootDir);
        //设置文件变化监听器
        observer.addListener(new FileListener());
        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        monitor.start();
    }

    /**
     * 测试模块
     * @param args
     */
    public static void main (String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("-----init file-----");
                    FileListenterClass();
                } catch (Exception e){
                    System.err.print(e);
                    run();
                }
            }
        }).start();
    }
}
