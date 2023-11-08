package quanpnph29471.example.duanmauquanpn.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import quanpnph29471.example.duanmauquanpn.R;
import quanpnph29471.example.duanmauquanpn.adapter.TopAdapter;
import quanpnph29471.example.duanmauquanpn.dao.ThongKeDAO;
import quanpnph29471.example.duanmauquanpn.model.Top;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopFragment extends Fragment {

    ListView listView;

    ThongKeDAO dao;
    List<Top> list;
    TopAdapter topAdapter;


    public TopFragment() {
        // Required empty public constructor
    }


    public static TopFragment newInstance() {
        TopFragment fragment = new TopFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.top_listview);
        loadTable();
    }
    private void loadTable(){
        dao = new ThongKeDAO(getActivity());
        list = dao.getTop();
        topAdapter = new TopAdapter(getActivity(), R.layout.item_lv_top,list);
        listView.setAdapter(topAdapter);
    }
}