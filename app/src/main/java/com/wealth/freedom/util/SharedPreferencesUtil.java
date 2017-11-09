package com.wealth.freedom.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Map;
import java.util.Set;

/**
 * Created by Auser on 2017/11/9.
 */

public class SharedPreferencesUtil {
    private SharedPreferences sp;
    private Editor editor;
    private Context context;
    private String name = "freedom";
    private int mode = Context.MODE_PRIVATE;

    public SharedPreferencesUtil(Context context) {
        this.sp = context.getSharedPreferences(name, mode);
        this.editor = sp.edit();
        this.context = context;
    }

    /**
     * 创建一个工具类，默认打开名字为name的SharedPreferences实例
     *
     * @param context
     * @param name    唯一标识
     * @param mode    权限标识
     */
    public SharedPreferencesUtil(Context context, String name, int mode) {
        this.sp = context.getSharedPreferences(name, mode);
        this.editor = sp.edit();
        this.context = context;
    }

    /**
     * 添加信息到SharedPreferences
     *
     * @param map
     * @throws Exception
     */
    public void add(Map<String, String> map) {
        Set<String> set = map.keySet();
        for (String key : set) {
            editor.putString(key, map.get(key));
        }
        editor.commit();
    }

    /**
     * 删除信息
     *
     * @throws Exception
     */
    public void deleteAll() throws Exception {
        editor.clear();
        editor.commit();
    }

    /**
     * 删除一条信息
     */
    public void delete(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    public String get(String key) {
        if (sp != null) {
            return sp.getString(key, "");
        }
        return "";
    }

    /**
     * 获取此SharedPreferences的Editor实例
     *
     * @return
     */
    public Editor getEditor() {
        return editor;
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 针对复杂类型存储<对象>
     *
     * @param key
     * @param object
     */
    public void setObject(String key, Object object) {
        SharedPreferences sp = this.context.getSharedPreferences(this.name, Context.MODE_PRIVATE);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            Editor editor = sp.edit();
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObject(String key) {
        SharedPreferences sp = this.context.getSharedPreferences(this.name, Context.MODE_PRIVATE);
        if (sp.contains(key)) {
            String objectVal = sp.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                Object obj = ois.readObject();
                if (obj == null) {
                    return null;
                }
                return (T) obj;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
