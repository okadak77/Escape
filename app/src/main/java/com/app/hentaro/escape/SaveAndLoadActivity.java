package com.app.hentaro.escape;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class SaveAndLoadActivity extends Activity {
    int saveflag_s; //SALアクティビティでのセーブフラグ
    int saveOrLoad_s; //0ならセーブ、1ならロード
    String saveMsg_s = ""; //SALアクティビティでのセーブメッセージ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_and_load);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent intent = getIntent();
        saveflag_s = intent.getIntExtra("saveflag", 1);
        saveOrLoad_s = intent.getIntExtra("saveOrLoad", 1);
        saveMsg_s = intent.getStringExtra("saveMsg");


        TextView slMenu = (TextView) findViewById(R.id.slMenu); //セーブ・ロード画面　メニュー文字　取得
        final TextView[] savedata = new TextView[10]; //メニューそれぞれのボタンを取得
        savedata[0] = (TextView) findViewById(R.id.savedata0);
        savedata[1] = (TextView) findViewById(R.id.savedata1);
        savedata[2] = (TextView) findViewById(R.id.savedata2);
        savedata[3] = (TextView) findViewById(R.id.savedata3);
        savedata[4] = (TextView) findViewById(R.id.savedata4);
        savedata[5] = (TextView) findViewById(R.id.savedata5);
        savedata[6] = (TextView) findViewById(R.id.savedata6);
        savedata[7] = (TextView) findViewById(R.id.savedata7);
        savedata[8] = (TextView) findViewById(R.id.savedata8);
        savedata[9] = (TextView) findViewById(R.id.savedata9);

        slMenu.setText(saveMsg_s);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (saveOrLoad_s == 0) { //セーブ時は以下を実行
                    if (v == savedata[0]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save00",saveflag_s);
                        editor.commit();
                        savedata[0].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[1]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save01",saveflag_s);
                        editor.commit();
                        savedata[1].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[2]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save02",saveflag_s);
                        editor.commit();
                        savedata[2].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[3]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save03",saveflag_s);
                        editor.commit();
                        savedata[3].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[4]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save04",saveflag_s);
                        editor.commit();
                        savedata[4].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[5]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save05",saveflag_s);
                        editor.commit();
                        savedata[5].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[6]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save06",saveflag_s);
                        editor.commit();
                        savedata[6].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[7]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save07",saveflag_s);
                        editor.commit();
                        savedata[7].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[8]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save08",saveflag_s);
                        editor.commit();
                        savedata[8].setText(String.valueOf(saveflag_s));
                        finish();
                    }else if (v == savedata[9]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("save09",saveflag_s);
                        editor.commit();
                        savedata[9].setText(String.valueOf(saveflag_s));
                        finish();
                    }
                } else if (saveOrLoad_s == 1) { //ロード時は以下を実行
                    if (v == savedata[0]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save00",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[1]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save01",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[2]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save02",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[3]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save03",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[4]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save04",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[5]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save05",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[6]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save06",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[7]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save07",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[8]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save08",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }else if (v == savedata[9]){
                        SharedPreferences sp = getSharedPreferences("savedata", Context.MODE_PRIVATE);
                        saveflag_s = sp.getInt("save09",1);
                        Intent intent1 = new Intent();
                        intent1.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                        intent1.putExtra("saveflag", saveflag_s);
                        finish();
                        startActivity(intent1);
                    }
                }

            }
        };
        for (int i = 0; i < 10; i++) {
            savedata[i].setOnClickListener(cl);
        }
    }

    public void onResume(){
        super.onResume();
        TextView slMenu = (TextView) findViewById(R.id.slMenu); //セーブ・ロード画面　メニュー文字　取得
        final TextView[] savedata = new TextView[10]; //メニューそれぞれのボタンを取得
        savedata[0] = (TextView) findViewById(R.id.savedata0);
        savedata[1] = (TextView) findViewById(R.id.savedata1);
        savedata[2] = (TextView) findViewById(R.id.savedata2);
        savedata[3] = (TextView) findViewById(R.id.savedata3);
        savedata[4] = (TextView) findViewById(R.id.savedata4);
        savedata[5] = (TextView) findViewById(R.id.savedata5);
        savedata[6] = (TextView) findViewById(R.id.savedata6);
        savedata[7] = (TextView) findViewById(R.id.savedata7);
        savedata[8] = (TextView) findViewById(R.id.savedata8);
        savedata[9] = (TextView) findViewById(R.id.savedata9);

        SharedPreferences sp = getSharedPreferences("savedata",Context.MODE_PRIVATE);
        savedata[0].setText(String.valueOf(sp.getInt("save00",1)));
        savedata[1].setText(String.valueOf(sp.getInt("save01",1)));
        savedata[2].setText(String.valueOf(sp.getInt("save02",1)));
        savedata[3].setText(String.valueOf(sp.getInt("save03",1)));
        savedata[4].setText(String.valueOf(sp.getInt("save04",1)));
        savedata[5].setText(String.valueOf(sp.getInt("save05",1)));
        savedata[6].setText(String.valueOf(sp.getInt("save06",1)));
        savedata[7].setText(String.valueOf(sp.getInt("save07",1)));
        savedata[8].setText(String.valueOf(sp.getInt("save08",1)));
        savedata[9].setText(String.valueOf(sp.getInt("save09",1)));
    }
}
