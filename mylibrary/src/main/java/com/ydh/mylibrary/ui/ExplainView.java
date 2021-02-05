package com.ydh.mylibrary.ui;

public class ExplainView {
    private int id,l,t,r,b;

    public ExplainView(int id,int l,int t,int r,int b){
        this.id = id;
        this.l = l;
        this.t = t;
        this.r = r;
        this.b = b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
