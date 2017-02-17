package com.rjrn.cropview;

/**
 * Created by RanJun on 17/1/3.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.util.Log;

public class CropView extends View{
//    private static final String TAG = "cropview";

    private Bitmap mSrcRect;
    private Bitmap mDstCircle;

    private int mScreenWidth=0;   // 屏幕的宽
    private int mScreenHeight;  // 屏幕的高

//    private int mPiercedX, mPiercedY;//镂空的圆心坐标
    private float mPiercedRadius = 50.0f;//镂空的圆半径

    private int mOverlayColor;
    private float top = 0.0f;
    private float left = 0.0f;

    private float density = 1.0f; //像素密度

    public CropView(Context context) {
        this(context, (AttributeSet)null);
    }

    public CropView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);

        if (mScreenWidth == 0) {
            DisplayMetrics dm = getResources().getDisplayMetrics();
            mScreenWidth = dm.widthPixels;
            mScreenHeight = dm.heightPixels;
            density = dm.density;
        }
    }

    /**
     * @param mPiercedX      镂空的圆心坐标
     * @param mPiercedY      镂空的圆心坐标
     * @param mPiercedRadius 镂空的圆半径
     */
    public void setCropRadius(float mPiercedRadius) {
        this.mPiercedRadius = mPiercedRadius*density;
    }

    public void setOverlayColor(int color) {
        this.mOverlayColor = color;
    }

    public void setShapeTop(float top) {
        this.top = top*density;
    }

    public void setShapLeft(float left) {
        this.left = left*density;
    }



//    public void setPiercePosition(int mPiercedX, int mPiercedY, int mPiercedRadius) {
//        this.mPiercedX = mPiercedX;
//        this.mPiercedY = mPiercedY;
//        this.mPiercedRadius = mPiercedRadius;
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        mSrcRect = makeSrcRect();
        mDstCircle = makeDstCircle();

        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        canvas.saveLayer(0, 0, mScreenWidth, mScreenHeight, null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);

        canvas.drawBitmap(mDstCircle, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        paint.setAlpha(160);
        canvas.drawBitmap(mSrcRect, 0, 0, paint);
        paint.setXfermode(null);

        canvas.saveLayer(0, 0, mScreenWidth, mScreenHeight, null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);
        paint.setAlpha(255);
    }

    /**
     * 创建镂空层圆形形状
     * @return
     */
    private Bitmap makeDstCircle() {
        Bitmap bm = Bitmap.createBitmap(mScreenWidth, mScreenHeight, Bitmap.Config.ARGB_8888);
        Canvas canvcs = new Canvas(bm);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);

        canvcs.drawCircle(left+mPiercedRadius, top+mPiercedRadius, mPiercedRadius, paint);
        return bm;
    }
    /**
     * 创建遮罩层形状
     *
     * @return
     */
    private Bitmap makeSrcRect() {
//        Log.i("Rtes", "ssss===>>>left>>"+this.getMeasuredWidth()+"===height==>>"+this.getMeasuredHeight());
        Bitmap bm = Bitmap.createBitmap(mScreenWidth, mScreenHeight, Bitmap.Config.ARGB_8888);
        Canvas canvcs = new Canvas(bm);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        canvcs.drawRect(new RectF(0, 0, mScreenWidth, mScreenHeight), paint);
        return bm;
    }

}
