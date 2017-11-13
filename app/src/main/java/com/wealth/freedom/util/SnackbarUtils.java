package com.wealth.freedom.util;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wealth.freedom.casualname.R;


/**
 * @author: captain
 * Time:  2017/11/13 0013
 * Describe:Snackbar常规用法的简单封装
 */
public class SnackbarUtils {
    private static Snackbar mSnackbar;
    private SnackbarUtils() {
         /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 短时间显示Snackbar
     * @param view
     * @param message
     * 显示内容除了可以是CharSequence之外，还可以是int的resID
     */
    public static void showShort(View view, CharSequence message) {
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        }
        mSnackbar.show();
    }

    /**
     * 长时间显示Snackbar
     * @param view
     * @param message
     */
    public static void showLong(View view, CharSequence message){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        }
        mSnackbar.show();
    }

    /**设置显示时间为 LENGTH_INDEFINITE
     * @param view
     * @param message
     */
    public static void showIndedinite(View view, CharSequence message){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        }
        mSnackbar.show();
    }
    /**
     * 自定义时长的显示Snackbar
     * @param view
     * @param message
     * @param duration
     */
    public static void showDuration(View view, CharSequence message,int duration){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        mSnackbar.show();
    }

    /**
     * 修改Snackbar的背景颜色
     * @param view
     * @param message
     * @param bgColor
     * @param durantion
     */
    public static void showDiffBackGround(View view, CharSequence message,int bgColor,int durantion){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, durantion);
        }
        mSnackbar.getView().setBackgroundColor(bgColor);
        mSnackbar.show();
    }

    /**
     * 设置Snackbar中TextView中文字的颜色
     * @param view
     * @param message
     * @param durantion
     * @param txtColor
     */
    public static void showTextColor(View view, CharSequence message,int durantion,int txtColor){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message,durantion);
        }
        ((TextView) mSnackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(txtColor);
        mSnackbar.show();
    }

    /**设置Snackbar背景以及TextView中文字的颜色
     * @param view
     * @param message
     * @param durantion
     * @param bgColor
     * @param txtColor
     */
    public static void showTextColor(View view, CharSequence message,int durantion,int bgColor,int txtColor){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message,durantion);
        }
        mSnackbar.getView().setBackgroundColor(bgColor);
        ((TextView) mSnackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(txtColor);
        mSnackbar.show();
    }

    /**
     * 设置按钮文字颜色
     * @param view
     * @param message
     * @param durantion
     * @param buttonTextColor
     */
    public static void showButtonColor(View view, CharSequence message,int durantion,int buttonTextColor){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message,durantion);
        }
        ((Button) mSnackbar.getView().findViewById(R.id.snackbar_action)).setTextColor(buttonTextColor);
        mSnackbar.show();
    }

    /**设置Snackbar背景颜色，按钮文字颜色
     * @param view
     * @param message
     * @param durantion
     * @param bgColor
     * @param buttonTextColor
     */
    public static void showButtonColor(View view, CharSequence message,int durantion,int bgColor,int buttonTextColor){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message,durantion);
        }
        mSnackbar.getView().setBackgroundColor(bgColor);
        ((Button) mSnackbar.getView().findViewById(R.id.snackbar_action)).setTextColor(buttonTextColor);
        mSnackbar.show();
    }

    /**
     * 设置Snackbar背景，文字，按钮文字颜色
     * @param view
     * @param message
     * @param durantion
     * @param bgColor
     * @param textColor
     * @param buttonTextColor
     */
    public static void showAllTextColor(View view, CharSequence message,int durantion,int bgColor,int textColor,int buttonTextColor){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message,durantion);
        }
        mSnackbar.getView().setBackgroundColor(bgColor);
        ((TextView) mSnackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(textColor);
        ((Button) mSnackbar.getView().findViewById(R.id.snackbar_action)).setTextColor(buttonTextColor);
        mSnackbar.show();
    }

    /**
     * 设置Snackbar的透明度
     * @param view
     * @param message
     * @param duration
     * @param alpha
     */
    public static void showAlpha(View view,CharSequence message,int duration,float alpha){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        alpha=alpha>=1.0f?1.0f:(alpha<=0.0f?0.0f:alpha);
        mSnackbar.getView().setAlpha(alpha);
        mSnackbar.show();
    }

    /**
     * 设置Snackbar的显示位置
     * @param view
     * @param message
     * @param duration
     * @param gravity
     */
    public static void showLocation(View view,CharSequence message,int duration,int gravity){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        FrameLayout.LayoutParams pramas = new FrameLayout.LayoutParams(mSnackbar.getView().getLayoutParams().width,mSnackbar.getView().getLayoutParams().height);
        pramas.gravity=gravity;
        mSnackbar.getView().setLayoutParams(pramas);
        mSnackbar.show();
    }

    /**
     * 设置Snackbar按钮文字及点击事件
     * @param view
     * @param message
     * @param duration
     * @param buttonText
     * @param listener
     */
    public static void setAction(View view , CharSequence message, int duration, CharSequence buttonText, View.OnClickListener listener){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        mSnackbar.setAction(buttonText,listener);
        mSnackbar.show();
    }

    /**设置Snackbar回调监听
     * @param view
     * @param message
     * @param duration
     * @param buttonText
     * @param listener
     * @param callback
     */
    public  static void setCallback(View view , CharSequence message, int duration, CharSequence buttonText, View.OnClickListener listener,Snackbar.Callback callback){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        mSnackbar.setAction(buttonText,listener);
        mSnackbar.setCallback(callback);
        mSnackbar.show();
    }

    /**
     * 设置Snackbar中TextView文字居中
     * @param view
     * @param message
     * @param duration
     */
    public static void setTextCenter(View view , CharSequence message, int duration){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.JELLY_BEAN_MR1){
            TextView  txt= (TextView) mSnackbar.getView().findViewById(R.id.snackbar_text);
            txt.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            txt.setGravity(Gravity.CENTER);
        }
        mSnackbar.show();
    }

    /**
     * 设置TextView文字居右，此处不可setAction，TextView会将其覆盖
     * @param view
     * @param message
     * @param duration
     */
    public static void setTextRight(View view , CharSequence message, int duration){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.JELLY_BEAN_MR1){
            TextView  txt= (TextView) mSnackbar.getView().findViewById(R.id.snackbar_text);
            txt.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            txt.setGravity(Gravity.RIGHT);
        }
        mSnackbar.show();
    }

    /**
     * 为Snackbar添加布局
     * @param view
     * @param message
     * @param duration
     * @param addView
     * @param index
     */
    public static void addLayout(View view , CharSequence message, int duration,View addView,int index){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        //设置新建布局参数
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
       //设置垂直居中
        params.gravity = Gravity.CENTER_VERTICAL;
        addView.setLayoutParams(params);
        ((Snackbar.SnackbarLayout)mSnackbar.getView()).addView(addView,index);
        mSnackbar.show();
    }

    /**
     * 为Snackbar添加布局
     * @param view
     * @param message
     * @param duration
     * @param layoutId
     * @param index
     */
    public static void addLayout(View view , CharSequence message, int duration,int layoutId,int index){
        if(mSnackbar==null){
            mSnackbar= Snackbar.make(view, message, duration);
        }
        View addView = LayoutInflater.from(mSnackbar.getView().getContext()).inflate(layoutId,null);
        ((Snackbar.SnackbarLayout)mSnackbar.getView()).addView(addView,index);
        mSnackbar.show();
    }
}
