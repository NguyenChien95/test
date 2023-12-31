package quanpnph29471.example.duanmauquanpn.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import quanpnph29471.example.duanmauquanpn.R;
import quanpnph29471.example.duanmauquanpn.model.LoaiSach;


public class LoaiSachAdapter extends ArrayAdapter<LoaiSach> {
    private  Context context;
    private int resource;
    private List<LoaiSach> objects;
    private LayoutInflater inflater;
    private ArrayList<LoaiSach> list;
    public LoaiSachAdapter(Context context, int resource,List<LoaiSach> objects) {
        super(context, resource , objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

        this.list  = new ArrayList<LoaiSach>();
        this.list.addAll(objects);

        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            convertView = inflater.inflate(R.layout.item_lv_addtv,null);
            holder.tvmatv = (TextView)convertView.findViewById(R.id.item_lv_username);
            holder.tvtentv = (TextView)convertView.findViewById(R.id.item_lv_name);
            holder.tvnamsinhtv = (TextView)convertView.findViewById(R.id.item_lv_pass);

            holder.temp1 = (TextView)convertView.findViewById(R.id.temp_1);
            holder.temp2 = (TextView)convertView.findViewById(R.id.temp_2);
            holder.temp3 = (TextView)convertView.findViewById(R.id.temp_3);

            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        LoaiSach ls = objects.get(position);
        holder.tvmatv.setText(String.valueOf(ls.maLoai));
        holder.tvtentv.setText(ls.nhaSX);
        holder.tvnamsinhtv.setText(ls.tenLoai);

        if (ls.nhaSX.contains("A")&&ls.nhaSX.contains("N")){
            holder.tvtentv.setTextColor(Color.YELLOW);
        }else if (ls.nhaSX.contains("A")){
            holder.tvtentv.setTextColor(Color.RED);
        }else if (ls.nhaSX.contains("N")){
            holder.tvtentv.setTextColor(Color.GREEN);
        }

        holder.temp1.setText("Mã Loại Sách: ");
        holder.temp2.setText("Nhà Sản Xuất: ");
        holder.temp3.setText("Tên Loại: ");

        return convertView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        objects.clear();
        if (charText.length() == 0){
            objects.addAll(list);
        }else {
            for (LoaiSach ls : list) {
                if (ls.nhaSX.toLowerCase(Locale.getDefault()).contains(charText)){
                    objects.add(ls);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView tvmatv,tvtentv,tvnamsinhtv,temp1,temp2,temp3;
    }
}
