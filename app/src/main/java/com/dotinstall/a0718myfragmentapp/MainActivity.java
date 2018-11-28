package com.dotinstall.a0718myfragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements TitlesFragment.OnTitleSelectedListner {

    final static String TAG = "MAIN_TEST!!!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate_start");
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate_end");
    }


    @Override
    public void onTitleSelected(int position) {
        DetailFragment detailFragment = DetailFragment.newInstance(position);

        FragmentManager fragmentmanager = getFragmentManager();//起動
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();//トランザクション作成

        fragmenttransaction.replace(R.id.detailFrame, detailFragment);//実行したいトランザクションを記述して --のfragmentと追加したい場所
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();//保存
        Log.d(TAG, "ontitleselected");

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
