package com.rjrn.cropview;

/**
 * Created by RanJun on 17/1/3.
 */
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class CropViewManager extends SimpleViewManager<CropView> {
    public static final String REACT_CLASS = "CropView";

    public static final float defaultRadius = 10.0f;

    public static final float defaultSampling = 10.0f;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CropView createViewInstance(ThemedReactContext context) {
        CropView cropView = new CropView(context);
        cropView.setCropRadius(defaultRadius);
        cropView.setShapeTop(0);
        cropView.setShapLeft(0);
        return cropView;
    }

    @ReactProp(name = "shapeRadius", defaultFloat = defaultRadius)
    public void setRadius(CropView view, float radius) {
        view.setCropRadius(radius);
    }

    @ReactProp(name = "shapTop", defaultFloat = defaultSampling)
    public void setShapTop(CropView view, float top) {
        view.setShapeTop(top);
    }

    @ReactProp(name = "shapLeft", defaultFloat = defaultSampling)
    public void setShapLeft(CropView view, float left) {
        view.setShapLeft(left);
    }

    @ReactProp(name = "overlayColor", customType = "Color")
    public void setColor(CropView view, int color) {
        view.setOverlayColor(color);
    }

}
