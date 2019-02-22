package mx.itesm.lab4gestures;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import mx.itesm.lab4gestures.Main2Activity;
import mx.itesm.lab4gestures.Main4Activity;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{


    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDetector = new GestureDetectorCompat(this,this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public void onLongPress(MotionEvent event) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) { // PREVIOUS
                        Toast.makeText(getApplicationContext(), "Swipe Right." , Toast.LENGTH_SHORT).show();
                        Intent previous = new Intent(MainActivity.this, Main4Activity.class);
                        startActivity( previous );
                    } else {  //NEXT
                        Toast.makeText(getApplicationContext(), "Swipe Left." , Toast.LENGTH_SHORT).show();
                        Intent next = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity( next );
                    }
                    result = true;
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return result;

    }

}
