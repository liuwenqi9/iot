package com.pcitc.oilmachine.commons.utils;
public class Rect {
    private float x1;
    private float y1;
    private float x2;
    private float y2;

    /**
     * 构造
     * 
     * @param x1
     *            第一个点 x 坐标
     * @param y1
     *            第一个点 y 坐标
     * @param x2
     *            第二个点 x 坐标
     * @param y2
     *            第二个点 y 坐标
     */
    public Rect(float x1, float y1, float x2, float y2) {
        // [Neo] 确保存储的点为 左上坐标(x1, y1) 以及 右下坐标(x2, y2)
        float tmp;
        if (x1 > x2) {
            tmp = x1;
            x1 = x2;
            x2 = tmp;
        }

        if (y1 > y2) {
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public float getLeftTopX() {
        return x1;
    }

    public float getLeftTopY() {
        return y1;
    }

    public float getRightBottomX() {
        return x2;
    }

    public float getRightBottomY() {
        return y2;
    }

    /**
     * 判断是否与指定的矩形有交集
     * 
     * @param rect
     *            另外的矩形
     * @return 是否
     */
    public boolean isRectIntersect(Rect rect) {
        return ((rect.getLeftTopX() >= getLeftTopX() && rect.getRightBottomX() >= getLeftTopX()) ||
                (rect.getLeftTopX() <= getLeftTopX() && rect.getRightBottomX() <= getLeftTopX()) ||
                (rect.getLeftTopY() >= getLeftTopY() && rect.getRightBottomY() >= getLeftTopY()) ||
                (rect.getLeftTopY() <= getLeftTopY() && rect.getRightBottomY() <= getLeftTopY()));
    }

    public static void main(String argv[]) {
        Rect rect1 = new Rect(1, 1, 3, 3);
        Rect rect2 = new Rect(-2, -2, 3, 3);

        System.out.println("result: " + (rect1.isRectIntersect(rect2)));
        System.out.println("result: " + (rect2.isRectIntersect(rect1)));
    }
}
