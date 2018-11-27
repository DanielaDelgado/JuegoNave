package com.example.danielamarcela.juegonave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Alien n1,n2,n3,navecool, fondo,balaUno,fin,balaAlienUno,balaAlienDos,balaAlienTres,ganar;
    Alien punteroUno,punteroDos,punteroTres;
    int cont=0;
    Main2Activity obj;


    public Lienzo(Context context) {
        super(context);

        obj=(Main2Activity)context;
        n1=new Alien(R.drawable.alien,90,1,this,n1);
        n2=new Alien(R.drawable.alien,450,1,this,n2);
        n3=new Alien(R.drawable.alien,800,1,this,n3);

        fondo=new Alien(R.drawable.fondo, 1,1,this,fondo);


        navecool=new Alien(R.drawable.nave, 430,1380,this,navecool);
        balaUno=new Alien(R.drawable.bala,520,1920,this,balaUno);

        balaAlienUno=new Alien(R.drawable.balaalien,150,1,this,n1);
        balaAlienDos=new Alien(R.drawable.balaalien,505,1,this,n2);
        balaAlienTres=new Alien(R.drawable.balaalien,857,1,this,n3);

        fin=new Alien(R.drawable.perder,1,1,this,fin);
        ganar=new Alien(R.drawable.win,1,1,this,ganar);
        fin.hacerVisible(false);
        ganar.hacerVisible(false);


        n1.mover(9);
        n2.mover(10);
        n3.mover(8);

        balaUno.dispararUno();
        balaAlienUno.dispararAlien();
        balaAlienDos.dispararAlien();
        balaAlienTres.dispararAlien();

        punteroUno=null;
        punteroDos=null;
        punteroTres=null;

    }
    public void onDraw (Canvas c)
    {
        super.onDraw(c);

        Paint p =new Paint();

        fondo.pintar(c,p);
        balaAlienUno.pintar(c,p);
        n1.pintar(c,p);
        balaAlienDos.pintar(c,p);
        n2.pintar(c,p);
        balaAlienTres.pintar(c,p);
       n3.pintar(c,p);
        balaUno.pintar(c,p);
        navecool.pintar(c,p);
        fin.pintar(c,p);
        ganar.pintar(c,p);

        punteroUno=balaAlienUno;
        punteroDos=balaAlienDos;
        punteroTres=balaAlienTres;

        if(balaUno.colision(n1))
        {
            n1.hacerVisible(false);
            balaAlienUno.hacerVisible(false);
            cont=cont+100;
        }
        if (balaUno.colision(n2))
        {
            n2.hacerVisible(false);
            balaAlienDos.hacerVisible(false);
            cont=cont+100;
        }
        if(balaUno.colision(n3))
        {
            n3.hacerVisible(false);
            balaAlienTres.hacerVisible(false);
            cont=cont+100;
        }


        if(navecool.colision(n1))
        {
            navecool.hacerVisible(false);
            balaUno.hacerVisible(false);
            fin.hacerVisible(true);

        }
        if (navecool.colision(n2))
        {
            navecool.hacerVisible(false);
            balaUno.hacerVisible(false);
            fin.hacerVisible(true);

        }
        if(navecool.colision(n3))
        {
            navecool.hacerVisible(false);
            balaUno.hacerVisible(false);
            fin.hacerVisible(true);

        }

        if(navecool.colision(punteroUno))
        {
            navecool.hacerVisible(false);
            balaUno.hacerVisible(false);
            fin.hacerVisible(true);

        }

        if(navecool.colision(punteroDos))
        {
            navecool.hacerVisible(false);
            balaUno.hacerVisible(false);
            fin.hacerVisible(true);

        }
        if(navecool.colision(punteroTres))
        {
            navecool.hacerVisible(false);
            balaUno.hacerVisible(false);
            fin.hacerVisible(true);

        }

        if(cont==300)
        {
            n1.hacerVisible(false);
            n2.hacerVisible(false);
            n3.hacerVisible(false);
            balaUno.hacerVisible(false);
            ganar.hacerVisible(true);
        }

    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xtoque = e.getX();
        float ytoque= e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if(fin.estaEnArea(xtoque,ytoque))
                {
                    Intent otraventana=new Intent(obj, MainActivity.class);
                    obj.startActivity(otraventana);

                }
                if(ganar.estaEnArea(xtoque,ytoque))
                {
                    Intent otraventana=new Intent(obj, MainActivity.class);
                    obj.startActivity(otraventana);
                }

                break;

            case MotionEvent.ACTION_MOVE:

                //entraa si e.getAction esta moviendose

                if(navecool.estaEnArea(xtoque,ytoque))
                {
                    navecool.movernave(xtoque);
                    balaUno.movernave(xtoque);
                }


                break;

            case MotionEvent.ACTION_UP:
                //se ejecuta cuando quitas el dedo de la pantalla



                break;
        }
        invalidate();//Manda llamar a onDraw
        return true;
    }

}
