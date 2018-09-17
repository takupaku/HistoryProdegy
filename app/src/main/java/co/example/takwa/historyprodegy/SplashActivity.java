package co.example.takwa.historyprodegy;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView textView;
    ImageView alb,man,bab,chop,dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        init();
        initFunc();


    }


    private void init() {
        textView=findViewById(R.id.textId);
        alb= findViewById(R.id.albart_Id);
        man= findViewById(R.id.mandelId);
         bab= findViewById(R.id.charlesId);
        chop= findViewById(R.id.chopinId);
        dal= findViewById(R.id.daltonId);


    }

    private void initFunc() {
        Typeface typeface= Typeface.createFromAsset(getAssets(),"go around the books.ttf");
        textView.setTypeface(typeface);
        textView.setText("Who started thsese brilliant invension?");


        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        man.setAnimation(animation);
        alb.setAnimation(animation);
        bab.setAnimation(animation);
        chop.setAnimation(animation);
        dal.setAnimation(animation);

        final Thread thread =  new Thread(){
            @Override
            public void run() {
                for(int i=0;i<=3;i++){

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //catch (Exception e){

                }
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();

            }

        };
        thread.start();

    }

}
