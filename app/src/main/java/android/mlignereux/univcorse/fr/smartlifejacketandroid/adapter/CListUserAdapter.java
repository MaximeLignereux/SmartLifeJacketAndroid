package android.mlignereux.univcorse.fr.smartlifejacketandroid.adapter;

import android.content.Context;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.R;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CAthlete;
import android.mlignereux.univcorse.fr.smartlifejacketandroid.entity.CUser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asus on 27/11/2015.
 */
public class CListUserAdapter extends ArrayAdapter<CAthlete> {


    public CListUserAdapter(Context context, List<CAthlete> users) {
        super(context, R.layout.item_list, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater mInflater = LayoutInflater.from(getContext());
            convertView = mInflater.inflate(R.layout.item_list, parent, false);

            holder = new ViewHolder();

            holder.mName = (TextView)convertView.findViewById(R.id.text_name);
            holder.mCheckBox = (CheckBox) convertView.findViewById(R.id.checkbox);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();


        }

        CUser content = getItem(position);

        holder.mName.setText(content.getEmail());

        return convertView;
    }

    public static class ViewHolder {
        public TextView mName;
        public CheckBox mCheckBox;
    }
}
