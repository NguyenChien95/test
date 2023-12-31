package quanpnph29471.example.duanmauquanpn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import quanpnph29471.example.duanmauquanpn.R;
import quanpnph29471.example.duanmauquanpn.model.ThanhVien;


public class ThanhVienAdapter extends ArrayAdapter<ThanhVien> {
    private Context context;
    private int resource;
    private List<ThanhVien> objects;
    private LayoutInflater inflater;

    public ThanhVienAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
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
        ThanhVien tv = objects.get(position);
        holder.tvmatv.setText(String.valueOf(tv.maTV));
        holder.tvtentv.setText(tv.hoTen);
        holder.tvnamsinhtv.setText(tv.namSinh);

        holder.temp1.setText("Mã Thành Viên: ");
        holder.temp2.setText("Tên Thành Viên: ");
        holder.temp3.setText("Năm Sinh: ");

        return convertView;
    }

    public class ViewHolder{
        TextView tvmatv,tvtentv,tvnamsinhtv,temp1,temp2,temp3;
    }
}
