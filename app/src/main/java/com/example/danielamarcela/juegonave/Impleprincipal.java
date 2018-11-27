package com.example.danielamarcela.juegonave;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Impleprincipal {

    private Bitmap icono;
    private   float x, y;
    private    Boolean visible;
    int incrementoenx, incrementoeny;

    public Impleprincipal(int resourse, float _x, float _y, Principal l) {
        icono = BitmapFactory.decodeResource(l.getResources(), resourse);
        x = _x;
        y = _y;
        visible=true;
        incrementoenx=10;
        incrementoeny=10;

    }

    public void pintar(Canvas c, Paint p) {
        if (visible)  c.drawBitmap(icono, x, y, p);
    }

    public boolean estaEnArea(float xp, float yp)
    {
        float x2,y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<=x2)
        {
            if(yp>=y && yp<=y2)
            {
                return true;
            }
        }


        return false;
    }

}
