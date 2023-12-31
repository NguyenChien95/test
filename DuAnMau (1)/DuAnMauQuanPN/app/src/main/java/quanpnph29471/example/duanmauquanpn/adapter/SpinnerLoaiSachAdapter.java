package quanpnph29471.example.duanmauquanpn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import quanpnph29471.example.duanmauquanpn.R;
import quanpnph29471.example.duanmauquanpn.model.LoaiSach;


public class SpinnerLoaiSachAdapter extends ArrayAdapter<LoaiSach> {
    private  Context context;
    private ArrayList<LoaiSach> objects;
    TextView tvspnma,tvspnnsx,tvspnten;

    public SpinnerLoaiSachAdapter(Context context, ArrayList<LoaiSach> objects ) {
        super(context, 0,objects);
        this.context = context;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.spinner_adapter_loaisach,null);

        }
        final LoaiSach ls = objects.get(position);
        if (ls != null){
            tvspnma = holder.findViewById(R.id.item_spn_ma);
            tvspnma.setText(String.valueOf(ls.maLoai));
            tvspnnsx = holder.findViewById(R.id.item_spn_nsx);
            tvspnnsx.setText(ls.nhaSX);
            tvspnten = holder.findViewById(R.id.item_spn_ten);
            tvspnten.setText(ls.tenLoai);
        }
        return holder;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.spinner_adapter_loaisach,null);

        }
        final LoaiSach ls = objects.get(position);
        if (ls != null){
            tvspnma = holder.findViewById(R.id.item_spn_ma);
            tvspnma.setText(String.valueOf(ls.maLoai));
            tvspnnsx = holder.findViewById(R.id.item_spn_nsx);
            tvspnnsx.setText(ls.nhaSX);
            tvspnten = holder.findViewById(R.id.item_spn_ten);
            tvspnten.setText(ls.tenLoai);
        }
        return holder;
    }

}
