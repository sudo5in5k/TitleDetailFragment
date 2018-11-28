package com.dotinstall.a0718myfragmentapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by sho on 2017/07/19.
 */
public class TitlesFragment extends android.support.v4.app.ListFragment {//ListViewに特化したListFragmentを

    public final static String EXTRA_POSITION = "com.dotinstall.a0718myfragmentapp";

    private OnTitleSelectedListner listner;

    private boolean isDualPane;//横画面かどうかの保持

    private int savedPosition;

    final static String TAG = "TITLEFRAGMENT_TEST!!!";

    public TitlesFragment() {
    }

    public interface OnTitleSelectedListner {//独自のリスナーを作る場合はinterface

        void onTitleSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");

        try {
            listner = (OnTitleSelectedListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "　must implement onTitleSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
        listner = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {//定型文
        super.onActivityCreated(savedInstanceState);//定型文
        Log.d(TAG, "onActivityCreated");

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, News.Titles));

        View detFrame = getActivity().findViewById(R.id.detailFrame);

        isDualPane = detFrame != null && detFrame.getVisibility() == View.VISIBLE;
        if (isDualPane) {
            if (savedInstanceState != null) {
                savedPosition = savedInstanceState.getInt("saved_position");
            } else {
                savedPosition = 0;
            }
            listner.onTitleSelected(savedPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("saved_position", savedPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {//リストアイテムクリック（タップ）
        super.onListItemClick(l, v, position, id);
        savedPosition = position;
        if (isDualPane) {
            listner.onTitleSelected(position);
        } else {
            Intent intent = new Intent(getActivity(), SubActivity.class);//画面遷移に使うもの
            intent.putExtra(EXTRA_POSITION, position);//起動させるだけではなく起動させる側から何らかの情報を渡したいとき
            startActivity(intent);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
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
}
