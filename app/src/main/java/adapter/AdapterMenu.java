package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhtien.btbuoi10.R;

import java.util.ArrayList;

import Objects.Cate;


/**
 * Created by minhtien on 12/01/2016.
 */
public class AdapterMenu extends ArrayAdapter<Cate>{
    private ArrayList<Cate> arrayList;
    private LayoutInflater layoutInflater;
    public AdapterMenu(Context context, int resource, ArrayList<Cate> objects) {
        super(context, resource, objects);
        arrayList = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.activity_item_menu,parent,false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgCate);
        TextView textView = (TextView) convertView.findViewById(R.id.txtCate);
        imageView.setImageResource(arrayList.get(position).getImage());
        textView.setText(arrayList.get(position).getNameCate());
        return convertView;
    }
}
