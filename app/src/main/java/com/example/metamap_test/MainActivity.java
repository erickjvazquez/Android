package com.example.metamap_test;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.metamap.metamap_sdk.Metadata;
import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.MetamapSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        this.<MetamapButton>findViewById(R.id.metamapButton).setParams(
                this,
                "clientId",
                "FlowId",
                new Metadata.Builder()
                        .with("buttonColor", Color.parseColor("#FF0000"))
                        .with("buttonTextColor", Color.parseColor("#FFFFFF"))
                        .build());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MetamapSdk.DEFAULT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // There are no request codes
                Toast.makeText(
                        this,
                        "onActivityResult Verification success! " +
                                "VerificationId: ${data.getStringExtra(HeatmapSdk.ARG_VERIFICATION_ID)}, " +
                                "IdentityId: ${data.getStringExtra(HeatmapSdk.ARG_IDENTITY_ID)}",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                if (data != null) {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled! " +
                                    "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                    "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}


