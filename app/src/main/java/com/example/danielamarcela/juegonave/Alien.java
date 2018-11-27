package com.example.danielamarcela.juegonave;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Alien {
    float x,y;
    int desplazamiento;
    CountDownTimer timer,timerdisUno,timerdisA;
    int color;
    private Bitmap icono;
    private    Boolean visible;

    public Alien(int resourse, float posx, float posy, final Lienzo l, final Alien f)
    {
        x=posx;
        y=posy;
        icono = BitmapFactory.decodeResource(l.getResources(), resourse);
        visible=true;

        //timer aliens
        timer=new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {

                y+=desplazamiento;

                if(y>=l.getHeight())
                {
                    y=-100;
                }

                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        //timer balas de aliens
        timerdisA=new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {

                y+=desplazamiento;

                if(y>=l.getHeight())
                {
                    y=f.getY();
                }

                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        //timer balas de nave
        timerdisUno=new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {

                y-=desplazamiento;

                if(y==0)
                {
                    y=1920;
                }

                l.invalidate();
            }

            @Override
            public void onFinish() {

                start();

            }
        };
    }

    public void pintar(Canvas c, Paint p) {
        if (visible)  c.drawBitmap(icono, x, y, p);
    }


    public void mover(int desplaza)
    {
        desplazamiento=desplaza;
        timer.start();
    }

    public void movernave(float xp)
    {
        x=xp-(icono.getWidth()/2);
    }

    public void dispararUno()
    {
        desplazamiento=15;
        timerdisUno.start();
    }

    public void dispararAlien()
    {
        desplazamiento=15;
        timerdisA.start();
    }

    public void hacerVisible(boolean v)
    {
        visible=v;
    }

    public boolean estaEnArea(float xp, float yp)
    {
        if(!visible) return false;

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

    public boolean colision(Alien objB)
    {
        float x2=x+icono.getWidth();
        float y2=y+icono.getHeight();

        if(objB.estaEnArea(x2,y))
        {
            //caso 1
            return true;
        }
        if(objB.estaEnArea(x2,y2))
        {
            //caso 3
            return true;
        }
        if(objB.estaEnArea(x,y))
        {
            //caso 2
            return true;
        }
        if(objB.estaEnArea(x,y2))
        {
            //caso 4
            return true;
        }

        return false;
    }

    public float getY() {
        return y;
    }
}
