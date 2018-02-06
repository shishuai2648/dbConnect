package com.wk.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import static com.sun.deploy.cache.Cache.exists;

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

    public static Boolean FileMove(final File oldFile, final File newFile) {
        if (!newFile.exists()) {
            newFile.mkdir();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = formatter.format(new Date());

        String fileName = newFile.getAbsolutePath() + "//"+ date;

        String suffix = oldFile.getName().substring(oldFile.getName().lastIndexOf("."));

        File file = new File(fileName+suffix);
        int i = 1;
        while (file.exists()){
            fileName = fileName+"("+i+")"+suffix;
            file = new File(fileName);
            i++;
        }
        try {
            FileUtils.copyFile(oldFile,file);
            FileUtils.deleteQuietly(oldFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
