package com.app.hentaro.escape;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    int saveOrLoad_m; //0ならセーブ、1ならロード
    String saveMsg_m = "ロードしたい場面を選んでください"; //メインアクティビティでのセーブメッセージ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageButton button = (ImageButton)findViewById(R.id.button);
        ImageButton button2 = (ImageButton)findViewById(R.id.button2);

        //ゲームスタート
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.GameActivity");
                startActivity(intent);
            }
        });

        //ロード画面へ
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOrLoad_m = 1;
                Intent intent = new Intent();
                intent.setClassName("com.app.hentaro.escape","com.app.hentaro.escape.SaveAndLoadActivity");
                intent.putExtra("saveMsg",saveMsg_m);
                intent.putExtra("saveOrLoad",saveOrLoad_m);
                startActivity(intent);
            }
        });
    }
}
