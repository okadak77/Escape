package com.app.hentaro.escape;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class GameActivity extends Activity {
    //int textflag = 341; //デバッグ用テキストフラグ
    int textflag = 1; //テキストの進行を管理する変数
    int saveflag = 1; //セーブ用のテキストフラグ
    int saveOrLoad_g; //0ならセーブ、1ならロード
    int logflag = 0; //0ならログ画面へ、1ならゲーム画面へ
    int logOnce = 0; //0ならログ取得、1ならログ取得せず
    int increment_num = 10;//インクリメントメソッドへの引数用
    int serihu_flag = 0;//セリフアニメーションの状態を判定　０ならアニメーション実行、１ならアニメーション終了させる
    int i = 0;//アニメーションif分で利用
    private static int TIMEOUT_MESSAGE = 1;
    private static int interval = 1;//文字の表示速度
    String mix = ""; //テキストを合体させてから表示させるときに使う
    String saveMsg = "セーブしたい箇所を選択してください";
    String log = "";
    String serihu = "";//セリフアニメーションのためにセリフ文字列を一時的に格納
    String put_word = "";//文字列を一文字ずつ格納
    String put_text = "";//文字列を足してゆく変数
    MediaPlayer p;// 再生の準備 // 音楽再生解説のURL：http://hakoniwadesign.com/?p=4453

    //タップしてテキストを進行
    public void tapComment() {
        TextView textView1 = (TextView) findViewById(R.id.tapComment); //コメントのIDを取得
        TextView textView2 = (TextView) findViewById(R.id.tapComment2); //コメント（手紙）のIDを取得
        ImageView waku = (ImageView) findViewById(R.id.imageView); //コメント枠のIDを取得
        AlphaAnimation animation_alpha = new AlphaAnimation(1, 0);
        animation_alpha.setDuration(1000);
        animation_alpha.setRepeatCount(Animation.INFINITE);
        animation_alpha.setRepeatMode(Animation.REVERSE);

        switch (textflag) {
            case 1:
                haikeiAndChara();
                textView1.setText(R.string.text001);
                log += getString(R.string.text001);
                saveflag = textflag;
                increment(10);
                break;
            case 11:
                haikeiAndChara(); //背景やキャラの立ち位置を取得
                serihu = getString(R.string.text011); //serihu変数へセリフを代入
                if (logOnce == 0){ //一回目のタップならログを保存する
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text011) + "」";
                }
                animeStrings(); //文字列を徐々に表示するメソッド
                break;
            case 21:
                haikeiAndChara();
                serihu = getString(R.string.text021);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text021) + "」";
                }
                animeStrings();
                break;
            case 31:
                haikeiAndChara();
                serihu = getString(R.string.text031);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text031) + "」";
                }
                animeStrings();
                break;
            case 41:
                haikeiAndChara();
                serihu = getString(R.string.text041);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text041) + "」";
                }
                animeStrings();
                break;
            case 51:
                haikeiAndChara();
                serihu = getString(R.string.text051);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text051) + "」";
                }
                animeStrings();
                break;
            case 61:
                haikeiAndChara();
                serihu = getString(R.string.text061);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text061);
                }
                animeStrings();
                break;
            case 71:
                haikeiAndChara();
                serihu = getString(R.string.text071);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text071);
                }
                animeStrings();
                break;
            case 81:
                haikeiAndChara();
                serihu = getString(R.string.text081);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text081);
                }
                animeStrings();
                break;
            case 91:
                haikeiAndChara();
                serihu = getString(R.string.text091);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text091);
                }
                animeStrings();
                break;
            case 101:
                haikeiAndChara();
                serihu = getString(R.string.text101);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text101);
                }
                animeStrings();
                break;
            case 111:
                haikeiAndChara();
                serihu = getString(R.string.text111);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text111);
                }
                animeStrings();
                break;
            case 121:
                haikeiAndChara();
                serihu = getString(R.string.text121);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text121);
                }
                animeStrings();
                break;
            case 131:
                haikeiAndChara();
                serihu = getString(R.string.text131);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text131);
                }
                animeStrings();
                break;
            case 141:
                haikeiAndChara();
                serihu = getString(R.string.text141);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.name_q) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text141) + "」";
                }
                animeStrings();
                break;
            case 151:
                haikeiAndChara();
                serihu = getString(R.string.text151);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text151);
                }
                animeStrings();
                break;
            case 161:
                haikeiAndChara();
                serihu = getString(R.string.text161);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text161) + "」";
                }
                animeStrings();
                break;
            case 171:
                haikeiAndChara();
                serihu = getString(R.string.text171);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text171) + "」";
                }
                animeStrings();
                break;
            case 181:
                haikeiAndChara();
                serihu = getString(R.string.text181);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text181) + "」";
                }
                animeStrings();
                break;
            case 191:
                haikeiAndChara();
                serihu = getString(R.string.text191);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text191) + "」";
                }
                animeStrings();
                break;
            case 201:
                haikeiAndChara();
                serihu = getString(R.string.text201);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text201);
                }
                animeStrings();
                break;
            case 211:
                haikeiAndChara();
                serihu = getString(R.string.text211);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text211);
                }
                animeStrings();
                break;
            case 221:
                haikeiAndChara();
                serihu = getString(R.string.text221);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text221) + "」";
                }
                animeStrings();
                break;
            case 231:
                haikeiAndChara();
                serihu = getString(R.string.text231);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text231);
                }
                animeStrings();
                break;
            case 241:
                haikeiAndChara();
                serihu = getString(R.string.text241);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text241) + "」";
                }
                animeStrings();
                break;
            case 251:
                haikeiAndChara();
                serihu = getString(R.string.text251);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text251) + "」";
                }
                animeStrings();
                break;
            case 261:
                haikeiAndChara();
                serihu = getString(R.string.text261);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text261) + "」";
                }
                animeStrings();
                break;
            case 271:
                haikeiAndChara();
                serihu = getString(R.string.text271);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text271) + "」";
                }
                animeStrings();
                break;
            case 281:
                haikeiAndChara();
                serihu = getString(R.string.text281);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text281);
                }
                animeStrings();
                break;
            case 291:
                haikeiAndChara();
                serihu = getString(R.string.text291);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text291) + "」";
                }
                animeStrings();
                break;
            case 301:
                haikeiAndChara();
                serihu = getString(R.string.text301);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text301) + "」";
                }
                animeStrings();
                break;
            case 311:
                haikeiAndChara();
                serihu = getString(R.string.text311);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text311) + "」";
                }
                animeStrings();
                break;
            case 321:
                haikeiAndChara();
                serihu = getString(R.string.text321);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text321);
                }
                animeStrings();
                break;
            case 331:
                haikeiAndChara();
                serihu = getString(R.string.text331);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text331) + "」";
                }
                animeStrings();
                break;
            case 341:
                haikeiAndChara();
                serihu = getString(R.string.text341);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text341) + "」";
                }
                animeStrings();
                break;
            case 351:
                haikeiAndChara();
                serihu = getString(R.string.text351);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text351) + "」";
                }
                animeStrings();
                break;
            case 361:
                haikeiAndChara();
                serihu = getString(R.string.text361);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text361) + "」";
                }
                animeStrings();
                break;
            case 371:
                haikeiAndChara();
                serihu = getString(R.string.text371);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text371);
                }
                animeStrings();
                break;
            case 381:
                haikeiAndChara();
                waku.setImageResource(R.drawable.comment_waku_full);
                textView1.setText(""); //テキスト消す
                textView2.setText(R.string.text381); //手紙枠側にテキスト表示
                log += getString(R.string.kaigyo2) + getString(R.string.text381);
                saveflag = textflag;
                increment(10);
                break;
            case 391:
                haikeiAndChara();
                mix = getString(R.string.text381); //文字列をmixに代入
                mix += getString(R.string.text391); //mixに文字列を連結
                textView2.setText(mix); //mixを表示
                log += getString(R.string.kaigyo1) + getString(R.string.text391);
                saveflag = textflag;
                increment(10);
                break;
            case 401:
                haikeiAndChara();
                mix += getString(R.string.text401);
                textView2.setText(mix);
                log += getString(R.string.kaigyo1) + getString(R.string.text401);
                saveflag = textflag;
                increment(10);
                break;
            case 411:
                haikeiAndChara();
                mix = ""; //mixの初期化
                mix += getString(R.string.text411);
                textView2.setText(mix);
                log += getString(R.string.kaigyo1) + getString(R.string.text411);
                saveflag = textflag;
                increment(10);
                break;
            case 421:
                haikeiAndChara();
                mix += getString(R.string.text421);
                textView2.setText(mix);
                log += getString(R.string.kaigyo1) + getString(R.string.text421);
                saveflag = textflag;
                increment(10);
                break;
            case 431:
                haikeiAndChara();
                mix += getString(R.string.text431);
                textView2.setText(mix);
                log += getString(R.string.kaigyo1) + getString(R.string.text431);
                saveflag = textflag;
                increment(10);
                break;
            case 441:
                haikeiAndChara();
                mix = "";
                mix += getString(R.string.text441);
                textView2.setText(mix);
                mix = "";
                log += getString(R.string.kaigyo1) + getString(R.string.text441);
                saveflag = textflag;
                increment(10);
                break;
            case 451:
                haikeiAndChara();
                textView2.setText("");
                waku.setImageResource(R.drawable.comment_waku);
                serihu = getString(R.string.text451);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text451) + "」";
                }
                animeStrings();
                break;
            case 461:
                haikeiAndChara();
                serihu = getString(R.string.text461);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text461) + "」";
                }
                animeStrings();
                break;
            case 471:
                haikeiAndChara();
                serihu = getString(R.string.text471);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text471) + "」";
                }
                animeStrings();
                break;
            case 481:
                haikeiAndChara();
                serihu = getString(R.string.text481);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.name_q) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text481) + "」";
                }
                animeStrings();
                break;
            case 491:
                haikeiAndChara();
                serihu = getString(R.string.text491);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text491) + "」";
                }
                animeStrings();
                break;
            case 501:
                haikeiAndChara();
                serihu = getString(R.string.text501);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text501);
                }
                animeStrings();
                break;
            case 511:
                haikeiAndChara();
                serihu = getString(R.string.text511);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.name_q) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text511) + "」";
                }
                animeStrings();
                break;
            case 521:
                haikeiAndChara();
                serihu = getString(R.string.text521);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text521) + "」";
                }
                animeStrings();
                break;
            case 531:
                haikeiAndChara();
                serihu = getString(R.string.text531);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.name_q) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text531) + "」";
                }
                animeStrings();
                break;
            case 541:
                haikeiAndChara();
                serihu = getString(R.string.text541);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text541);
                }
                animeStrings();
                break;
            case 551:
                haikeiAndChara();
                serihu = getString(R.string.text551);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text551) + "」";
                }
                animeStrings();
                break;
            case 561:
                haikeiAndChara();
                serihu = getString(R.string.text561);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text561);
                }
                animeStrings();
                break;
            case 571:
                haikeiAndChara();
                serihu = getString(R.string.text571);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text571);
                }
                animeStrings();
                break;
            case 581:
                haikeiAndChara();
                serihu = getString(R.string.text581);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text581);
                }
                animeStrings();
                break;
            case 591:
                haikeiAndChara();
                serihu = getString(R.string.text591);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text591) + "」";
                }
                animeStrings();
                break;
            case 601:
                haikeiAndChara();
                serihu = getString(R.string.text601);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text601) + "」";
                }
                animeStrings();
                break;
            case 611:
                haikeiAndChara();
                serihu = getString(R.string.text611);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text611) + "」";
                }
                animeStrings();
                break;
            case 621:
                haikeiAndChara();
                serihu = getString(R.string.text621);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text621) + "」";
                }
                animeStrings();
                break;
            case 631:
                haikeiAndChara();
                serihu = getString(R.string.text631);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text631) + "」";
                }
                animeStrings();
                break;
            case 641:
                haikeiAndChara();
                serihu = getString(R.string.text641);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text641) + "」";
                }
                animeStrings();
                break;
            case 651:
                haikeiAndChara();
                serihu = getString(R.string.text651);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text651) + "」";
                }
                animeStrings();
                break;
            case 661:
                haikeiAndChara();
                serihu = getString(R.string.text661);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text661) + "」";
                }
                animeStrings();
                break;
            case 671:
                haikeiAndChara();
                serihu = getString(R.string.text671);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text671) + "」";
                }
                animeStrings();
                break;
            case 681:
                haikeiAndChara();
                serihu = getString(R.string.text681);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text681) + "」";
                }
                animeStrings();
                break;
            case 691:
                haikeiAndChara();
                serihu = getString(R.string.text691);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text691) + "」";
                }
                animeStrings();
                break;
            case 701:
                haikeiAndChara();
                serihu = getString(R.string.text701);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text701) + "」";
                }
                animeStrings();
                break;
            case 711:
                haikeiAndChara();
                serihu = getString(R.string.text711);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text711) + "」";
                }
                animeStrings();
                break;
            case 721:
                haikeiAndChara();
                serihu = getString(R.string.text721);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text721) + "」";
                }
                animeStrings();
                break;
            case 731:
                haikeiAndChara();
                serihu = getString(R.string.text731);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text731) + "」";
                }
                animeStrings();
                break;
            case 741:
                haikeiAndChara();
                serihu = getString(R.string.text741);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text741);
                }
                animeStrings();
                break;
            case 751:
                haikeiAndChara();
                serihu = getString(R.string.text751);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text751);
                }
                animeStrings();
                break;
            case 761:
                haikeiAndChara();
                serihu = getString(R.string.text761);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text761) + "」";
                }
                animeStrings();
                break;
            case 771:
                haikeiAndChara();
                serihu = getString(R.string.text771);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text771);
                }
                animeStrings();
                break;
            case 781:
                haikeiAndChara();
                serihu = getString(R.string.text781);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.hiro) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text781) + "」";
                }
                animeStrings();
                break;
            case 791:
                haikeiAndChara();
                serihu = getString(R.string.text791);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.haruka) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text791) + "」";
                }
                animeStrings();
                break;
            case 801:
                haikeiAndChara();
                serihu = getString(R.string.text801);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.masato) + getString(R.string.kaigyo1)
                            + "「" + getString(R.string.text801) + "」";
                }
                animeStrings();
                break;
            case 811:
                haikeiAndChara();
                serihu = getString(R.string.text811);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text811);
                }
                animeStrings();
                break;
            case 821:
                haikeiAndChara();
                serihu = getString(R.string.text821);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text821);
                }
                animeStrings();
                break;
            case 831:
                haikeiAndChara();
                serihu = getString(R.string.text831);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + getString(R.string.text831);
                }
                animeStrings();
                break;
            case 841:
                haikeiAndChara();
                serihu = getString(R.string.text841);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text841) + "」";
                }
                animeStrings();
                break;
            case 851:
                haikeiAndChara();
                serihu = getString(R.string.text851);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text851) + "」";
                }
                animeStrings();
                break;
            case 861:
                haikeiAndChara();
                serihu = getString(R.string.text861);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text861) + "」";
                }
                animeStrings();
                break;
            case 871:
                haikeiAndChara();
                serihu = getString(R.string.text871);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text871) + "」";
                }
                animeStrings();
                break;
            case 881:
                haikeiAndChara();
                serihu = getString(R.string.text881);
                if (logOnce == 0){
                    log += getString(R.string.kaigyo2) + "「" + getString(R.string.text881) + "」";
                }
                animeStrings();
                break;
            case 891:
                haikeiAndChara();
                serihu = getString(R.string.text891);
                animeStrings();
                break;
            case 901:
                haikeiAndChara();
                serihu = getString(R.string.text901);
                animeStrings();
                break;
            case 911:
                haikeiAndChara();
                serihu = getString(R.string.text911);
                animeStrings();
                break;
            case 921:
                haikeiAndChara();
                serihu = getString(R.string.text921);
                animeStrings();
                break;
            case 931:
                haikeiAndChara();
                serihu = getString(R.string.text931);
                animeStrings();
                break;
            case 941:
                haikeiAndChara();
                serihu = getString(R.string.text941);
                animeStrings();
                break;
            case 951:
                haikeiAndChara();
                serihu = getString(R.string.text951);
                animeStrings();
                break;
            case 961:
                haikeiAndChara();
                serihu = getString(R.string.text961);
                animeStrings();
                break;
            case 971:
                haikeiAndChara();
                serihu = getString(R.string.text971);
                animeStrings();
                break;
            case 981:
                haikeiAndChara();
                serihu = getString(R.string.text981);
                animeStrings();
                break;
            case 991:
                haikeiAndChara();
                serihu = getString(R.string.text991);
                animeStrings();
                break;
            case 1001:
                haikeiAndChara();
                serihu = getString(R.string.text1001);
                animeStrings();
                break;
            case 1011:
                haikeiAndChara();
                serihu = getString(R.string.text1011);
                animeStrings();
                break;
            case 1021:
                haikeiAndChara();
                serihu = getString(R.string.text1021);
                animeStrings();
                break;
            case 1031:
                haikeiAndChara();
                serihu = getString(R.string.text1031);
                animeStrings();
                break;
            case 1041:
                haikeiAndChara();
                serihu = getString(R.string.text1041);
                animeStrings();
                break;
            case 1051:
                haikeiAndChara();
                serihu = getString(R.string.text1051);
                animeStrings();
                break;
            case 1061:
                haikeiAndChara();
                serihu = getString(R.string.text1061);
                animeStrings();
                break;
            case 1071:
                haikeiAndChara();
                serihu = getString(R.string.text1071);
                animeStrings();
                break;
            case 1081:
                haikeiAndChara();
                serihu = getString(R.string.text1081);
                animeStrings();
                break;
            case 1091:
                haikeiAndChara();
                serihu = getString(R.string.text1091);
                animeStrings();
                break;
            case 1101:
                haikeiAndChara();
                serihu = getString(R.string.text1101);
                animeStrings();
                break;
            case 1111:
                haikeiAndChara();
                serihu = getString(R.string.text1111);
                animeStrings();
                break;
            case 1121:
                haikeiAndChara();
                serihu = getString(R.string.text1121);
                animeStrings();
                break;
            case 1131:
                haikeiAndChara();
                serihu = getString(R.string.text1131);
                animeStrings();
                break;
            case 1141:
                haikeiAndChara();
                serihu = getString(R.string.text1141);
                animeStrings();
                break;
            case 1151:
                haikeiAndChara();
                serihu = getString(R.string.text1151);
                animeStrings();
                break;
            case 1161:
                haikeiAndChara();
                serihu = getString(R.string.text1161);
                animeStrings();
                break;
            case 1171:
                haikeiAndChara();
                serihu = getString(R.string.text1171);
                animeStrings();
                break;
            case 1181:
                haikeiAndChara();
                serihu = getString(R.string.text1181);
                animeStrings();
                break;
            case 1191:
                haikeiAndChara();
                serihu = getString(R.string.text1191);
                animeStrings();
                break;
            case 1201:
                haikeiAndChara();
                serihu = getString(R.string.text1201);
                animeStrings();
                break;
            case 1211:
                haikeiAndChara();
                serihu = getString(R.string.text1211);
                animeStrings();
                break;
            case 1221:
                haikeiAndChara();
                serihu = getString(R.string.text1221);
                animeStrings();
                break;
            case 1231:
                haikeiAndChara();
                serihu = getString(R.string.text1231);
                animeStrings();
                break;
            case 1241:
                haikeiAndChara();
                serihu = getString(R.string.text1241);
                animeStrings();
                break;
            case 1251:
                haikeiAndChara();
                serihu = getString(R.string.text1251);
                animeStrings();
                break;
            case 1261:
                haikeiAndChara();
                serihu = getString(R.string.text1261);
                animeStrings();
                break;
            case 1271:
                haikeiAndChara();
                serihu = getString(R.string.text1271);
                animeStrings();
                break;
            case 1281:
                haikeiAndChara();
                serihu = getString(R.string.text1281);
                animeStrings();
                break;
            case 1291:
                haikeiAndChara();
                serihu = getString(R.string.text1291);
                animeStrings();
                break;
            case 1301:
                haikeiAndChara();
                serihu = getString(R.string.text1301);
                animeStrings();
                break;
            case 1311:
                haikeiAndChara();
                serihu = getString(R.string.text1311);
                animeStrings();
                break;
            case 1321:
                haikeiAndChara();
                serihu = getString(R.string.text1321);
                animeStrings();
                break;
            case 1331:
                haikeiAndChara();
                serihu = getString(R.string.text1331);
                animeStrings();
                break;
            case 1341:
                haikeiAndChara();
                serihu = getString(R.string.text1341);
                animeStrings();
                break;
            case 1351:
                haikeiAndChara();
                serihu = getString(R.string.text1351);
                animeStrings();
                break;
            case 1361:
                haikeiAndChara();
                serihu = getString(R.string.text1361);
                animeStrings();
                break;
            case 1371:
                haikeiAndChara();
                serihu = getString(R.string.text1371);
                animeStrings();
                break;
            case 1381:
                haikeiAndChara();
                serihu = getString(R.string.text1381);
                animeStrings();
                break;
            case 1391:
                haikeiAndChara();
                serihu = getString(R.string.text1391);
                animeStrings();
                break;
            case 1401:
                haikeiAndChara();
                serihu = getString(R.string.text1401);
                animeStrings();
                break;
            case 1411:
                haikeiAndChara();
                serihu = getString(R.string.text1411);
                animeStrings();
                break;
            case 1421:
                haikeiAndChara();
                serihu = getString(R.string.text1421);
                animeStrings();
                break;
            case 1431:
                haikeiAndChara();
                serihu = getString(R.string.text1431);
                animeStrings();
                break;
            case 1441:
                haikeiAndChara();
                serihu = getString(R.string.text1441);
                animeStrings();
                break;
            case 1451:
                haikeiAndChara();
                serihu = getString(R.string.text1451);
                animeStrings();
                break;
            case 1461:
                haikeiAndChara();
                serihu = getString(R.string.text1461);
                animeStrings();
                break;
            case 1471:
                haikeiAndChara();
                serihu = getString(R.string.text1471);
                animeStrings();
                break;
            case 1481:
                haikeiAndChara();
                serihu = getString(R.string.text1481);
                animeStrings();
                break;
            case 1491:
                haikeiAndChara();
                serihu = getString(R.string.text1491);
                animeStrings();
                break;
            case 1501:
                haikeiAndChara();
                serihu = getString(R.string.text1501);
                animeStrings();
                break;
            case 1511:
                haikeiAndChara();
                serihu = getString(R.string.text1511);
                animeStrings();
                break;
            case 1521:
                haikeiAndChara();
                serihu = getString(R.string.text1521);
                animeStrings();
                break;
            case 1531:
                haikeiAndChara();
                serihu = getString(R.string.text1531);
                animeStrings();
                break;
            case 1541:
                haikeiAndChara();
                serihu = getString(R.string.text1541);
                animeStrings();
                break;
            case 1551:
                haikeiAndChara();
                serihu = getString(R.string.text1551);
                animeStrings();
                break;
            case 1561:
                haikeiAndChara();
                serihu = getString(R.string.text1561);
                animeStrings();
                break;
            case 1571:
                haikeiAndChara();
                serihu = getString(R.string.text1571);
                animeStrings();
                break;
            case 1581:
                haikeiAndChara();
                serihu = getString(R.string.text1581);
                animeStrings();
                break;
            case 1591:
                haikeiAndChara();
                serihu = getString(R.string.text1591);
                animeStrings();
                break;
            case 1601:
                haikeiAndChara();
                serihu = getString(R.string.text1601);
                animeStrings();
                break;
            case 1611:
                haikeiAndChara();
                serihu = getString(R.string.text1611);
                animeStrings();
                break;
            case 1621:
                haikeiAndChara();
                serihu = getString(R.string.text1621);
                animeStrings();
                break;
            case 1631:
                haikeiAndChara();
                serihu = getString(R.string.text1631);
                animeStrings();
                break;
            case 1641:
                haikeiAndChara();
                serihu = getString(R.string.text1641);
                animeStrings();
                break;
            case 1651:
                haikeiAndChara();
                serihu = getString(R.string.text1651);
                animeStrings();
                break;
            case 1661:
                haikeiAndChara();
                serihu = getString(R.string.text1661);
                animeStrings();
                break;
            case 1671:
                haikeiAndChara();
                serihu = getString(R.string.text1671);
                animeStrings();
                break;
            case 1681:
                haikeiAndChara();
                serihu = getString(R.string.text1681);
                animeStrings();
                break;
            case 1691:
                haikeiAndChara();
                serihu = getString(R.string.text1691);
                animeStrings();
                break;
            case 1701:
                haikeiAndChara();
                serihu = getString(R.string.text1701);
                animeStrings();
                break;
            case 1711:
                haikeiAndChara();
                serihu = getString(R.string.text1711);
                animeStrings();
                break;
            case 1721:
                haikeiAndChara();
                serihu = getString(R.string.text1721);
                animeStrings();
                break;
            case 1731:
                haikeiAndChara();
                serihu = getString(R.string.text1731);
                animeStrings();
                break;
            case 1741:
                haikeiAndChara();
                serihu = getString(R.string.text1741);
                animeStrings();
                break;
            case 1751:
                haikeiAndChara();
                serihu = getString(R.string.text1751);
                animeStrings();
                break;
            case 1761:
                haikeiAndChara();
                serihu = getString(R.string.text1761);
                animeStrings();
                break;
            case 1771:
                haikeiAndChara();
                serihu = getString(R.string.text1771);
                animeStrings();
                break;
            case 1781:
                haikeiAndChara();
                serihu = getString(R.string.text1781);
                animeStrings();
                break;
            case 1791:
                haikeiAndChara();
                serihu = getString(R.string.text1791);
                animeStrings();
                break;
            case 1801:
                haikeiAndChara();
                serihu = getString(R.string.text1801);
                animeStrings();
                break;
            case 1811:
                haikeiAndChara();
                serihu = getString(R.string.text1811);
                animeStrings();
                break;
            case 1821:
                haikeiAndChara();
                serihu = getString(R.string.text1821);
                animeStrings();
                break;
            case 1831:
                haikeiAndChara();
                serihu = getString(R.string.text1831);
                animeStrings();
                break;
            case 1841:
                haikeiAndChara();
                serihu = getString(R.string.text1841);
                animeStrings();
                break;
            case 1851:
                haikeiAndChara();
                serihu = getString(R.string.text1851);
                animeStrings();
                break;
            case 1861:
                haikeiAndChara();
                serihu = getString(R.string.text1861);
                animeStrings();
                break;
            case 1871:
                haikeiAndChara();
                serihu = getString(R.string.text1871);
                animeStrings();
                break;
            case 1881:
                haikeiAndChara();
                serihu = getString(R.string.text1881);
                animeStrings();
                break;
            case 1891:
                haikeiAndChara();
                serihu = getString(R.string.text1891);
                animeStrings();
                break;
            case 1901:
                haikeiAndChara();
                serihu = getString(R.string.text1901);
                animeStrings();
                break;
            case 1911:
                haikeiAndChara();
                serihu = getString(R.string.text1911);
                animeStrings();
                break;
            case 1921:
                haikeiAndChara();
                serihu = getString(R.string.text1921);
                animeStrings();
                break;
            case 1931:
                haikeiAndChara();
                serihu = getString(R.string.text1931);
                animeStrings();
                break;
            case 1941:
                haikeiAndChara();
                serihu = getString(R.string.text1941);
                animeStrings();
                break;
            case 1951:
                haikeiAndChara();
                serihu = getString(R.string.text1951);
                animeStrings();
                break;
            case 1961:
                haikeiAndChara();
                serihu = getString(R.string.text1961);
                animeStrings();
                break;
            case 1971:
                haikeiAndChara();
                serihu = getString(R.string.text1971);
                animeStrings();
                break;
            case 1981:
                haikeiAndChara();
                serihu = getString(R.string.text1981);
                animeStrings();
                break;
            case 1991:
                haikeiAndChara();
                serihu = getString(R.string.text1991);
                animeStrings();
                break;
            case 2001:
                haikeiAndChara();
                serihu = getString(R.string.text2001);
                animeStrings();
                break;
            case 2011:
                haikeiAndChara();
                serihu = getString(R.string.text2011);
                animeStrings();
                break;
            case 2021:
                haikeiAndChara();
                serihu = getString(R.string.text2021);
                animeStrings();
                break;
            case 2031:
                haikeiAndChara();
                serihu = getString(R.string.text2031);
                animeStrings();
                break;
            case 2041:
                haikeiAndChara();
                serihu = getString(R.string.text2041);
                animeStrings();
                break;
            case 2051:
                haikeiAndChara();
                serihu = getString(R.string.text2051);
                animeStrings();
                break;
            case 2061:
                haikeiAndChara();
                serihu = getString(R.string.text2061);
                animeStrings();
                break;
            case 2071:
                haikeiAndChara();
                serihu = getString(R.string.text2071);
                animeStrings();
                break;
            case 2081:
                haikeiAndChara();
                serihu = getString(R.string.text2081);
                animeStrings();
                break;
            case 2091:
                haikeiAndChara();
                serihu = getString(R.string.text2091);
                animeStrings();
                break;
            case 2101:
                haikeiAndChara();
                serihu = getString(R.string.text2101);
                animeStrings();
                break;
            case 2111:
                haikeiAndChara();
                serihu = getString(R.string.text2111);
                animeStrings();
                break;
            case 2121:
                haikeiAndChara();
                serihu = getString(R.string.text2121);
                animeStrings();
                break;
            case 2131:
                haikeiAndChara();
                serihu = getString(R.string.text2131);
                animeStrings();
                break;
            case 2141:
                haikeiAndChara();
                serihu = getString(R.string.text2141);
                animeStrings();
                break;
            case 2151:
                haikeiAndChara();
                serihu = getString(R.string.text2151);
                animeStrings();
                break;
            case 2161:
                haikeiAndChara();
                serihu = getString(R.string.text2161);
                animeStrings();
                break;
            case 2171:
                haikeiAndChara();
                serihu = getString(R.string.text2171);
                animeStrings();
                break;
            case 2181:
                haikeiAndChara();
                serihu = getString(R.string.text2181);
                animeStrings();
                break;
            case 2191:
                haikeiAndChara();
                serihu = getString(R.string.text2191);
                animeStrings();
                break;
            case 2201:
                haikeiAndChara();
                serihu = getString(R.string.text2201);
                animeStrings();
                break;
            case 2211:
                haikeiAndChara();
                serihu = getString(R.string.text2211);
                animeStrings();
                break;
            case 2221:
                haikeiAndChara();
                serihu = getString(R.string.text2221);
                animeStrings();
                break;
            case 2231:
                haikeiAndChara();
                serihu = getString(R.string.text2231);
                animeStrings();
                break;
            case 2241:
                haikeiAndChara();
                serihu = getString(R.string.text2241);
                animeStrings();
                break;
            case 2251:
                haikeiAndChara();
                serihu = getString(R.string.text2251);
                animeStrings();
                break;
            case 2261:
                haikeiAndChara();
                serihu = getString(R.string.text2261);
                animeStrings();
                break;
            case 2271:
                haikeiAndChara();
                serihu = getString(R.string.text2271);
                animeStrings();
                break;
            case 2281:
                haikeiAndChara();
                serihu = getString(R.string.text2281);
                animeStrings();
                break;
            case 2291:
                haikeiAndChara();
                serihu = getString(R.string.text2291);
                animeStrings();
                break;
            case 2301:
                haikeiAndChara();
                serihu = getString(R.string.text2301);
                animeStrings();
                break;
            case 2311:
                haikeiAndChara();
                serihu = getString(R.string.text2311);
                animeStrings();
                break;
            case 2321:
                haikeiAndChara();
                serihu = getString(R.string.text2321);
                animeStrings();
                break;
            case 2331:
                haikeiAndChara();
                serihu = getString(R.string.text2331);
                animeStrings();
                break;
            case 2341:
                haikeiAndChara();
                serihu = getString(R.string.text2341);
                animeStrings();
                break;
            case 2351:
                haikeiAndChara();
                serihu = getString(R.string.text2351);
                animeStrings();
                break;
            case 2361:
                haikeiAndChara();
                serihu = getString(R.string.text2361);
                animeStrings();
                break;
            case 2371:
                haikeiAndChara();
                serihu = getString(R.string.text2371);
                animeStrings();
                break;
            case 2381:
                haikeiAndChara();
                serihu = getString(R.string.text2381);
                animeStrings();
                break;
            case 2391:
                haikeiAndChara();
                serihu = getString(R.string.text2391);
                animeStrings();
                break;
            case 2401:
                haikeiAndChara();
                serihu = getString(R.string.text2401);
                animeStrings();
                break;
            case 2411:
                haikeiAndChara();
                serihu = getString(R.string.text2411);
                animeStrings();
                break;
            case 2421:
                haikeiAndChara();
                serihu = getString(R.string.text2421);
                animeStrings();
                break;
            case 2431:
                haikeiAndChara();
                serihu = getString(R.string.text2431);
                animeStrings();
                break;
            case 2441:
                haikeiAndChara();
                serihu = getString(R.string.text2441);
                animeStrings();
                break;
            case 2451:
                haikeiAndChara();
                serihu = getString(R.string.text2451);
                animeStrings();
                break;
            case 2461:
                haikeiAndChara();
                serihu = getString(R.string.text2461);
                animeStrings();
                break;
            case 2471:
                haikeiAndChara();
                serihu = getString(R.string.text2471);
                animeStrings();
                break;
            case 2481:
                haikeiAndChara();
                serihu = getString(R.string.text2481);
                animeStrings();
                break;
            case 2491:
                haikeiAndChara();
                serihu = getString(R.string.text2491);
                animeStrings();
                break;
            case 2501:
                haikeiAndChara();
                serihu = getString(R.string.text2501);
                animeStrings();
                break;
            case 2511:
                haikeiAndChara();
                serihu = getString(R.string.text2511);
                animeStrings();
                break;
            case 2521:
                haikeiAndChara();
                serihu = getString(R.string.text2521);
                animeStrings();
                break;
            case 2531:
                haikeiAndChara();
                serihu = getString(R.string.text2531);
                animeStrings();
                break;
            case 2541:
                haikeiAndChara();
                serihu = getString(R.string.text2541);
                animeStrings();
                break;
            case 2551:
                haikeiAndChara();
                serihu = getString(R.string.text2551);
                animeStrings();
                break;
            case 2561:
                haikeiAndChara();
                serihu = getString(R.string.text2561);
                animeStrings();
                break;
            case 2571:
                haikeiAndChara();
                serihu = getString(R.string.text2571);
                animeStrings();
                break;
            case 2581:
                haikeiAndChara();
                serihu = getString(R.string.text2581);
                animeStrings();
                break;
            case 2591:
                haikeiAndChara();
                serihu = getString(R.string.text2691);
                animeStrings();
                break;
            case 2601:
                haikeiAndChara();
                serihu = getString(R.string.text2601);
                animeStrings();
                break;
            case 2611:
                haikeiAndChara();
                serihu = getString(R.string.text2611);
                animeStrings();
                break;
            case 2621:
                haikeiAndChara();
                serihu = getString(R.string.text2621);
                animeStrings();
                break;
            case 2631:
                haikeiAndChara();
                serihu = getString(R.string.text2631);
                animeStrings();
                break;
            case 2641:
                haikeiAndChara();
                serihu = getString(R.string.text2641);
                animeStrings();
                break;
            case 2651:
                haikeiAndChara();
                serihu = getString(R.string.text2651);
                animeStrings();
                break;
            case 2661:
                haikeiAndChara();
                serihu = getString(R.string.text2661);
                animeStrings();
                break;
            case 2671:
                haikeiAndChara();
                serihu = getString(R.string.text2671);
                animeStrings();
                break;
            case 2681:
                haikeiAndChara();
                serihu = getString(R.string.text2681);
                animeStrings();
                break;
            case 2691:
                haikeiAndChara();
                serihu = getString(R.string.text291);
                animeStrings();
                break;
            case 2701:
                haikeiAndChara();
                serihu = getString(R.string.text2701);
                animeStrings();
                break;
            case 2711:
                haikeiAndChara();
                serihu = getString(R.string.text2711);
                animeStrings();
                break;
            case 2721:
                haikeiAndChara();
                serihu = getString(R.string.text2721);
                animeStrings();
                break;
            case 2731:
                haikeiAndChara();
                serihu = getString(R.string.text2731);
                animeStrings();
                break;
            case 2741:
                haikeiAndChara();
                serihu = getString(R.string.text2741);
                animeStrings();
                break;
            case 2751:
                haikeiAndChara();
                serihu = getString(R.string.text2751);
                animeStrings();
                break;
            case 2761:
                haikeiAndChara();
                serihu = getString(R.string.text2761);
                animeStrings();
                break;
            case 2771:
                haikeiAndChara();
                serihu = getString(R.string.text2771);
                animeStrings();
                break;
            case 2781:
                haikeiAndChara();
                serihu = getString(R.string.text2781);
                animeStrings();
                break;
            case 2791:
                haikeiAndChara();
                serihu = getString(R.string.text2891);
                animeStrings();
                break;
            case 2801:
                haikeiAndChara();
                serihu = getString(R.string.text2801);
                animeStrings();
                break;
            case 2811:
                haikeiAndChara();
                serihu = getString(R.string.text2811);
                animeStrings();
                break;
            case 2821:
                haikeiAndChara();
                serihu = getString(R.string.text2821);
                animeStrings();
                break;
            case 2831:
                haikeiAndChara();
                serihu = getString(R.string.text2831);
                animeStrings();
                break;
            case 2841:
                haikeiAndChara();
                serihu = getString(R.string.text2841);
                animeStrings();
                break;
            case 2851:
                haikeiAndChara();
                serihu = getString(R.string.text2851);
                animeStrings();
                break;
            case 2861:
                haikeiAndChara();
                serihu = getString(R.string.text2861);
                animeStrings();
                break;
            case 2871:
                haikeiAndChara();
                serihu = getString(R.string.text2871);
                animeStrings();
                break;
            case 2881:
                haikeiAndChara();
                serihu = getString(R.string.text281);
                animeStrings();
                break;
            case 2891:
                haikeiAndChara();
                serihu = getString(R.string.text2891);
                animeStrings();
                break;
            case 2901:
                haikeiAndChara();
                serihu = getString(R.string.text2901);
                animeStrings();
                break;
            case 2911:
                haikeiAndChara();
                serihu = getString(R.string.text2911);
                animeStrings();
                break;
            case 2921:
                haikeiAndChara();
                serihu = getString(R.string.text2921);
                animeStrings();
                break;
            case 2931:
                haikeiAndChara();
                serihu = getString(R.string.text2931);
                animeStrings();
                break;
            case 2941:
                haikeiAndChara();
                serihu = getString(R.string.text2941);
                animeStrings();
                break;
            case 2951:
                haikeiAndChara();
                serihu = getString(R.string.text2951);
                animeStrings();
                break;
            case 2961:
                haikeiAndChara();
                serihu = getString(R.string.text2961);
                animeStrings();
                break;
            case 2971:
                haikeiAndChara();
                serihu = getString(R.string.text2971);
                animeStrings();
                break;
            case 2981:
                haikeiAndChara();
                serihu = getString(R.string.text2981);
                animeStrings();
                break;
            case 2991:
                haikeiAndChara();
                serihu = getString(R.string.text2991);
                animeStrings();
                break;
            case 3001:
                haikeiAndChara();
                serihu = getString(R.string.text3001);
                animeStrings();
                break;
            case 3011:
                haikeiAndChara();
                serihu = getString(R.string.text3011);
                animeStrings();
                break;
            case 3021:
                haikeiAndChara();
                serihu = getString(R.string.text3021);
                animeStrings();
                break;
            case 3031:
                haikeiAndChara();
                serihu = getString(R.string.text3031);
                animeStrings();
                break;
            case 3041:
                haikeiAndChara();
                serihu = getString(R.string.text3041);
                animeStrings();
                break;
            case 3051:
                haikeiAndChara();
                serihu = getString(R.string.text3051);
                animeStrings();
                break;
            case 3061:
                haikeiAndChara();
                serihu = getString(R.string.text3061);
                animeStrings();
                break;
            case 3071:
                haikeiAndChara();
                serihu = getString(R.string.text3071);
                animeStrings();
                break;
            case 3081:
                haikeiAndChara();
                serihu = getString(R.string.text3081);
                animeStrings();
                break;
            case 3091:
                haikeiAndChara();
                serihu = getString(R.string.text3091);
                animeStrings();
                break;
            case 3101:
                haikeiAndChara();
                serihu = getString(R.string.text3101);
                animeStrings();
                break;
            case 3111:
                haikeiAndChara();
                serihu = getString(R.string.text3111);
                animeStrings();
                break;
            case 3121:
                haikeiAndChara();
                serihu = getString(R.string.text3121);
                animeStrings();
                break;
            case 3131:
                haikeiAndChara();
                serihu = getString(R.string.text3131);
                animeStrings();
                break;
            case 3141:
                haikeiAndChara();
                serihu = getString(R.string.text3141);
                animeStrings();
                break;
            case 3151:
                haikeiAndChara();
                serihu = getString(R.string.text3151);
                animeStrings();
                break;
            case 3161:
                haikeiAndChara();
                serihu = getString(R.string.text3161);
                animeStrings();
                break;
            case 3171:
                haikeiAndChara();
                serihu = getString(R.string.text3171);
                animeStrings();
                break;
            case 3181:
                haikeiAndChara();
                serihu = getString(R.string.text3181);
                animeStrings();
                break;
            case 3191:
                haikeiAndChara();
                serihu = getString(R.string.text3191);
                animeStrings();
                break;
            case 3201:
                haikeiAndChara();
                serihu = getString(R.string.text3201);
                animeStrings();
                break;
            case 3211:
                haikeiAndChara();
                serihu = getString(R.string.text3211);
                animeStrings();
                break;
            case 3221:
                haikeiAndChara();
                serihu = getString(R.string.text3221);
                animeStrings();
                break;
            case 3231:
                haikeiAndChara();
                serihu = getString(R.string.text3231);
                animeStrings();
                break;
            case 3241:
                haikeiAndChara();
                serihu = getString(R.string.text3241);
                animeStrings();
                break;
            case 3251:
                haikeiAndChara();
                serihu = getString(R.string.text3251);
                animeStrings();
                break;
            case 3261:
                haikeiAndChara();
                serihu = getString(R.string.text3261);
                animeStrings();
                break;
            case 3271:
                haikeiAndChara();
                serihu = getString(R.string.text3271);
                animeStrings();
                break;
            case 3281:
                haikeiAndChara();
                serihu = getString(R.string.text3281);
                animeStrings();
                break;
            case 3291:
                haikeiAndChara();
                serihu = getString(R.string.text3291);
                animeStrings();
                break;
            case 3301:
                haikeiAndChara();
                serihu = getString(R.string.text3301);
                animeStrings();
                break;
            case 3311:
                haikeiAndChara();
                serihu = getString(R.string.text3311);
                animeStrings();
                break;
            case 3321:
                haikeiAndChara();
                serihu = getString(R.string.text3321);
                animeStrings();
                break;
            case 3331:
                haikeiAndChara();
                serihu = getString(R.string.text3331);
                animeStrings();
                break;
            case 3341:
                haikeiAndChara();
                serihu = getString(R.string.text3341);
                animeStrings();
                break;
            case 3351:
                haikeiAndChara();
                serihu = getString(R.string.text3351);
                animeStrings();
                break;
            case 3361:
                haikeiAndChara();
                serihu = getString(R.string.text3361);
                animeStrings();
                break;
            case 3371:
                haikeiAndChara();
                serihu = getString(R.string.text3371);
                animeStrings();
                break;
            case 3381:
                haikeiAndChara();
                serihu = getString(R.string.text3381);
                animeStrings();
                break;
            case 3391:
                haikeiAndChara();
                serihu = getString(R.string.text3391);
                animeStrings();
                break;
            case 3401:
                haikeiAndChara();
                serihu = getString(R.string.text3401);
                animeStrings();
                break;
            case 3411:
                haikeiAndChara();
                serihu = getString(R.string.text3411);
                animeStrings();
                break;
            case 3421:
                haikeiAndChara();
                serihu = getString(R.string.text3421);
                animeStrings();
                break;
            case 3431:
                haikeiAndChara();
                serihu = getString(R.string.text3431);
                animeStrings();
                break;
            case 3441:
                haikeiAndChara();
                serihu = getString(R.string.text3441);
                animeStrings();
                break;
            case 3451:
                haikeiAndChara();
                serihu = getString(R.string.text3451);
                animeStrings();
                break;
            case 3461:
                haikeiAndChara();
                serihu = getString(R.string.text3461);
                animeStrings();
                break;
            case 3471:
                haikeiAndChara();
                serihu = getString(R.string.text3471);
                animeStrings();
                break;
            case 3481:
                haikeiAndChara();
                serihu = getString(R.string.text3481);
                animeStrings();
                break;
            case 3491:
                haikeiAndChara();
                serihu = getString(R.string.text3591);
                animeStrings();
                break;
            case 3501:
                haikeiAndChara();
                serihu = getString(R.string.text3501);
                animeStrings();
                break;
            case 3511:
                haikeiAndChara();
                serihu = getString(R.string.text3511);
                animeStrings();
                break;
            case 3521:
                haikeiAndChara();
                serihu = getString(R.string.text3521);
                animeStrings();
                break;
            case 3531:
                haikeiAndChara();
                serihu = getString(R.string.text3531);
                animeStrings();
                break;
            case 3541:
                haikeiAndChara();
                serihu = getString(R.string.text3541);
                animeStrings();
                break;
            case 3551:
                haikeiAndChara();
                serihu = getString(R.string.text3551);
                animeStrings();
                break;
            case 3561:
                haikeiAndChara();
                serihu = getString(R.string.text3561);
                animeStrings();
                break;
            case 3571:
                haikeiAndChara();
                serihu = getString(R.string.text3571);
                animeStrings();
                break;
            case 3581:
                haikeiAndChara();
                serihu = getString(R.string.text3581);
                animeStrings();
                break;
            case 3591:
                haikeiAndChara();
                serihu = getString(R.string.text3591);
                animeStrings();
                break;
            case 3601:
                haikeiAndChara();
                serihu = getString(R.string.text3601);
                animeStrings();
                break;
            case 3611:
                haikeiAndChara();
                serihu = getString(R.string.text3611);
                animeStrings();
                break;
            case 3621:
                haikeiAndChara();
                serihu = getString(R.string.text3621);
                animeStrings();
                break;
            case 3631:
                haikeiAndChara();
                serihu = getString(R.string.text3631);
                animeStrings();
                break;
            case 3641:
                haikeiAndChara();
                serihu = getString(R.string.text3641);
                animeStrings();
                break;
            case 3651:
                haikeiAndChara();
                serihu = getString(R.string.text3651);
                animeStrings();
                break;
            case 3661:
                haikeiAndChara();
                serihu = getString(R.string.text3661);
                animeStrings();
                break;
            case 3671:
                haikeiAndChara();
                serihu = getString(R.string.text3671);
                animeStrings();
                break;
            case 3681:
                haikeiAndChara();
                serihu = getString(R.string.text3681);
                animeStrings();
                break;
            case 3691:
                haikeiAndChara();
                serihu = getString(R.string.text3691);
                animeStrings();
                break;
            case 3701:
                haikeiAndChara();
                serihu = getString(R.string.text3701);
                animeStrings();
                break;
            case 3711:
                haikeiAndChara();
                serihu = getString(R.string.text3711);
                animeStrings();
                break;
            case 3721:
                haikeiAndChara();
                serihu = getString(R.string.text3721);
                animeStrings();
                break;
            case 3731:
                haikeiAndChara();
                serihu = getString(R.string.text3731);
                animeStrings();
                break;
            case 3741:
                haikeiAndChara();
                serihu = getString(R.string.text3741);
                animeStrings();
                break;
            case 3751:
                haikeiAndChara();
                serihu = getString(R.string.text3751);
                animeStrings();
                break;
            case 3761:
                haikeiAndChara();
                serihu = getString(R.string.text3761);
                animeStrings();
                break;
            case 3771:
                haikeiAndChara();
                serihu = getString(R.string.text3771);
                animeStrings();
                break;
            case 3781:
                haikeiAndChara();
                serihu = getString(R.string.text3781);
                animeStrings();
                break;
            case 3791:
                haikeiAndChara();
                serihu = getString(R.string.text3791);
                animeStrings();
                break;
            case 3801:
                haikeiAndChara();
                serihu = getString(R.string.text3801);
                animeStrings();
                break;
            case 3811:
                haikeiAndChara();
                serihu = getString(R.string.text3811);
                animeStrings();
                break;
            case 3821:
                haikeiAndChara();
                serihu = getString(R.string.text3821);
                animeStrings();
                break;
            case 3831:
                haikeiAndChara();
                serihu = getString(R.string.text3831);
                animeStrings();
                break;
            case 3841:
                haikeiAndChara();
                serihu = getString(R.string.text3841);
                animeStrings();
                break;
            case 3851:
                haikeiAndChara();
                serihu = getString(R.string.text3851);
                animeStrings();
                break;
            case 3861:
                haikeiAndChara();
                serihu = getString(R.string.text3861);
                animeStrings();
                break;
            case 3871:
                haikeiAndChara();
                serihu = getString(R.string.text3871);
                animeStrings();
                break;
            case 3881:
                haikeiAndChara();
                serihu = getString(R.string.text3881);
                animeStrings();
                break;
            case 3891:
                haikeiAndChara();
                serihu = getString(R.string.text3891);
                animeStrings();
                break;
            case 3901:
                haikeiAndChara();
                serihu = getString(R.string.text3901);
                animeStrings();
                break;
            case 3911:
                haikeiAndChara();
                serihu = getString(R.string.text3911);
                animeStrings();
                break;
            case 3921:
                haikeiAndChara();
                serihu = getString(R.string.text3921);
                animeStrings();
                break;
            case 3931:
                haikeiAndChara();
                serihu = getString(R.string.text3931);
                animeStrings();
                break;
            case 3941:
                haikeiAndChara();
                serihu = getString(R.string.text3941);
                animeStrings();
                break;
            case 3951:
                haikeiAndChara();
                serihu = getString(R.string.text3951);
                animeStrings();
                break;
            case 3961:
                haikeiAndChara();
                serihu = getString(R.string.text3961);
                animeStrings();
                break;
            case 3971:
                haikeiAndChara();
                serihu = getString(R.string.text3971);
                animeStrings();
                break;
            case 3981:
                haikeiAndChara();
                serihu = getString(R.string.text3981);
                animeStrings();
                break;
            case 3991:
                haikeiAndChara();
                serihu = getString(R.string.text3991);
                animeStrings();
                break;
            case 4001:
                haikeiAndChara();
                serihu = getString(R.string.text4001);
                animeStrings();
                break;
            case 4011:
                haikeiAndChara();
                serihu = getString(R.string.text4011);
                animeStrings();
                break;
            case 4021:
                haikeiAndChara();
                serihu = getString(R.string.text4021);
                animeStrings();
                break;
            case 4031:
                haikeiAndChara();
                serihu = getString(R.string.text4031);
                animeStrings();
                break;
            case 4041:
                haikeiAndChara();
                serihu = getString(R.string.text4041);
                animeStrings();
                break;
            case 4051:
                haikeiAndChara();
                serihu = getString(R.string.text4051);
                animeStrings();
                break;
            case 4061:
                haikeiAndChara();
                serihu = getString(R.string.text4061);
                animeStrings();
                break;
            case 4071:
                haikeiAndChara();
                serihu = getString(R.string.text4071);
                animeStrings();
                break;
            case 4081:
                haikeiAndChara();
                serihu = getString(R.string.text4081);
                animeStrings();
                break;
            case 4091:
                haikeiAndChara();
                serihu = getString(R.string.text4091);
                animeStrings();
                break;
            case 4101:
                haikeiAndChara();
                serihu = getString(R.string.text4101);
                animeStrings();
                break;
            case 4111:
                haikeiAndChara();
                serihu = getString(R.string.text4111);
                animeStrings();
                break;
            case 4121:
                haikeiAndChara();
                serihu = getString(R.string.text4121);
                animeStrings();
                break;
            case 4131:
                haikeiAndChara();
                serihu = getString(R.string.text4131);
                animeStrings();
                break;
            case 4141:
                haikeiAndChara();
                serihu = getString(R.string.text4141);
                animeStrings();
                break;
            case 4151:
                haikeiAndChara();
                serihu = getString(R.string.text4151);
                animeStrings();
                break;
            case 4161:
                haikeiAndChara();
                serihu = getString(R.string.text4161);
                animeStrings();
                break;
            case 4171:
                haikeiAndChara();
                serihu = getString(R.string.text4171);
                animeStrings();
                break;
            case 4181:
                haikeiAndChara();
                serihu = getString(R.string.text4181);
                animeStrings();
                break;
            case 4191:
                haikeiAndChara();
                serihu = getString(R.string.text4191);
                animeStrings();
                break;
            case 4201:
                haikeiAndChara();
                serihu = getString(R.string.text4201);
                animeStrings();
                break;
            case 4211:
                haikeiAndChara();
                serihu = getString(R.string.text4211);
                animeStrings();
                break;
            case 4221:
                haikeiAndChara();
                serihu = getString(R.string.text4221);
                animeStrings();
                break;
            case 4231:
                haikeiAndChara();
                serihu = getString(R.string.text4231);
                animeStrings();
                break;
            case 4241:
                haikeiAndChara();
                serihu = getString(R.string.text4241);
                animeStrings();
                break;
            case 4251:
                haikeiAndChara();
                serihu = getString(R.string.text4251);
                animeStrings();
                break;
            case 4261:
                haikeiAndChara();
                serihu = getString(R.string.text4261);
                animeStrings();
                break;
            case 4271:
                haikeiAndChara();
                serihu = getString(R.string.text4271);
                animeStrings();
                break;
            case 4281:
                haikeiAndChara();
                serihu = getString(R.string.text4281);
                animeStrings();
                break;
            case 4291:
                haikeiAndChara();
                serihu = getString(R.string.text4291);
                animeStrings();
                break;
            case 4301:
                haikeiAndChara();
                serihu = getString(R.string.text4301);
                animeStrings();
                break;
            case 4311:
                haikeiAndChara();
                serihu = getString(R.string.text4311);
                animeStrings();
                break;
            case 4321:
                haikeiAndChara();
                serihu = getString(R.string.text4321);
                animeStrings();
                break;
            case 4331:
                haikeiAndChara();
                serihu = getString(R.string.text4331);
                animeStrings();
                break;
            case 4341:
                haikeiAndChara();
                serihu = getString(R.string.text4341);
                animeStrings();
                break;
            case 4351:
                haikeiAndChara();
                serihu = getString(R.string.text4351);
                animeStrings();
                break;
            case 4361:
                haikeiAndChara();
                serihu = getString(R.string.text4361);
                animeStrings();
                break;
            case 4371:
                haikeiAndChara();
                serihu = getString(R.string.text4371);
                animeStrings();
                break;
            case 4381:
                haikeiAndChara();
                serihu = getString(R.string.text4381);
                animeStrings();
                break;
            case 4391:
                haikeiAndChara();
                serihu = getString(R.string.text4391);
                animeStrings();
                break;
            case 4401:
                haikeiAndChara();
                serihu = getString(R.string.text4401);
                animeStrings();
                break;
            case 4411:
                haikeiAndChara();
                serihu = getString(R.string.text4411);
                animeStrings();
                break;
            case 4421:
                haikeiAndChara();
                serihu = getString(R.string.text4421);
                animeStrings();
                break;
            case 4431:
                haikeiAndChara();
                serihu = getString(R.string.text4431);
                animeStrings();
                break;
            case 4441:
                haikeiAndChara();
                serihu = getString(R.string.text4441);
                animeStrings();
                break;
            case 4451:
                haikeiAndChara();
                serihu = getString(R.string.text4451);
                animeStrings();
                break;
            case 4461:
                haikeiAndChara();
                serihu = getString(R.string.text4461);
                animeStrings();
                break;
            case 4471:
                haikeiAndChara();
                serihu = getString(R.string.text4471);
                animeStrings();
                break;
            case 4481:
                haikeiAndChara();
                serihu = getString(R.string.text4481);
                animeStrings();
                break;
            case 4491:
                haikeiAndChara();
                serihu = getString(R.string.text4491);
                animeStrings();
                break;
            case 4501:
                haikeiAndChara();
                serihu = getString(R.string.text4501);
                animeStrings();
                break;
            case 4511:
                haikeiAndChara();
                serihu = getString(R.string.text4511);
                animeStrings();
                break;
            case 4521:
                haikeiAndChara();
                serihu = getString(R.string.text4521);
                animeStrings();
                break;
            case 4531:
                haikeiAndChara();
                serihu = getString(R.string.text4531);
                animeStrings();
                break;
            case 4541:
                haikeiAndChara();
                serihu = getString(R.string.text4541);
                animeStrings();
                break;
            case 4551:
                haikeiAndChara();
                serihu = getString(R.string.text4551);
                animeStrings();
                break;
            case 4561:
                haikeiAndChara();
                serihu = getString(R.string.text4561);
                animeStrings();
                break;
            case 4571:
                haikeiAndChara();
                serihu = getString(R.string.text4571);
                animeStrings();
                break;
            case 4581:
                haikeiAndChara();
                serihu = getString(R.string.text4581);
                animeStrings();
                break;
            case 4591:
                haikeiAndChara();
                serihu = getString(R.string.text4591);
                animeStrings();
                break;
            case 4601:
                haikeiAndChara();
                serihu = getString(R.string.text4601);
                animeStrings();
                break;
            case 4611:
                haikeiAndChara();
                serihu = getString(R.string.text4611);
                animeStrings();
                break;
            case 4621:
                haikeiAndChara();
                serihu = getString(R.string.text4621);
                animeStrings();
                break;
            case 4631:
                haikeiAndChara();
                serihu = getString(R.string.text4631);
                animeStrings();
                break;
            case 4641:
                haikeiAndChara();
                serihu = getString(R.string.text4641);
                animeStrings();
                break;
            case 4651:
                haikeiAndChara();
                serihu = getString(R.string.text4651);
                animeStrings();
                break;
            case 4661:
                haikeiAndChara();
                serihu = getString(R.string.text4661);
                animeStrings();
                break;
            case 4671:
                haikeiAndChara();
                serihu = getString(R.string.text4671);
                animeStrings();
                break;
            case 4681:
                haikeiAndChara();
                serihu = getString(R.string.text4681);
                animeStrings();
                break;
            case 4691:
                haikeiAndChara();
                serihu = getString(R.string.text4691);
                animeStrings();
                break;
            case 4701:
                haikeiAndChara();
                serihu = getString(R.string.text4701);
                animeStrings();
                break;
            case 4711:
                haikeiAndChara();
                serihu = getString(R.string.text4711);
                animeStrings();
                break;
            case 4721:
                haikeiAndChara();
                serihu = getString(R.string.text4721);
                animeStrings();
                break;
            case 4731:
                haikeiAndChara();
                serihu = getString(R.string.text4731);
                animeStrings();
                break;
            case 4741:
                haikeiAndChara();
                serihu = getString(R.string.text4741);
                animeStrings();
                break;
            case 4751:
                haikeiAndChara();
                serihu = getString(R.string.text4751);
                animeStrings();
                break;
            case 4761:
                haikeiAndChara();
                serihu = getString(R.string.text4761);
                animeStrings();
                break;
            case 4771:
                haikeiAndChara();
                serihu = getString(R.string.text4771);
                animeStrings();
                break;
            case 4781:
                haikeiAndChara();
                serihu = getString(R.string.text4781);
                animeStrings();
                break;
            case 4791:
                haikeiAndChara();
                serihu = getString(R.string.text4791);
                animeStrings();
                break;
            case 4801:
                haikeiAndChara();
                serihu = getString(R.string.text4801);
                animeStrings();
                break;
            case 4811:
                haikeiAndChara();
                serihu = getString(R.string.text4811);
                animeStrings();
                break;
            case 4821:
                haikeiAndChara();
                serihu = getString(R.string.text4821);
                animeStrings();
                break;
            case 4831:
                haikeiAndChara();
                serihu = getString(R.string.text4831);
                animeStrings();
                break;
            case 4841:
                haikeiAndChara();
                serihu = getString(R.string.text4841);
                animeStrings();
                break;
            case 4851:
                haikeiAndChara();
                serihu = getString(R.string.text4851);
                animeStrings();
                break;
            case 4861:
                haikeiAndChara();
                serihu = getString(R.string.text4861);
                animeStrings();
                break;
            case 4871:
                haikeiAndChara();
                serihu = getString(R.string.text4871);
                animeStrings();
                break;
            case 4881:
                haikeiAndChara();
                serihu = getString(R.string.text4881);
                animeStrings();
                break;
            case 4891:
                haikeiAndChara();
                serihu = getString(R.string.text4891);
                animeStrings();
                break;


            default:
                break;
        }
    }

    public void increment(int plus) {
        for (int p = plus; p > 0; p--) {
            textflag = textflag + 1;
        }
    }

    public void onLog() {
        ImageView log_image = (ImageView) findViewById(R.id.log_image); //コメント枠のIDを取得
        TextView log_text = (TextView) findViewById(R.id.log_text);
        final ScrollView scroll = (ScrollView) findViewById(R.id.scrollView1);

        if (logflag == 0) { //0ならログ画面へ
            scroll.setPadding(0, 40, 0, 40);
            log_image.setImageResource(R.drawable.haikei_anten);
            log_text.setText(log);
            scroll.post(new Runnable() {
                @Override
                public void run() {
                    scroll.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        } else if (logflag == 1) { //1ならゲーム画面へ戻る
            log_image.setImageDrawable(null);
            log_text.setText(null);
        }
    }

    public void haikeiAndChara() {
        RelativeLayout haikei = (RelativeLayout) findViewById(R.id.layout1); //背景のIDを取得
        ImageView lchara = (ImageView) findViewById(R.id.left_chara); //左側キャラの立ち絵を取得
        ImageView cchara = (ImageView) findViewById(R.id.center_chara); //中央キャラの立ち絵を取得
        ImageView rchara = (ImageView) findViewById(R.id.right_chara); //左側キャラの立ち絵を取得
        TextView textName = (TextView) findViewById(R.id.tapName); //名前入力欄のIDを取得
        ImageView nameWaku = (ImageView) findViewById(R.id.name_image); //名前枠のIDを取得
        Animation Fadein = AnimationUtils.loadAnimation(GameActivity.this, R.anim.fadein);
        Animation Zukkoke = AnimationUtils.loadAnimation(GameActivity.this, R.anim.zukkoke);
        Animation Okiagari = AnimationUtils.loadAnimation(GameActivity.this, R.anim.okiagari);
        Animation Toujou = AnimationUtils.loadAnimation(GameActivity.this, R.anim.toujou);

        switch (textflag) {
            case 1:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 11:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.name_q);
                break;
            case 21:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 31:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 41:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 51:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 61:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                haikei.startAnimation(Fadein);
                Fadein.setFillAfter(true);
                break;
            case 71:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 81:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 91:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 101:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 111:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 121:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 131:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 141:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.name_q);
                break;
            case 151:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);

                rchara.startAnimation(Zukkoke);
                Zukkoke.setFillAfter(true);

                break;
            case 161:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 171:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 181:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.name_q);

                rchara.startAnimation(Okiagari);

                break;
            case 191:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 201:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 211:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 221:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 231:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 241:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 251:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 261:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 271:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 281:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 291:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 301:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 311:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 321:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 331:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 341:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 351:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 361:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 371:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 381:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 391:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 401:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 411:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 421:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 431:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 441:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 451:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 461:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 471:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 481:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.name_q);
                break;
            case 491:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);

                rchara.startAnimation(Zukkoke);
                Zukkoke.setFillAfter(true);

                break;
            case 501:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 511:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.name_q);
                break;
            case 521:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 531:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.name_q);
                break;
            case 541:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 551:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);

                rchara.startAnimation(Toujou);

                break;
            case 561:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 571:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 581:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 591:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 601:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 611:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 621:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 631:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 641:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 651:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 661:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 671:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 681:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 691:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 701:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 711:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 721:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 731:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 741:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 751:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 761:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 771:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 781:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.hiro);
                break;
            case 791:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.haruka);
                break;
            case 801:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageResource(R.drawable.name_waku);
                textName.setText(R.string.masato);
                break;
            case 811:
                haikei.setBackgroundResource(R.drawable.haikei_shosai);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 821://-4月16日 EP1-
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 831:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae); //背景を　田舎駅前　へ　変更
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 841:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 851:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 861:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 871:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 881:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.taxi_driver);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 891:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 901:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 911:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 921:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 931:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 941:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 951:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 961:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 971:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 981:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 991:
                haikei.setBackgroundResource(R.drawable.haikei_inaka_ekimae);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.taxi_driver);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1001:
                haikei.setBackgroundResource(R.drawable.haikei_taxinai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1011:
                haikei.setBackgroundResource(R.drawable.haikei_taxinai);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.taxi_driver);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1021:
                haikei.setBackgroundResource(R.drawable.haikei_taxinai);
                lchara.setImageResource(R.drawable.taxi_driver);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1031:
                haikei.setBackgroundResource(R.drawable.haikei_taxinai);
                lchara.setImageResource(R.drawable.taxi_driver);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1041:
                haikei.setBackgroundResource(R.drawable.haikei_taxinai);
                lchara.setImageResource(R.drawable.taxi_driver);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1051:
                haikei.setBackgroundResource(R.drawable.haikei_taxinai);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1061:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.taxi_driver);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1071:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1081:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1091:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1101:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1111:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1121:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1131:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1141:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1151:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1161:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1171:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1181:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1191:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1201:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1211:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1221:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1231:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1241:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1251:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1261:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1271:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1281:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1291:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1301:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1311:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1321:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1331:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1341:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1351:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1361:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1371:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1381:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1391:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1401:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1411:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1421:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1431:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1441:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1451:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1461:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1471:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1481:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1491:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1501:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1511:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1521:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1531:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1541:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1551:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                rchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                lchara.setImageDrawable(null);
                break;
            case 1561:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                rchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                lchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1571:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1581:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1591:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1601:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1611:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1621:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1631:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1641:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1651:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1661:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1671:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1681:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1691:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hannin);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1701:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.keisatsu);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1711:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1721:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1731:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1741:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1751:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1761:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1771:
                haikei.setBackgroundResource(R.drawable.haikei_koutyoshitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1781:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.haruka);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1791:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1801:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1811:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1821:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1831:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1841:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1851:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1861:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1871:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1881:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_gaikan);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1891:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_kaidan);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1901:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_kaidan);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1911:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.shatyo);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1921:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.shatyo);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1931:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1941:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1951:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1961:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1971:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1981:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 1991:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2001:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2011:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2021:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2031:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2041:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2051:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2061:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2071:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2081:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2091:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2101:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2111:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2121:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2131:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.shatyo);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2141:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.shatyo);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2151:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2161:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2171:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2181:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2191:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2201:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2211:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2221:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2231:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2241:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2251:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2261:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2271:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2281:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2291:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2301:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageResource(R.drawable.watanuki);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2311:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageResource(R.drawable.watanuki);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2321:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageResource(R.drawable.watanuki);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2331:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageResource(R.drawable.watanuki);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2341:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.watanuki);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2351:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2361:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2371:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2381:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2391:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2401:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2411:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2421:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2431:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2441:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2451:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2461:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2471:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2481:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.shatyo);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2491:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2501:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2511:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2521:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2531:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2541:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2551:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2561:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2571:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2581:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2591:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2601:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2611:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2621:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2631:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2641:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2651:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2661:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2671:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2681:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2691:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2701:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2711:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2721:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2731:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2741:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2751:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2761:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2771:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2781:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2791:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2801:
                haikei.setBackgroundResource(R.drawable.haikei_rouka);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2811:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2821:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2831:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2841:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2851:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2861:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2871:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2881:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2891:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2901:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2911:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2921:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2931:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2941:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2951:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2961:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2971:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2981:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 2991:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3001:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3011:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3021:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3031:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3041:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3051:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3061:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3071:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3081:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3091:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3101:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3111:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3121:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3131:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3141:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3151:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3161:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3171:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3181:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3191:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.haruka);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3201:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3211:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3221:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3231:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3241:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3251:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3261:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3271:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3281:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3291:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3301:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3311:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3321:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3331:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3341:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3351:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.hiro);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3361:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3371:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3381:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3391:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3401:
                haikei.setBackgroundResource(R.drawable.haikei_anten);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3411:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3421:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3431:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3441:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.mike);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3451:
                haikei.setBackgroundResource(R.drawable.haikei_kyakushitsu);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3461:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3471:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3481:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3491:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3501:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3511:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3521:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.masaru);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3531:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.satonishi);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3541:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3551:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3561:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3571:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.hiro);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3581:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3591:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3601:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3611:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3621:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3631:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3641:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3651:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3661:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3671:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3681:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3691:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.satonishi);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3701:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3711:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3721:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3731:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3741:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3751:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3761:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3771:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3781:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.haruka);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3791:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3801:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3811:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3821:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3831:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3841:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3851:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3861:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3871:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3881:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3891:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3901:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageResource(R.drawable.masaru);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3911:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageResource(R.drawable.satonishi);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3921:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3931:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3941:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3951:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3961:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3971:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageDrawable(null);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3981:
                haikei.setBackgroundResource(R.drawable.haikei_yokan_ousetuma);
                lchara.setImageResource(R.drawable.mike);
                cchara.setImageDrawable(null);
                rchara.setImageDrawable(null);
                nameWaku.setImageDrawable(null);
                textName.setText(null);
                break;
            case 3991:
                break;
            case 4001:
                break;
            case 4011:
                break;
            case 4021:
                break;
            case 4031:
                break;
            case 4041:
                break;
            case 4051:
                break;
            case 4061:
                break;
            case 4071:
                break;
            case 4081:
                break;
            case 4091:
                break;
            case 4101:
                break;
            case 4111:
                break;
            case 4121:
                break;
            case 4131:
                break;
            case 4141:
                break;
            case 4151:
                break;
            case 4161:
                break;
            case 4171:
                break;
            case 4181:
                break;
            case 4191:
                break;
            case 4201:
                break;
            case 4211:
                break;
            case 4221:
                break;
            case 4231:
                break;
            case 4241:
                break;
            case 4251:
                break;
            case 4261:
                break;
            case 4271:
                break;
            case 4281:
                break;
            case 4291:
                break;
            case 4301:
                break;
            case 4311:
                break;
            case 4321:
                break;
            case 4331:
                break;
            case 4341:
                break;
            case 4351:
                break;
            case 4361:
                break;
            case 4371:
                break;
            case 4381:
                break;
            case 4391:
                break;
            case 4401:
                break;
            case 4411:
                break;
            case 4421:
                break;
            case 4431:
                break;
            case 4441:
                break;
            case 4451:
                break;
            case 4461:
                break;
            case 4471:
                break;
            case 4481:
                break;
            case 4491:
                break;
            case 4501:
                break;
            case 4511:
                break;
            case 4521:
                break;
            case 4531:
                break;
            case 4541:
                break;
            case 4551:
                break;
            case 4561:
                break;
            case 4571:
                break;
            case 4581:
                break;
            case 4591:
                break;
            case 4601:
                break;
            case 4611:
                break;
            case 4621:
                break;
            case 4631:
                break;
            case 4641:
                break;
            case 4651:
                break;
            case 4661:
                break;
            case 4671:
                break;
            case 4681:
                break;
            case 4691:
                break;
            case 4701:
                break;
            case 4711:
                break;
            case 4721:
                break;
            case 4731:
                break;
            case 4741:
                break;
            case 4751:
                break;
            case 4761:
                break;
            case 4771:
                break;
            case 4781:
                break;
            case 4791:
                break;
            case 4801:
                break;
            case 4811:
                break;
            case 4821:
                break;
            case 4831:
                break;
            case 4841:
                break;
            case 4851:
                break;
            case 4861:
                break;
            case 4871:
                break;
            case 4881:
                break;
            case 4891:
                break;


            default:
                break;
        }

    }

    public void animeStrings(){
        TextView textView1 = (TextView) findViewById(R.id.tapComment); //コメントのIDを取得
        TextView text_next = (TextView) findViewById(R.id.text_next);
        AlphaAnimation animation_alpha = new AlphaAnimation(1, 0);
        animation_alpha.setDuration(1000);
        animation_alpha.setRepeatCount(Animation.INFINITE);
        animation_alpha.setRepeatMode(Animation.REVERSE);

        if (serihu_flag == 0) {
            handler.sendEmptyMessage(TIMEOUT_MESSAGE);
            saveflag = textflag;
            logOnce = 1; //ログ取得を禁止
        }
        if (serihu_flag == 1) {
            textView1.setText(serihu);
            handler.removeCallbacksAndMessages(null);
            serihu_flag = 0;
            put_word = "";
            put_text = "";
            i = 0;
            logOnce = 0; //ログ取得を再開
            text_next.setText("NEXT");
            text_next.startAnimation(animation_alpha);
            increment(10);
        }
    }

    // 文字列を一文字ずつ出力するハンドラ
    //１文字ずつ表示の方法のURL：http://ameblo.jp/android-feiris/entry-11741365827.html
    public Handler handler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            // 文字列を配列dataに１文字ずつセット
            char data[] = serihu.toCharArray();//（1）

            TextView text_next = (TextView) findViewById(R.id.text_next);
            TextView textView = (TextView) findViewById(R.id.tapComment);//コメントのIDを取得

            if (i < data.length) {//(2)
                serihu_flag = 1;
                text_next.setText(null);
                if (msg.what == TIMEOUT_MESSAGE) {
                    put_word = String.valueOf(data[i]);//(3)
                    put_text = put_text + put_word;//(4)
                    textView.setText(put_text);//(5)
                    handler.sendEmptyMessageDelayed(TIMEOUT_MESSAGE, interval * 40);//(6)
                    i++;
                } else {
                    super.dispatchMessage(msg);
                }
            } else {
                put_word = "";
                put_text = "";
                i = 0;
                serihu_flag = 0;
                logOnce = 0;
                increment(increment_num);

                //text_next1を点滅させる
                //情報元：http://web-terminal.blogspot.jp/2013/05/android.html#AnimationSet-to-achieve-complex-animations-by-combining-basic-animation
                AlphaAnimation animation_alpha = new AlphaAnimation( 1, 0 );
                animation_alpha.setDuration( 1000 );//1秒間掛けてアニメーションを再生
                animation_alpha.setRepeatCount( Animation.INFINITE );//アニメーションが無限に実行される
                animation_alpha.setRepeatMode( Animation.REVERSE );//アニメーションが逆再生される
                text_next.setText("NEXT");
                text_next.startAnimation( animation_alpha );
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // 音楽の読み込み
        p = MediaPlayer.create(getApplicationContext(), R.raw.akaidress);
        // 連続再生設定
        p.setLooping(true);

        final TextView textView = (TextView) findViewById(R.id.tapComment); //コメント枠を取得
        final TextView textView1 = (TextView) findViewById(R.id.tapComment2); //手紙枠を取得
        final Button log_tap_text = (Button) findViewById(R.id.log_tap_text); //ログボタンを取得
        final Button saveButton = (Button) findViewById(R.id.saveButton); //ログボタンを取得

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapComment();
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapComment();
            }
        });

        log_tap_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLog();
                if (logflag == 0) { //0ならログ画面へ
                    log_tap_text.setText("Back");
                    logflag = 1;
                } else if (logflag == 1) { //1ならゲーム画面へ戻る
                    log_tap_text.setText("L o g");
                    logflag = 0;
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //クリックされたらSALアクティビティへ移動
                saveOrLoad_g = 0;
                intent.setClassName("com.app.hentaro.escape", "com.app.hentaro.escape.SaveAndLoadActivity");
                intent.putExtra("saveOrLoad", saveOrLoad_g); //0を受け渡してセーブであることを明示
                intent.putExtra("saveflag", saveflag); //セーブフラグを受け渡し
                intent.putExtra("saveMsg", saveMsg); //セーブ画面であることを表示する文字列の受け渡し
                startActivity(intent);
            }
        });

        Intent intent1 = getIntent(); //ロードされた時に読み込む
        textflag = intent1.getIntExtra("saveflag", textflag); //セーブフラグをテキストフラグに代入
        tapComment();
    }

    // 画面が表示されるたびに実行
    @Override
    protected void onResume() {
        super.onResume();
        p.start(); // 再生
    }

    // 画面が非表示に実行
    @Override
    protected void onPause() {
        super.onPause();
        p.pause(); // 一時停止
    }

    // アプリ終了時に実行
    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.release();// メモリの解放
        p = null; // 音楽プレーヤーを破棄
    }
}
