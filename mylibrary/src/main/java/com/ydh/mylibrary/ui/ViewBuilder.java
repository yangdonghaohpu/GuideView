package com.ydh.mylibrary.ui;

import android.app.Activity;
import android.view.View;

public class ViewBuilder {
    Activity context;
    View[] onViews;
    ExplainView[] explainViews;
    int shadowSize = 0,shapeType = 1;
    DismissCallback callback;
    public ViewBuilder(Activity activity){
        this.context = activity;
    }

    public void show(){
        ViewContainer viewContainer = new ViewContainer(this);
        viewContainer.showGuideView();
    }

    public ViewBuilder setOnView(View... view){
        this.onViews = view;
        return this;
    }

    public ViewBuilder setShadowSize(int size){
        this.shadowSize = size;
        return this;
    }

    public ViewBuilder setShapeType(int type){
        this.shapeType = type;
        return this;
    }

    public ViewBuilder setDismissCallback(DismissCallback callback){
        this.callback = callback;
        return this;
    }

    public ViewBuilder setExplainViews(ExplainView... explainViews){
        this.explainViews = explainViews;
        return this;
    }

    public interface DismissCallback{
        void dismiss();
    }

}
