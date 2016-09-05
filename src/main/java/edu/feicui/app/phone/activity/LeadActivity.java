package edu.feicui.app.phone.activity;

import android.os.Bundle;

import edu.feicui.app.phone.base.util.BaseActivity;

public class LeadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        startActivity(LogoActivity.class);
    }
}
