package com.happyfinger.eatertime.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.happyfinger.eatertime.R;

/**
 * Created by jiaoyang on 7/26/15.
 */
public class QuarterRingView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF(0, 0, 0, 0);
    private int mColor = 0xff0000ff;
    private int mBackColor = 0xaa0000ff;
    private float mRadius = 0;
    private float mWidth = 0;
    private float mStartAngle = 0;
    private float mSweepAngle = 0;

    private float mPercent = 0.5f;

    public QuarterRingView(Context context) {
        super(context);
    }

    public QuarterRingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public QuarterRingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.qring);
        mColor = a.getColor(R.styleable.qring_frontColor, 0xff0000ff);
        mBackColor = a.getColor(R.styleable.qring_backgroundColor, 0xaa0000ff);
        mRadius = a.getDimension(R.styleable.qring_radius, 100);
        mWidth = a.getDimension(R.styleable.qring_width, 40);
        mStartAngle = a.getFloat(R.styleable.qring_startAngle, 120);
        mSweepAngle = a.getFloat(R.styleable.qring_sweepAngle, 270);
        mPercent = Math.max(0, Math.min(1, a.getFloat(R.styleable.qring_percent, 0.5f)));
        a.recycle();
    }

    public void setPercent(float percent) {
        mPercent = Math.max(0, Math.min(1, percent));
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mBackColor);
        mPaint.setStrokeWidth(mWidth);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        mRectF.left = cx - mRadius;
        mRectF.right = cx + mRadius;
        mRectF.top = cy - mRadius;
        mRectF.bottom = cy + mRadius;

        canvas.drawArc(mRectF, mStartAngle + mSweepAngle * mPercent, mSweepAngle * (1 - mPercent), false, mPaint);
        mPaint.setColor(mColor);
        canvas.drawArc(mRectF, mStartAngle, mSweepAngle * mPercent, false, mPaint);
    }
}
