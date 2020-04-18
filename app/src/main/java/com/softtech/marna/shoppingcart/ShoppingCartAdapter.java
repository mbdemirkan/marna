package com.softtech.marna.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.softtech.marna.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter  extends ArrayAdapter<Product> {

    private OnClickListener clickListener;

    public ShoppingCartAdapter(Context context, List<Product> items,OnClickListener onClickListener ) {
        super(context, R.layout.shopping_cart_item, items);
        this.clickListener = onClickListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.shopping_cart_item, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView)view.findViewById(R.id.txtName);
            viewHolder.txtNumber = (TextView)view.findViewById(R.id.txtNumber);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Product product = getItem(position);

        setClickListeners(viewHolder.imgCall);  // arama imagebuttona tıklanma eventi ver
        setClickListeners(viewHolder.imgMsg);   // mesaj gönderme imagebuttona tıklanma eventi ver

        setTagsToViews(viewHolder.imgCall, position);  // arama imagebuttona tag olarak position ver
        setTagsToViews(viewHolder.imgMsg, position);  // mesaj gönderme imagebuttona tag olarak position ver

        viewHolder.imgMsg.setTag(position);
        viewHolder.imgCall.setTag(position);
        viewHolder.txtName.setText(product.getName());
        viewHolder.txtNumber.setText(product.getStore());

        return view;
    }

    private void setTagsToViews(View view, int position) {
        //view.setTag(R.id.key_position, position);
    }

    private void setClickListeners(View view) {
        view.setOnClickListener(clickListener);
    }

    private static class ViewHolder {
        TextView txtName;
        TextView txtNumber;
        ImageButton imgCall;
        ImageButton imgMsg;
    }
}
