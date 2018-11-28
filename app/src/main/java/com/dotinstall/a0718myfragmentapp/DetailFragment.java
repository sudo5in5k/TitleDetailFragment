package com.dotinstall.a0718myfragmentapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sho on 2017/07/19.
 */

public class DetailFragment extends Fragment{

    final static String TAG = "DETAILFRAGMENT_TEST!!!";

    public DetailFragment(){}
    /*tapされたタイトルに応じてFragment のインスタンスを動的に作っていきたいのですが、
    コンストラクタに引数を渡してはいけないというルールがあるので、
    動的にインスタンスを作るための静的なメソッドを作っていかなくてはいけません。
     */
    public static DetailFragment newInstance(int position){//何番目がタップされたかが渡るように
        DetailFragment detailFragment = new DetailFragment();//instance
        Bundle args = new Bundle();//データの割り当て
        args.putInt("position",position);
        detailFragment.setArguments(args);
        return detailFragment;
    }

    //テキストビューを作る
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View detailView = inflater.inflate(R.layout.view_detail,container,false);
        ((TextView) detailView.findViewById(R.id.detailText))
                .setText(News.Details[getArguments().getInt("position")]);//引っ張るにはgetArguments
        //そしてgetIntにキーを渡してあげれば良い
        return detailView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.d(TAG, "onCreateOptionsMenu");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Log.d(TAG, "onPreparedOptionsMenu");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
