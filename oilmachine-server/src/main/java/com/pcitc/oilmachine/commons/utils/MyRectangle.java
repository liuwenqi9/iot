package com.pcitc.oilmachine.commons.utils;

public class MyRectangle {
	public long x;
	public long y;
	public long width;
	public long height;
	
	public MyRectangle() {
	}

	public MyRectangle(long x, long y, long width, long height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public long getArea() {
		return this.height * this.width;
	}

	public static long getOverLappingArea(MyRectangle a, MyRectangle b) {
		long overLappingArea = 0l;

		long startX = Math.min(a.x, b.x);
		long endX = Math.max(a.x + a.width, b.x + b.width);
		long overLappingWidth = a.width + b.width - (endX - startX);

		long startY = Math.min(a.y, b.y);
		long endY = Math.max(a.y + a.height, b.y + b.height);
		long overLappingHeight = a.height + b.height - (endY - startY);

		if (overLappingWidth <= 0 || overLappingHeight <= 0) {
			overLappingArea = 0;
		} else {
			overLappingArea = overLappingWidth * overLappingHeight;
		}
		return overLappingArea;

	}

	public static double getOverLappingRate(MyRectangle a, MyRectangle b) {
		double overLappingRate = 0.0;
		long overLappingArea = getOverLappingArea(a, b);
		if (overLappingArea == 0) {
			overLappingRate = 0.0;
		} else {
			long areaA = a.getArea();
			long areaB = b.getArea();
			overLappingRate = (double) overLappingArea
					/ (double) (areaA + areaB - overLappingArea);
		}
		return overLappingRate;
	}
	
	/**
	 * 计算两个矩形的重合面积占 b参数的比率
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getOverLappingRateB(MyRectangle a, MyRectangle b) {
		double overLappingRate = 0.0;
		long overLappingArea = getOverLappingArea(a, b);
		if (overLappingArea == 0) {
			overLappingRate = 0.0;
		} else {
			long areaB = b.getArea();
			overLappingRate = (double) overLappingArea
					/ (double) areaB;
		}
		return overLappingRate;
	}
	
	public static double getDistance(MyRectangle a, MyRectangle b) {
		double overLappingRate = 0.0;
		long overLappingArea = getOverLappingArea(a, b);
		if (overLappingArea == 0) {
			overLappingRate = 0.0;
		} else {
			long areaB = b.getArea();
			overLappingRate = (double) overLappingArea
					/ (double) areaB;
		}
		return overLappingRate;
	}
}
