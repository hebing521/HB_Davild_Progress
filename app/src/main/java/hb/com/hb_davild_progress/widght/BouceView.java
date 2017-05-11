package hb.com.hb_davild_progress.widght;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.AnimationSet;
import android.widget.ViewAnimator;

import hb.com.hb_davild_progress.R;

/**
 * Created by HeBing on 2017/5/11 16:46
 */

public class BouceView extends SurfaceView implements SurfaceHolder.Callback{

    public static final int STATE_DOWN = 1;
    public static final int STATE_UP = 2;
    private Paint mPaint;
    private Path mPath;
    private int mLineColor;
    private int mPointColor;
    private int mLineWidth;
    private int mLineHeight;
    private float mDownDistance;
    private float mUpDistance;
    private float freeBallDistance;

    private ViewAnimator downControl;
    private ViewAnimator upControl;
    private ViewAnimator freeDownControl;

    private AnimationSet animationSet;

    private int state;

    public BouceView(Context context) {
        super(context);
    }

    public BouceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BouceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);

    }

    private void init(Context context, AttributeSet attrs) {
         intiAttributes(context,attrs);
        mPaint =new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mLineWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();
        getHolder().addCallback(this);
    }

    private void intiAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.BoundPregress);
        mLineColor = typedArray.getColor(R.styleable.BoundPregress_line_color, Color.GREEN);
        mLineWidth = typedArray.getDimensionPixelOffset(R.styleable.BoundPregress_lint_width,200);
        mLineHeight = typedArray.getDimensionPixelOffset(R.styleable.BoundPregress_line_height,3);
        mPointColor = typedArray.getColor(R.styleable.BoundPregress_point_color,Color.BLACK);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mLineColor);
        mPath.reset();
        mPath.moveTo(getWidth()/2-mLineWidth/2,getHeight()/2);

        if(state==STATE_DOWN){
            mPath.quadTo((float) (getWidth()/2-mLineWidth/2+0.375*mLineWidth),getHeight()/2,getWidth()/2,getHeight()/2+mDownDistance);

        }else{

        }


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
