package com.example.hoyeonlee.example.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hoyeonlee.example.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomerActivity extends AppCompatActivity {

    @BindView(R.id.menuReserveBtn)
    Button menuReserveBtn;
    @BindView(R.id.checkReserveBtn)
    Button checkReserveBtn;
    @BindView(R.id.purchaseHistoryBtn)
    Button purchaseHistoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.menuReserveBtn, R.id.checkReserveBtn, R.id.purchaseHistoryBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menuReserveBtn:
                Intent it=new Intent(this,MenuReservationActivity.class);
                startActivity(it);
                break;
            case R.id.checkReserveBtn:
                break;
            case R.id.purchaseHistoryBtn:
                break;
        }
    }
}