package com.nju.Flash.image_manipulation.Draw;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/** 立方体
 *
 * 思路：
 * 1、先画一个矩形
 * 2、画一个和第一个矩形平行的矩形
 * 3、连接两个矩形之间的某些顶点
 * Created by randy on 14-3-3.
 */
public class DrawCube extends DrawBS {
    // 声明立方体的8个顶点。前面矩形的4个顶点为1、2、3、4；后面矩形的4个顶点为5、6、7、8
    Point cubePoint1,cubePoint2,cubePoint3,cubePoint4,cubePoint5,
                                            cubePoint6,cubePoint7,cubePoint8;
    Rect rect1,rect2;

    public DrawCube() {
        // 实例化
        cubePoint1 = new Point();
        cubePoint2 = new Point();
        cubePoint3 = new Point();
        cubePoint4 = new Point();
        cubePoint5 = new Point();
        cubePoint6 = new Point();
        cubePoint7 = new Point();
        cubePoint8 = new Point();
        rect1 = new Rect();
        rect2 = new Rect();
    }
    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);
        canvas.drawLine(cubePoint1.x,cubePoint1.y,cubePoint5.x,cubePoint5.y,paint);
        canvas.drawLine(cubePoint2.x,cubePoint2.y,cubePoint6.x,cubePoint6.y,paint);
        canvas.drawLine(cubePoint3.x,cubePoint3.y,cubePoint7.x,cubePoint7.y,paint);
        canvas.drawLine(cubePoint4.x,cubePoint4.y,cubePoint8.x,cubePoint8.y,paint);

    }

    @Override
    public void onTouchDown(Point point) {
        downPoint.set(point.x,point.y);
    }

    @Override
    public void onTouchUp(Point point) {
        super.onTouchUp(point);
    }

    @Override
    public void onTouchMove(Point point) {
        //第一个矩形的四个点
        cubePoint1.set(downPoint.x,downPoint.y);
        cubePoint2.set(point.x,point.y);
        cubePoint3.set(cubePoint1.x,cubePoint2.y);
        cubePoint4.set(cubePoint2.x,cubePoint1.y);

        //计算出立方体的边长的一半
        // 算出立方体的边长的一半
        int distance = (int) Math.abs(Math.sqrt((cubePoint4.x - cubePoint1.x)
                * (cubePoint4.x - cubePoint1.x) + (cubePoint4.y - cubePoint1.y)
                * (cubePoint4.y - cubePoint1.y))) / 2;

        //根据前面矩形的4个点，给后边矩形的4个点赋值
        cubePoint5.set(cubePoint1.x+distance,cubePoint1.y-distance);
        cubePoint6.set(cubePoint2.x+distance,cubePoint2.y-distance);
        cubePoint7.set(cubePoint3.x+distance,cubePoint3.y+distance);
        cubePoint8.set(cubePoint4.x+distance,cubePoint4.y-distance);

    }
}
