package com.example.cs125final;

import android.app.Activity;
import android.widget.ImageView;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import android.view.animation.Animation;

public class Animate extends Activity {
    ImageView left = GameActivity.leftMove;
    ImageView down = GameActivity.downMove;
    ImageView up = GameActivity.upMove;
    ImageView right = GameActivity.rightMove;

    ArrayList<String> direction = ChartProperties.direction;
    ArrayList<Double> beat = ChartProperties.beat;

    //    Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
    //    spaceshipImage.startAnimation(hyperspaceJumpAnimation);
    public void move(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }
}