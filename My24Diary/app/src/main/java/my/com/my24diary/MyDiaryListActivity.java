package my.com.my24diary;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by kodica04 on 2017-02-20.
 */

public class MyDiaryListActivity extends AppCompatActivity{
    final String dir="/sdcard/MyDiary";
    String[] flist;
    ListView listView;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.diary_list);
        ////////////////////////
        Top top=new Top(this);
        ////////////////////////
        listView=(ListView)findViewById(R.id.listView);

        //sdcard의 파일 목록 얻기
       flist=getFileList();

        ArrayAdapter<String>  adapter
                =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,flist);

        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //리스트뷰의 항목을 선택했을 때 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                //읽을 파일명 얻기
                if(flist!=null) {
                    //String filename =flist[position];
                    String filename=listView.getItemAtPosition(position).toString();
                    String str=readFile(filename);

                    Log.i("MyLog","파일 내용========:  "+str);
                    showDiaryContent(str, filename);
                }

            }
        });

    }//onCreate()-----------------

    public void showDiaryContent(String content, String filename){
        View cv=(View)View.inflate(this,R.layout.diary_content,null);

        TextView dtxtDate=(TextView)cv.findViewById(R.id.dtxtDate);
        EditText deditContent=(EditText)cv.findViewById(R.id.deidtContent);

        dtxtDate.setText(filename);
        deditContent.setText(content);

        AlertDialog.Builder dial=new AlertDialog.Builder(this);
        dial.setTitle("MyDiary Content");
        dial.setView(cv);
        dial.setIcon(R.drawable.t02);
        dial.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              //  dial.dismiss();
            }
        });
        dial.show();



    }


    public String readFile(String filename){
        File file=new File(dir+"/"+filename);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data=new byte[1024];
            int n=0;
            String content="";
            while((n=fis.read(data))!=-1){
                String str=new String(data,0,n);
                content+=str;
            }
            return content;
        }catch (Exception e){
            e.printStackTrace();
            return filename+" 파일이 존재하지 않아요";
        }
    }

    public String[] getFileList(){
        File file=new File(dir);
        String[] flist=file.list();//디렉토리의 파일목록 반환
        return flist;
    }


}
