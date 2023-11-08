package quanpnph29471.example.duanmauquanpn.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import quanpnph29471.example.duanmauquanpn.R;
import quanpnph29471.example.duanmauquanpn.model.ThuThu;


public class ThuThuAdapter extends ArrayAdapter<ThuThu> {
    private Context context;
    private int resource;
    private List<ThuThu> objects;
    private LayoutInflater inflater;
    String a="*";

    public ThuThuAdapter(Context context, int resource, List objects) {
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
            convertView = inflater.inflate(R.layout.item_lv_add_tv_2,null);
            holder.soTk = (TextView)convertView.findViewById(R.id.item_lv_soTK);
            holder.tvusername = (TextView)convertView.findViewById(R.id.item_lv_username);
            holder.tvname = (TextView)convertView.findViewById(R.id.item_lv_name);
            holder.tvpass = (TextView)convertView.findViewById(R.id.item_lv_pass);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        ThuThu tt = objects.get(position);

        String laySoTK = position+1+"";
        if (Integer.valueOf(laySoTK)%5==0){
            holder.soTk.setTypeface(null, Typeface.BOLD);
        }
        holder.soTk.setText(laySoTK);
        holder.tvusername.setText(tt.maTT);
        holder.tvname.setText(tt.hoTen);
        String temp = tt.matKhau;
        for (int i = 0; i < temp.length(); i++) {
            a=a.concat("*");
        }
        holder.tvpass.setText(a);
        a="";

        return convertView;
    }

    public class ViewHolder{
        TextView tvusername,tvname,tvpass,soTk;
    }
}
