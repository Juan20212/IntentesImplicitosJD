package com.example.intentesimplicitosjd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditTex;

    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditTex=(EditText) findViewById(R.id.website_edittext);
        mShareTextEditText=findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url=mWebsiteEditTex.getText().toString();
        Uri webpage= Uri.parse(url);
        Intent intent= new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager())!= null) {
            startActivity(intent);
        }else {
            Log.d("implicitIntents","Can't handle this!");
        }
    }

    public void shareText(View view) {

        String txt= mShareTextEditText.getText().toString();
        String mimeType= "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share this text with: ")
                .setText(txt)
                .startChooser();

    }
}