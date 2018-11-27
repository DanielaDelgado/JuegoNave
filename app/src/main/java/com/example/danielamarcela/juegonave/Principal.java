package com.example.danielamarcela.juegonave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Principal extends View {
    Impleprincipal fondo,boton;
    MainActivity obj,objm;
    MediaPlayer mp;

    public Principal(Context context) {
        super(context);
        fondo=new Impleprincipal(R.drawable.principal,1,1,this);
        boton=new Impleprincipal(R.drawable.start,50,60,this);
        obj=(MainActivity)context;
    }

    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p=new Paint();
        fondo.pintar(c,p);
        boton.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xp= e.getX();
        float yp= e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if (boton.estaEnArea(xp,yp))
                {
                    Intent otraventana=new Intent(obj, Main2Activity.class);
                    obj.startActivity(otraventana);
                }

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        invalidate();
        return true;
    }


}
