package org.example;

public class IntPair {
    int w;
    int h;
double wd;
double hd;

    public IntPair() {
    }

    public IntPair(int w, int h, double wd, double hd) {
        this.w = w;
        this.h = h;
        this.wd = wd;
        this.hd = hd;
    }

    public IntPair(double wd, double hd) {
        this.wd = wd;
        this.hd = hd;
    }

    public IntPair(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "IntPair{" +
                "w=" + w +
                ", h=" + h +
                ", wd=" + wd +
                ", hd=" + hd +
                '}';
    }
}

