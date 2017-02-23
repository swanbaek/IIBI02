package my.com.my24diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by admin on 2017-02-21.
 */

public class Top {
    AppCompatActivity act;
    ImageButton btn1,btn2,btn3,btn4;
    Intent intent;
    static String msg;
    public Top(AppCompatActivity activity){
        this.act=activity;
        btn1=(ImageButton)act.findViewById(R.id.imageButton);
        btn2=(ImageButton)act.findViewById(R.id.imageButton2);
        btn3=(ImageButton)act.findViewById(R.id.imageButton3);
        btn4=(ImageButton)act.findViewById(R.id.imageButton4);

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);


    }//생성자--------------------
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            act.finish();
            if(v==btn1){//일기쓰기

                intent=new Intent(act,MyDiaryWriteActivity.class);
                if(msg!=null && msg.length()==8){
                    intent.putExtra("msg", msg);
                }else{
                    Toast.makeText(act,"날짜를 먼저 선택하세요",Toast.LENGTH_SHORT)
                            .show();
                    act.onBackPressed();
                }
            }else if(v==btn2){//일기 목록
                intent=new Intent(act,MyDiaryListActivity.class);
            }else if(v==btn3){
            }else if(v==btn4){//HOME
                intent=new Intent(act,MyDiaryActivity.class);
            }

            act.startActivity(intent);

        }
    };

}
