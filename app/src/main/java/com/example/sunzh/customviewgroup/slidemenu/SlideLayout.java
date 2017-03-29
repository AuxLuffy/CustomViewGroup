package com.example.sunzh.customviewgroup.slidemenu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by sunzh on 2017/3/29.
 */
public class SlideLayout extends FrameLayout {

    private View menuLayout, contentLayout;


    public SlideLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlideLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写此方法可以获取子view(getChildAt(int index))
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        menuLayout = getChildAt(1);
        contentLayout = getChildAt(0);

    }

    /**
     * 此方法可以得到视图本身及其子view的宽高
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewHeight = this.getMeasuredHeight();
        menuWidth = menuLayout.getMeasuredWidth();
        contentWidth = contentLayout.getMeasuredWidth();
    }

    private int viewHeight, menuWidth, contentWidth;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        menuLayout.layout(-menuWidth, 0, 0, viewHeight);
    }
}
