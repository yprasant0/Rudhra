package com.gracetex.revo.rudhra;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.gracetex.revo.rudhra.PermissionData;

import static android.content.DialogInterface.*;

/**
 * Created by midhul on 11/15/2016.
 */

public class PermissionDescription extends Activity {
    private TextView tvPermissionHeader;
    private TextView tvPermissionDescription;
    private TextView tvMaliciousUseDescription;

    private PermissionGetter permissionGetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_description_layout);
        this.setFinishOnTouchOutside(false);
        this.setTitle("Description");

        // Initializing views.
        tvPermissionHeader = (TextView) this
                .findViewById(R.id.tvPermissionHeader);
        tvPermissionDescription = (TextView) this
                .findViewById(R.id.tvPermissionDescription);
        tvMaliciousUseDescription = (TextView) this
                .findViewById(R.id.tvMaliciousUseDescription);

        Button btnFinish = (Button) findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(new OnClickListener() {


            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                PermissionDescription.this.finish();
            }
        });

        permissionGetter = new PermissionGetter(getPackageManager(), this);

        // Getting required Data
        String permission = getIntent().getStringExtra("PERMISSION_NAME");
        PermissionData pd = null;
        pd = permissionGetter.generatePermissionData(permission);

        // Setting view properties.
        if (pd != null) {
            tvPermissionHeader.setText(pd.getPermissionName());
            tvPermissionDescription.setText(pd.getDescription());
            tvMaliciousUseDescription.setText(pd.getMaliciousUseDescription());
        }
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
}
