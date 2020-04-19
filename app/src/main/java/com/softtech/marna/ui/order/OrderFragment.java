package com.softtech.marna.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.softtech.marna.R;

public class OrderFragment extends Fragment {

    private OrderViewModel homeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_siparis_durumu, container, false);

        String[] ulkeler =
                {"15 numaralı sipariş: Hazırlanıyor", "16 numaralı sipariş: Göndrrildi"};
//(A) adımı
        ListView listemiz=(ListView) view.findViewById(R.id.orderStatusListView);

        //(B) adımı
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        //(C) adımı
        listemiz.setAdapter(veriAdaptoru);

        return view;
    }
}
