package com.wk.filelisten;

import com.wk.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 *
 * @author lenovo
 * @date 2018/2/6
 */
public class FileListener extends FileAlterationListenerAdaptor {
    /**
     * 文件创建执行
     */
    @Override
    public void onFileCreate(File file) {

        System.out.println("create file:" + file.getAbsolutePath());
        String message = Utils.FileMove(file,"D://test")?"移动成功":"移动失败";
        System.out.println(message);
    }

    /**
     * 文件创建修改
     */
    @Override
    public void onFileChange(File file) {
        System.out.println("modify file:" + file.getAbsolutePath());
        onFileCreate(file);
    }

    /**
     * 文件删除
     */
    @Override
    public void onFileDelete(File file) {
        System.out.println("delete file:" + file.getAbsolutePath());
    }

    /**
     * 目录创建
     */
    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("create dir:" + directory.getAbsolutePath());
    }

    /**
     * 目录修改
     */
    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("modify dir:" + directory.getAbsolutePath());
    }

    /**
     * 目录删除
     */
    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("delete dir:" + directory.getAbsolutePath());
    }

    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }
}
