package com.dotinstall.a0718myfragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SubActivity extends AppCompatActivity {

    final static String TAG = "SUB_TEST!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //横画面の時はSubActivityを破棄
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;

        }

        //intentから受け渡し
        int position = getIntent().getIntExtra(TitlesFragment.EXTRA_POSITION, 0);
        DetailFragment dF = DetailFragment.newInstance(position);

        FragmentManager fragmentmanager = getFragmentManager();//起動
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();//トランザクション作成

        fragmenttransaction.add(R.id.detailFrame, dF);//実行したいトランザクションを記述して --のfragmentと追加したい場所
        fragmenttransaction.commit();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState()");
    }
}
