package com.ydh.mylibrary.ui;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ViewContainer{
    private ViewBuilder viewBuilder;
    private ViewGroup vg;
    private DrawView myView;
    private Runnable runnable;
    private int onViewX,onViewY;
    private int viewCount;
    private View explainLayout;

    public ViewContainer(ViewBuilder builder){
        this.viewBuilder = builder;
        init();
    }

    private void init(){
        myView = new DrawView(viewBuilder.context);
        runnable = new Runnable() {
            @Override
            public void run() {
                vg = (ViewGroup) viewBuilder.context.getWindow().getDecorView();
                if(viewBuilder.onViews != null && viewBuilder.onViews.length > 0){
                    if(viewBuilder.onViews[viewCount] != null){
                        myView.setShadowSize(viewBuilder.shadowSize);
                        myView.setShapeType(viewBuilder.shapeType);
                        setOnViewInfo(viewCount);
                    }
                }
                vg.addView(myView);
                if(viewBuilder.onViews != null && viewBuilder.onViews.length > 0){
                    if(viewBuilder.onViews[viewCount] != null){
                        if(viewBuilder.explainViews != null && viewBuilder.explainViews.length > 0){
                            addLayout(viewCount);
                        }
                    }
                }
            }
        };
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewCount++;
                if(viewBuilder.onViews != null && viewCount < viewBuilder.onViews.length){
                    setOnViewInfo(viewCount);
                    if(viewBuilder.explainViews != null && viewCount < viewBuilder.explainViews.length){
                        vg.removeView(explainLayout);
                        addLayout(viewCount);
                    }else{
                        vg.removeView(explainLayout);
                    }
                }else{
                    vg.removeView(myView);
                    vg.removeView(explainLayout);
                }
                if(viewBuilder.callback != null){
                    viewBuilder.callback.dismiss();
                }
            }
        });
    }

    private void addLayout(int viewCount){
        if(viewBuilder.explainViews[viewCount] != null){
            explainLayout = LayoutInflater.from(viewBuilder.context).inflate(viewBuilder.explainViews[viewCount].getId(),null);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(onViewX+viewBuilder.explainViews[viewCount].getL(),
                    onViewY+viewBuilder.explainViews[viewCount].getT(),
                    viewBuilder.explainViews[viewCount].getR(),
                    viewBuilder.explainViews[viewCount].getB());
            vg.addView(explainLayout,params);
        }
    }

    private void setOnViewInfo(int viewCount){
        int[] location = new int[2];
        viewBuilder.onViews[viewCount].getLocationOnScreen(location);
        onViewX = location[0];
        onViewY = location[1];
        myView.setOnViewInfo(onViewX,onViewY,viewBuilder.onViews[viewCount].getWidth(),viewBuilder.onViews[viewCount].getHeight());
    }

    private Handler handler = new Handler();
    public void showGuideView(){
        handler.post(runnable);
    }
}
