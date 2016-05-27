package com.baidu.apistore.sdk.customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by xiaohui on 2016/5/19.
 */
public class CustomFontsTextView extends TextView{
    public CustomFontsTextView(Context context) {
        super(context);
        Init(context);
    }

    public CustomFontsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public CustomFontsTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }
    public void Init(Context context){
        Typeface font = Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Thin.ttf");
        setTypeface(font);
    }
}
