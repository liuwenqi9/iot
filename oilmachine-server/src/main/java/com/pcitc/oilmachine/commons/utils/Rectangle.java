package com.pcitc.oilmachine.commons.utils;

public class Rectangle
{
    private double _x1;
    private double _y1;
    private double _x2;
    private double _y2;


    public Rectangle(double x1, double y1, double x2, double y2)
    {
        this._x1 = x1;
        this._y1 = y1;
        this._x2 = x2;
        this._y2 = y2;

        this.SortPoint();
    }

    /// <summary>
    /// 确定最小顶点和最大顶点
    /// </summary>
    private void SortPoint()
    {
        double temp;
        if (_x1 > _x2)
        {
            temp = _x1;
            _x1 = _x2;
            _x2 = temp;
        }

        if (_y1 > _y2)
        {
            temp = _y1;
            _y1 = _y2;
            _y2 = temp;
        }
    }



    /// <summary>
    /// 判断是否出现重叠区域
    /// </summary>
    /// <param name="rect"></param>
    /// <returns></returns>
    public boolean IsOverlap(Rectangle rect)
    {
        //以执行比较者为参考点，简单采用绝对的四面平行判断
        boolean left = (rect._x2 < this._x1);
        boolean right = (rect._x1 > this._x2);
        boolean top = (rect._y1 > this._y2);
        boolean bottom = (rect._y2 < this._y1);

        return !(left || right || top || bottom);
    }
    
    public static boolean isInRect(float x,float y,float rx1,float ry1,float rx2,float ry2){
    	return(((x>rx1)^(x>rx2))&&((y>ry1)^(y>ry2)));
    }
    
    public static void main(String[] args) {
    	System.out.println(isInRect(2, 2, 1, 3, 3, 1));
	}
}
