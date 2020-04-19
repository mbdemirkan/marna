package com.softtech.marna.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.softtech.marna.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List listDataHeader;
    private HashMap<String, List<String>> listHash;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel =
                ViewModelProviders.of(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        listView = root.findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);
        return root;
    }

    private void initData() {

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Meyve Sebze");
        listDataHeader.add("Et Tavuk Balık");
        listDataHeader.add("Kahvaltılık");
        listDataHeader.add("Biskuvi Çikolata");
        listDataHeader.add("İçecek");
        listDataHeader.add("Temizlik");

        List liste1 = new ArrayList<>();
        liste1.add("Elma");
        liste1.add("Armut");
        liste1.add("Maydanoz");
        liste1.add("Patates");

        List liste2 = new ArrayList<>();
        liste2.add("Dana Kıyma");
        liste2.add("Sucuk");
        liste2.add("Tavuk But");
        liste2.add("Hamsi");

        List liste3 = new ArrayList<>();
        liste3.add("Peynir");
        liste3.add("Zeytin");
        liste3.add("Tahin");
        liste3.add("Pekmez");

        List liste4 = new ArrayList<>();
        liste4.add("Gofret");
        liste4.add("Biskuvi");
        liste4.add("Çikolata");
        liste4.add("Şekerleme");

        List liste5 = new ArrayList<>();
        liste5.add("Su");
        liste5.add("Ayran");
        liste5.add("Enerji İçeceği");
        liste5.add("Kola");

        List liste6 = new ArrayList<>();
        liste6.add("Çamaşır Deterjanı");
        liste6.add("Çamaşır Suyu");
        liste6.add("Bulaşık Deterjanı");
        liste6.add("Çöp Poşeti");


        listHash.put((String) listDataHeader.get(0), liste1);
        listHash.put((String) listDataHeader.get(1), liste2);
        listHash.put((String) listDataHeader.get(2), liste3);
        listHash.put((String) listDataHeader.get(3), liste4);
        listHash.put((String) listDataHeader.get(4), liste5);
        listHash.put((String) listDataHeader.get(5), liste6);
    }
}