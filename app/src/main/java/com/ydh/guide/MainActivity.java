package com.ydh.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ydh.mylibrary.GuideView;
import com.ydh.mylibrary.data.ContentViewData;
import com.ydh.mylibrary.data.LayoutIdData;
import com.ydh.mylibrary.data.OnViewData;
import com.ydh.mylibrary.ui.ExplainView;
import com.ydh.mylibrary.ui.ViewBuilder.DismissCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        TextView tv5 = findViewById(R.id.tv5);

        LayoutInflater inflater = LayoutInflater.from(this);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.layout_start,null);
        layout.findViewById(R.id.btn_iknow).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GuideView.with(MainActivity.this).hide();
            }
        });
        layout.findViewById(R.id.btn_again).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GuideView.with(MainActivity.this).showAgain();
            }
        });
        GuideView.with(this)
                .setOnViews(
                        new OnViewData[]{GuideView.buildOnViewData(R.id.tv3,10,10,10,10,
                                new ExplainView(LayoutIdData.RIGHT,
                                        new ContentViewData("朝辞白帝彩云间",ContentViewData.M_LEFT,30),200,300))},
                        new OnViewData[]{GuideView.buildOnViewData(R.id.tv2,0,20,0,30,new ExplainView(LayoutIdData.BOTTOM,new ContentViewData("朝辞白帝彩云间",ContentViewData.M_LEFT,30),50,100)),
                                GuideView.buildOnViewData(R.id.tv1,0,0,30,0,new ExplainView(LayoutIdData.BOTTOM,new ContentViewData("朝辞白帝彩云间",ContentViewData.M_LEFT,30),50,100))},
                        new OnViewData[]{GuideView.buildOnViewData(R.id.tv4,10,10,10,10,new ExplainView(LayoutIdData.BOTTOM,new ContentViewData("朝辞白帝彩云间",ContentViewData.M_LEFT,30),50,100)),
                                GuideView.buildOnViewData(R.id.tv5,10,10,10,10,new ExplainView(LayoutIdData.LEFT,new ContentViewData("朝辞白帝彩云间",ContentViewData.M_LEFT,30),100,100))})
                .setOtherViews(
                        new ExplainView(R.layout.layout_other_view,300,500),
                        new ExplainView(R.layout.layout_other_view,300,500),
                        new ExplainView(layout,300,500)
                )
                .setSkipButton("跳过")
                .setShapeType(GuideView.RECTANGLE)
//                .setBgColor(R.color.colorAccent)
                .setShadowSize(20)
                .setDismissCallback(new DismissCallback() {
                    @Override
                    public void skip() {

                    }

                    @Override
                    public void dismiss(int oldPosition, int newPosition) {

                    }

                })
                .show();
    }
}
