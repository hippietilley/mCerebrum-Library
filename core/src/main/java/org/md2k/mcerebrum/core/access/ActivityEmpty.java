package org.md2k.mcerebrum.core.access;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.md2k.mcerebrum.core.R;

public class ActivityEmpty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }
}
