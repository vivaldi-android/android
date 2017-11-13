package com.wealth.freedom.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.Toast;

/**
 * @author: captain
 * Time:  2017/11/13 0013
 * Describe: 对话框显示
 */
public class DialogUtils {
    private static ProgressDialog progressDialog;

    private DialogUtils() {
         /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 显示一般情况下的对话框,两个按钮
     *
     * @param context
     * @param title        标题
     * @param message      内容
     * @param negativeText
     * @param negListener
     * @param postiveText
     * @param posListener
     * @param cancelOnOut  点击外部是否隐藏对话框 默认false
     * @param cancel       点击回退键知否隐藏对话框 默认false
     */
    public static void showNormalDialog(Context context, CharSequence title, CharSequence message,
                                        CharSequence negativeText, DialogInterface.OnClickListener negListener,
                                        CharSequence postiveText, DialogInterface.OnClickListener posListener,
                                        boolean cancelOnOut, boolean cancel
    ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setNegativeButton(negativeText, negListener);
        builder.setPositiveButton(postiveText, posListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showNormalDialog(Context context, CharSequence title, CharSequence message,
                                        int negTextId, DialogInterface.OnClickListener negListener,
                                        int posTextId, DialogInterface.OnClickListener posListener,
                                        boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setNegativeButton(negTextId, negListener);
        builder.setPositiveButton(posTextId, posListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();

    }

    /**
     * 显示一个按钮的dialog
     *
     * @param context
     * @param title
     * @param message
     * @param postiveText
     * @param posListener
     * @param cancelOnOut 点击外部是否隐藏对话框 默认false
     * @param cancel      点击回退键知否隐藏对话框 默认false
     */
    public static void showSingleButtonDialog(Context context, CharSequence title, CharSequence message,
                                              CharSequence postiveText, DialogInterface.OnClickListener posListener,
                                              boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setPositiveButton(postiveText, posListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showSingleButtonDialog(Context context, CharSequence title, CharSequence message,
                                              int posTextId, DialogInterface.OnClickListener posListener,
                                              boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setPositiveButton(posTextId, posListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 显示三个按钮的对话框
     *
     * @param context
     * @param title
     * @param message
     * @param negativeText
     * @param negListener
     * @param postiveText
     * @param posListener
     * @param neutariText
     * @param neuListener
     * @param cancelOnOut  点击外部是否隐藏对话框 默认false
     * @param cancel       点击回退键知否隐藏对话框 默认false
     */
    public static void showThreeButtonDialog(Context context, CharSequence title, CharSequence message,
                                             CharSequence negativeText, DialogInterface.OnClickListener negListener,
                                             CharSequence postiveText, DialogInterface.OnClickListener posListener,
                                             CharSequence neutariText, DialogInterface.OnClickListener neuListener,
                                             boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setNegativeButton(negativeText, negListener);
        builder.setPositiveButton(postiveText, posListener);
        builder.setNeutralButton(neutariText, neuListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showThreeButtonDialog(Context context, CharSequence title, CharSequence message,
                                             int negTextId, DialogInterface.OnClickListener negListener,
                                             int posTextId, DialogInterface.OnClickListener posListener,
                                             int neuTextId, DialogInterface.OnClickListener neuListener,
                                             boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setNegativeButton(negTextId, negListener);
        builder.setPositiveButton(posTextId, posListener);
        builder.setNeutralButton(neuTextId, neuListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 显示列表对话框
     *
     * @param context
     * @param title
     * @param items
     * @param itemListener
     * @param cancelOnOut  点击外部是否隐藏对话框 默认false
     * @param cancel       点击回退键知否隐藏对话框 默认false
     */
    public static void showListDialog(Context context, CharSequence title, CharSequence[] items, DialogInterface.OnClickListener itemListener,
                                      boolean cancelOnOut, boolean cancel) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setItems(items, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showListDialog(Context context, CharSequence title, int itemsId, DialogInterface.OnClickListener itemListener,
                                      boolean cancelOnOut, boolean cancel) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setItems(itemsId, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 展示单选对话框
     *
     * @param context
     * @param title
     * @param items
     * @param itemListener
     * @param cancelOnOut  点击外部是否隐藏对话框 默认false
     * @param cancel       点击回退键知否隐藏对话框 默认false
     */
    public static void showSigleChoiceDialog(Context context, CharSequence title, CharSequence[] items,
                                             DialogInterface.OnClickListener itemListener, boolean cancelOnOut, boolean cancel) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(items, 0, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showSigleChoiceDialog(Context context, CharSequence title, int itemsId,
                                             DialogInterface.OnClickListener itemListener, boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(itemsId, 0, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showSigleChoiceDialog(Context context, CharSequence title, ListAdapter adapter,
                                             DialogInterface.OnClickListener itemListener, boolean cancelOnOut, boolean cancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(adapter, 0, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 显示多选对话框
     *
     * @param context
     * @param title
     * @param items
     * @param chenkedItems
     * @param itemListener
     * @param cancelOnOut  点击外部是否隐藏对话框 默认false
     * @param cancel       点击回退键知否隐藏对话框 默认false
     */
    public static void showMultiSelectDialog(Context context, CharSequence title, CharSequence[] items, boolean[] chenkedItems,
                                             DialogInterface.OnMultiChoiceClickListener itemListener, boolean cancelOnOut, boolean cancel) {
        if (chenkedItems.length != items.length) {
            Toast.makeText(context,"对话框显示失败",Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMultiChoiceItems(items, chenkedItems, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    public static void showMultiSelectDialog(Context context, CharSequence title, int itemsId, boolean[] chenkedItems,
                                             DialogInterface.OnMultiChoiceClickListener itemListener, boolean cancelOnOut, boolean cancel) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMultiChoiceItems(itemsId, chenkedItems, itemListener);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(cancelOnOut);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 展示水平对话框
     * @param context
     * @param title
     * @param cancelOnOut
     * @param cancel
     */
    public static void showCircleDialog(Context context, CharSequence title,CharSequence message,boolean cancelOnOut, boolean cancel){
        if(progressDialog==null) {
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(cancel);
        progressDialog.setCanceledOnTouchOutside(cancelOnOut);
        progressDialog.show();

    }

    /**
     * 隐藏水平对话框
     */
    public static void hideCircleDialog(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
    public static void showHorizationDialog(Context context, CharSequence title, CharSequence message, float progress, long total){
        if(progressDialog==null) {
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setProgress((int) (progress * 100));
        float all = total / 1024 / 1024;
        float muqian = progress * all;
        progressDialog.setProgressNumberFormat(String.format("%.2fM/%.2fM", muqian, all));
        progressDialog.show();
    }
}
