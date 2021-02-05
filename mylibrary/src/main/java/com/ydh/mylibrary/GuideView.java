package com.ydh.mylibrary;

import android.app.Activity;

import com.ydh.mylibrary.ui.ExplainView;
import com.ydh.mylibrary.ui.ViewBuilder;

public class GuideView {
    public static int RECTANGLE = 1,CIRCLE = 2,OVAL = 3;
    public GuideView(){

    }
    public static ViewBuilder with(Activity activity){
        if(activity == null){
            return null;
        }
        return new ViewBuilder(activity);
    }
    public static ExplainView buildExplainView(int id, int l, int t, int r, int b){
        return new ExplainView(id,l,t,r,b);
    }
}
