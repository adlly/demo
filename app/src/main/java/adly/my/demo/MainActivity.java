package adly.my.demo;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText psw;
    private CheckBox checkBox;
    private Button btn;
    private File file;
    private TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        psw = (EditText) findViewById(R.id.psw);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        btn = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.text);
//        /data/data/adly.my.demo
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            file = new File(Environment.getExternalStorageDirectory(),"ww.txt");
        }else {
//            file = new File(getFilesDir(), "ww.txt");
        }



        Log.e(MainActivity.class.getSimpleName(), file.getAbsolutePath());
        initView();

        readView();


    }

    private void readView(){

        SharedPreferences  sharedPreferences = getSharedPreferences("hh",MODE_PRIVATE);
       String p1 = sharedPreferences.getString("name","");
        String p2 = sharedPreferences.getString("psw","");
        name.setText(p1);
        psw.setText(p2);


//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
////            String msg = bufferedReader.readLine();
////            Log.e(this.getClass().getSimpleName(), msg != null ? msg : "msg为空");
////            String[] s = msg.split("##");
////
////            if (s.length == 2) {
////                name.setText(s[s.length-2]);
////                psw.setText(s[s.length-1]);
////            }else {
////                Log.e(this.getClass().getSimpleName(), "数据不存在");
////            }
//            name.setText(bufferedReader.readLine());
//            psw.setText(bufferedReader.readLine());
//
//            fileInputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "file not found", Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
    }

    private void initView() {


    btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(checkBox.isChecked()){

            SharedPreferences  sharedPreferences = getSharedPreferences("hh",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name",name.getText().toString());
            editor.putString("psw",psw.getText().toString());
            editor.commit();
        }
    }
});



//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkBox.isChecked()) {
//                    //写文件
//
//                    try {
//                        FileOutputStream fileOutputStream = new FileOutputStream(file);
//                        String s = name.getText().toString() + "\n" + psw.getText().toString();
//                        fileOutputStream.write(s.getBytes());
//
//                        fileOutputStream.close();
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//                Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        File file1 = Environment.getExternalStorageDirectory();
//        StatFs statFs = new StatFs(file1.getAbsolutePath());
//        long blockCountLong;
//        long blockSizeLong;
//        long availableBlocksLong;
//        long freeBlocksLong;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            blockCountLong = statFs.getBlockCountLong();
//            blockSizeLong = statFs.getBlockSizeLong();
//            availableBlocksLong = statFs.getAvailableBlocksLong();
//            freeBlocksLong = statFs.getFreeBlocksLong();
//
//
//        }else{
//            blockCountLong = statFs.getBlockCount();
//            blockSizeLong = statFs.getBlockSize();
//            availableBlocksLong = statFs.getAvailableBlocks();
//            freeBlocksLong = statFs.getFreeBlocks();
//
//        }
//
//        long l = blockSizeLong * availableBlocksLong;
//        String s = Formatter.formatFileSize(this, l);
//
////        String s1 = Formatter.formatFileSize(this, blockSizeLong * blockCountLong);
//
//        text.setText(s + "\n" + Formatter.formatFileSize(this, blockSizeLong * blockCountLong)
//        + "\n" + Formatter.formatFileSize(this, blockSizeLong * (blockCountLong - freeBlocksLong))
//        + "\n" + Formatter.formatFileSize(this, freeBlocksLong * blockSizeLong));
//

    }


}
