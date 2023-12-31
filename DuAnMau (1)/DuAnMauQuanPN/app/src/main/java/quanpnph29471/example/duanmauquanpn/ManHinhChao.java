package quanpnph29471.example.duanmauquanpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import quanpnph29471.example.duanmauquanpn.dao.ThuThuDAO;
import quanpnph29471.example.duanmauquanpn.model.ThuThu;

public class ManHinhChao extends AppCompatActivity {
    ConstraintLayout layout;
    ThuThuDAO dao;
    List<ThuThu> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);
        layout = findViewById(R.id.id_constraintlayout);

        dao = new ThuThuDAO(ManHinhChao.this);
        list = new ArrayList<>();
        list = dao.getAll();

        if (list.size() == 0){
            dao.insertadmin();
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                layout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ManHinhChao.this, ManHinhChao2.class);
                startActivity(intent);
            }
        },3000);
    }

}