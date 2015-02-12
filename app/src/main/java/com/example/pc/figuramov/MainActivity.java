package com.example.pc.figuramov;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    ImageView cuad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuad=(ImageView)findViewById(R.id.cuad);

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        float x=event.getX();
        float y=event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float mX=cuad.getX();
                float my=cuad.getY();
                if(x>mX){
                    mX+=5;
                }else{
                    mX-=5;
                }
                if(y>my +110){
                    my+=5;
                }else{
                    my-=5;
                }
                cuad.setX(mX);
                cuad.setY(my);
                break;
        }
        return false;

    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_S){
            cuad.setY(cuad.getY()+5);
            event.startTracking();
        }
        if(keyCode==KeyEvent.KEYCODE_W){
            cuad.setY(cuad.getY()-5);
            event.startTracking();
        }
        if(keyCode==KeyEvent.KEYCODE_D){
            cuad.setX(cuad.getX()+5);
            event.startTracking();
        }
        if(keyCode==KeyEvent.KEYCODE_A){
            cuad.setX(cuad.getX()-5);
            event.startTracking();
        }

        return false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
