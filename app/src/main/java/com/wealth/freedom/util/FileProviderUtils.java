package com.wealth.freedom.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import java.io.File;

/**
 * @author: captain
 * Time:  2017/11/15 0015
 * Describe: 安卓7.0共享文件
 */
public class FileProviderUtils {

    /**
     *
     * @param context
     * @param file
     * @return
     */
    public static Uri getFileUri (Context context, File file){
        Uri fileUri =null;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            fileUri = getFileUriByN(context,file);
        }else{
            fileUri = Uri.fromFile(file);
        }
        return  fileUri;
    }

    private static Uri getFileUriByN(Context context, File file) {
        Uri fileUri = android.support.v4.content.FileProvider.getUriForFile(context,context.getPackageName()+".fileprovider",file);
        return fileUri;
    }

    /**
     * apk自动安装更新
     *
     * @param context
     * @param intent
     * @param type
     * @param file
     * @param writeAble
     */
    public static void setIntentDataAndType(Context context, Intent intent, String type, File file, boolean writeAble) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setDataAndType(getFileUri(context, file), type);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            if (writeAble) {
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        } else {
            intent.setDataAndType(Uri.fromFile(file), type);
        }
    }

    /**
     * @param context
     * @param intent
     * @param file
     * @param writeAble
     */
    public static void setIntentData(Context context, Intent intent, File file, boolean writeAble) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setData(getFileUriByN(context, file));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            if (writeAble) {
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        } else {
            intent.setData(Uri.fromFile(file));
        }
    }
}
