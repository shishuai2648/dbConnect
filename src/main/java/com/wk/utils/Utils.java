package com.wk.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by lenovo on 2018/2/6.
 */
public class Utils {

    public static Boolean FileMove(String file1, String file2) {
        return FileMove(new File(file1), new File(file2));
    }

    public static Boolean FileMove(File oldFile, String file2) {
        return FileMove(oldFile, new File(file2));
    }

    public static Boolean FileMove(File oldFile, File newFile) {
        if (!newFile.exists()) {
            newFile.mkdir();
        }
        try {
            FileUtils.copyFileToDirectory(oldFile,newFile);
            FileUtils.deleteDirectory(oldFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
