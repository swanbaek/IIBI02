package my.com.my24diary;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class My24DiaryMainActivity extends AppCompatActivity {

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        imgView=(ImageView)findViewById(R.id.imageView);
        //이미지 뷰에 투명 애니메이션을 적용해 보자.

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.tween);
                /*AnimationUtils.loadAnimation(this, R.anim.alpha);*/
                                //res/ani/alpha.xml적용
        imgView.startAnimation(animation);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDiary();
            }
        });

        //5 seconds later move to MyDirayActivity
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                goDiary();
            }
        }, 4000);
    }//onCreate()-------------

    public void goDiary(){
        Intent intent=new Intent(My24DiaryMainActivity.this, MyDiaryActivity.class);
        startActivity(intent);
    }
}
