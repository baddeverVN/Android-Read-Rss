package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhtien.btbuoi10.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
;

import Objects.Item;

/**
 * Created by minhtien on 12/01/2016.
 */
public class AdapterMain extends ArrayAdapter<Item> {
    private ArrayList<Item> arrs;
    private LayoutInflater layoutInflater;
    private Context context;
    public AdapterMain(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        arrs = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.activity_item_main,parent,false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgNews);
        TextView textView = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView textView1 = (TextView) convertView.findViewById(R.id.txtDate);
        Picasso.with(getContext())
                .load(arrs.get(position).getImage())
                .into(imageView);
        textView.setText(arrs.get(position).getTitle());
        textView1.setText(arrs.get(position).getPubDate());
        return convertView;
    }
}
