package my.com.my24diary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by kodica04 on 2017-02-20.
 */

public class MyDiaryActivity extends AppCompatActivity {


    CalendarView calView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //top.xml의 버튼을 참조하고 해당 버튼에 대한 이벤트 처리를 하는
        //클래스//////////////////////
        Top top=new Top(this);
        //////////////////////////////
        calView=(CalendarView)findViewById(R.id.calendarView);
        //캘린더뷰에서 선택한 값 얻기
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view,
                                            int year, int month, int day) {
                StringBuilder buf=new StringBuilder();
                buf.append(year);
                String str=(month<10)?"0"+(month+1):String.valueOf(month+1);
                buf.append(str);
                str=(day<10)?"0"+day:String.valueOf(day);
                buf.append(str);
                Top.msg=buf.toString();
                if(Top.msg==null||Top.msg.length()!=8){
                    Toast.makeText(MyDiaryActivity.this,
                            "날짜를 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(MyDiaryActivity.this,
                        Top.msg,Toast.LENGTH_SHORT).show();

            }
        });

    }




}
