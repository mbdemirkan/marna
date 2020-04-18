package com.softtech.marna.ui.shoppingcart;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.softtech.marna.R;
import com.softtech.marna.shoppingcart.Product;
import com.softtech.marna.shoppingcart.ShoppingCartAdapter;
import com.softtech.marna.ui.order.OrderViewModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShoppingCartFragment extends Fragment {

    public List<Product> list_items = new ArrayList<Product>();
    private ShoppingCartAdapter listviewAdapter;
    private ListView listview_contacts;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart_list, container, false);

        listview_contacts = (ListView)view.findViewById(R.id.shopping_cart_list);
        listview_contacts.setItemsCanFocus(false);

        if (list_items.size() == 0 ) {   // liste dolu ise tekrardan Async Task çağırma
            new FetchAsyncTask().execute();
        } else {

        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  // geri tuşuna bastığımızda listview in aynen kalması için gerekli
        super.onActivityCreated(savedInstanceState);
        this.listview_contacts.setAdapter(this.listviewAdapter);
    }

    public  class FetchAsyncTask extends AsyncTask<Void,Void,List<Product>> {
        @Override
        protected void onPreExecute() {

            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Yükleniyor...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected List<Product> doInBackground(Void... params) {
            list_items.add(new Product("Name", "Store", new BigDecimal("100.12"), 5));
            list_items.add(new Product("Name2", "Store2", new BigDecimal("100.12"), 5));
            return list_items;
        }

        @Override
        protected void onPostExecute(List contactList) {
            listviewAdapter = new ShoppingCartAdapter(getActivity(),contactList, null); // ListViewFragment.this
            listview_contacts.setAdapter(listviewAdapter);

            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }
}
