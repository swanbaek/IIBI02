package my.com.my24diary;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by admin on 2017-02-21.
 */

public class MyDiaryWriteActivity extends AppCompatActivity {
    TextView txtDate;
    EditText editTitle, editContent;
    Button btSave, btClear;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_write);
        Top top=new Top(this);

        txtDate=(TextView)findViewById(R.id.txtDate);
        editTitle=(EditText)findViewById(R.id.editTitle);
        editContent=(EditText)findViewById(R.id.editContent);
        btSave=(Button)findViewById(R.id.btSave);
        btClear=(Button)findViewById(R.id.btClear);

        Intent intent=this.getIntent();
        String msg=intent.getStringExtra("msg");
        String yy="",mm="", dd="";
        //20170121  ==> yy=>2017 mm=> 01  dd=>21
        if(msg!=null&& msg.length()==8){
            yy=msg.substring(0,4);
            mm=msg.substring(4,6);
            dd=msg.substring(6);
        }
        txtDate.setText(yy+"년"+mm+"월"+dd+"일");

        btSave.setOnClickListener(listener);
        btClear.setOnClickListener(listener);

    }//onCreate()--------------

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v==btClear){
                editTitle.setText("");
                editContent.setText("");
            }else if(v==btSave){
                saveFile(txtDate.getText()+".txt");
            }
        }
    };

    //AndroidManifest.xml에 Permission주어야 함
    //<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

    public void saveFile(String filename){
        //SD카드에 저장할 경로
        String dir="/sdcard/MyDiary";
        File fdir=new File(dir);
        if(!fdir.exists()){
            fdir.mkdirs();//MyDiary디렉토리 생성
        }

        File file=new File(dir+"/"+filename);
        //권한 요청 메소드 호출///////////
        goCheckFileWritePermission();
        //////////////////////////////
        try {
            FileOutputStream fos=new FileOutputStream(file,true);
            PrintWriter pw=new PrintWriter(fos,true);
            String content=editContent.getText().toString();//일기내용
            pw.println(content);
            pw.close(); fos.close();
            Toast.makeText(this,filename+"에 쓰기 완료",Toast.LENGTH_SHORT)
                    .show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }//--------------------------------








    private void goCheckFileWritePermission() {
        //AndroidManifest.xml에 permission등록해야함
//    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //버전이 마시멜로우 이상인지 체크

            int permitNum = ActivityCompat.checkSelfPermission(MyDiaryWriteActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permitNum == PackageManager.PERMISSION_DENIED) {
                Log.i("MyLog","Permission 거부됨");
                // 사용자가 CALL_PHONE 권한을 거부한 적이 있는지 확인한다.
                //거부한 적이 있다면 단말기의 전화걸기 권한을 허용할 것인지 묻는다.
                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder dialog
                            = new AlertDialog.Builder(MyDiaryWriteActivity.this);
                    dialog.setTitle("권한이 필요합니다.")
                            .setMessage("이 기능을 사용하기 위해서는 단말기의 \"sdcard쓰기\" 권한이 필요합니다. 계속 하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    /** * 새로운 인스턴스(onClickListener)를 생성했기 때문에
                                     * * 버전체크를 다시 해준다. */

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        //CALL_PHONE 권한을 Android OS에 요청한다.
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                                    }
                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MyDiaryWriteActivity.this,
                                            "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create().show();
                }
                // 최초로 권한을 요청할 때
                else { // CALL_PHONE 권한을 Android OS에 요청한다.
                    Log.i("MyLog","최초로 권한 요청1 Permission");
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                }

            }else{
                Log.i("MyLog","최초로 권한 요청2 Permission");
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
            }
        }
    }


}
