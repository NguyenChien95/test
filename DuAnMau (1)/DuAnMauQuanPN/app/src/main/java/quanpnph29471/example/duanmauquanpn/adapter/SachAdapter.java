package quanpnph29471.example.duanmauquanpn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import quanpnph29471.example.duanmauquanpn.R;
import quanpnph29471.example.duanmauquanpn.model.Sach;


public class SachAdapter extends ArrayAdapter<Sach> {

    private Context context;
    private int resource;
    private List<Sach> objects;
    private LayoutInflater inflater;

    public SachAdapter(Context context, int resource, List objects) {
        super(context, resource,objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            convertView = inflater.inflate(R.layout.item_sach,null);
            holder.tvSoLuong = (TextView)convertView.findViewById(R.id.item_sach_soLuong);
            holder.tvmasach = (TextView)convertView.findViewById(R.id.item_sach_masach);
            holder.tvtensach = (TextView)convertView.findViewById(R.id.item_sach_tensach);
            holder.tvgiathue = (TextView)convertView.findViewById(R.id.item_sach_giathue);
            holder.tvmaloai = (TextView)convertView.findViewById(R.id.item_sach_maloai);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        Sach sach = objects.get(position);
        holder.tvmasach.setText("Mã: "+sach.maSach);
        holder.tvtensach.setText("Tên Sách: "+sach.tenSach);
        holder.tvgiathue.setText("Giá Thuê: "+sach.giaThue);
        holder.tvmaloai.setText("Mã Loai: "+sach.maLoai);

        return convertView;
    }

    public class ViewHolder{
        TextView tvmasach,tvtensach,tvgiathue,tvmaloai,tvSoLuong;
    }
}
