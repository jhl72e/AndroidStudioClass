package com.example.mypager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class TwoFragment extends ListFragment {

    String[] datas;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //데이터 준비
        datas = new String[]{"나정휘", "조성진", "최효승", "한정원"};
        //어뎁터 생성
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, datas);
        //어뎁터 설정
        setListAdapter(aa);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), datas[position], Toast.LENGTH_SHORT).show();
    }
}
