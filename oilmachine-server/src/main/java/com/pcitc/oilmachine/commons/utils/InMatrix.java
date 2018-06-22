package com.pcitc.oilmachine.commons.utils;

public class InMatrix{  
    
    //(1)特殊情况，矩形平行于x轴和y轴  
    public static boolean isInMatrix(double x1,double y1,double x4,double y4,double x,double y){  
         
       if(x<=x1)  
       {  
            return false;  
       }  
       if(x>=x4)  
       {  
            return false;  
       }  
       if(y>=y1)  
       {  
            return false;  
       }  
       if(y<=y4)  
       {  
            return false;  
       }  
 
       return true;  
    }  
 
    //(2)一般情况，求一个点是否在一个矩阵中(转换成平行成x,y轴)  
    public static boolean isInSide(double x1,double y1,double x2,double y2,  
                                   double x3,double y3,double x4,double y4,double x,double y)  
    {  
         
        if(y1==y2)  
        {  
            return isInMatrix(x1,y1,x4,y4,x,y);  
        }  
        double l=Math.abs(y4-y3);  
        double k=Math.abs(x4-x3);  
        double s=Math.sqrt(k*k+l*l); //第三边的长度  
        double sin=l/s;  
        double cos=k/s;  
        double x1R=cos*x1+sin*y1;  
        double y1R=-x1*sin+y1*cos;  
        double x4R=cos*x4+sin*x4;  
        double y4R=-x4*sin+y4*cos;  
        double xR=cos*x+sin*y;  
        double yR=-x*sin+y*cos;  
 
       return isInMatrix(x1R,y1R,x4R,y4R,xR,yR);  
    }  
    
    public static boolean inside(double aleftx,double alefty,double arightx,double arighty,double bleftx,double blefty,double brightx,double brighty){
    	//求第一个矩形的所有点点的坐标 
    	//aleftx,alefty(left)
    	// arightx,alefty(top)
    	// aleftx,arighty(below)
    	//arightx,arighty(right)
    	
    	//求第二个矩形的所有点点的坐标 
    	//bleftx,blefty(left)
    	// brightx,blefty(top)
    	// bleftx,brighty(below)
    	//brightx,brighty(right)
    	
    	
    	//求第一个矩形的四个点是否在第二个矩形内部
    	boolean in1 = isInSide(bleftx,blefty,  brightx,blefty,bleftx,brighty, brightx,brighty, aleftx,alefty);
    	boolean in2 = isInSide(bleftx,blefty,  brightx,blefty,bleftx,brighty, brightx,brighty, arightx,alefty);
    	boolean in3 = isInSide(bleftx,blefty,  brightx,blefty,bleftx,brighty, brightx,brighty, aleftx,arighty);
    	boolean in4 = isInSide(bleftx,blefty,  brightx,blefty,bleftx,brighty, brightx,brighty, arightx,arighty);
    	return in1 || in2 || in3 ||in4;
    }
    
 
    public static void main(String[]args)  
    {  
        //System.out.println("Hello");  
    	double x1 = -2;  
        double y1 = 1;// (x1,y1) should be the most left  
        
        double x2 = 1;  
        double y2 = 1;// (x2,y2) should be the most top.  
        
        double x3 = -2;  
        double y3 = -2;// (x3,y3) should be the most below.  
        
        double x4 = 1;  
        double y4 = -2;// (x4,y4) should be the most right.
 
       double x = 0;  
       double y = 0;  
       System.out.print(isInSide(x1, y1, x2, y2, x3, y3, x4, y4, x, y)); 
    	
    	System.out.println(inside(-2, 1, 1, -2, -1, 2, 2, -1));
    }  
}
