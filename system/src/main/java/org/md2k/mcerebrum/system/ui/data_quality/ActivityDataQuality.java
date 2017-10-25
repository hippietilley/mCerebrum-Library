package org.md2k.mcerebrum.system.ui.data_quality;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import org.md2k.mcerebrum.system.R;

import mehdi.sakout.fancybuttons.FancyButton;

public class ActivityDataQuality extends FragmentActivity {
    FancyButton buttonPlot;
    FancyButton buttonVideo;
    FancyButton buttonClose;
    ConfigDataQuality configDataQuality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Defines the xml file for the fragment
        setContentView(R.layout.activity_data_quality);
        configDataQuality=getIntent().getParcelableExtra(ConfigDataQuality.class.getSimpleName());
        ((TextView) findViewById(R.id.textview_title)).setText(configDataQuality.title);

        buttonPlot = (FancyButton) findViewById(R.id.button_graph);
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
/*
                b.putParcelable(DataSource.class.getSimpleName(), d);
                intent.putExtras(b);
                intent.setComponent(new ComponentName("org.md2k.motionsense", "org.md2k.motionsense.plot.ActivityPlot"));
                startActivity(intent);
*/
//                Intent intent=new Intent(ActivityLeftWrist.this,ActivityPieChartDataCollection.class);
//                startActivity(intent);
            }
        });

        buttonVideo = (FancyButton) findViewById(R.id.button_video);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                Intent intent = new Intent(ActivityLeftWrist.this, ActivityYouTube.class);
                startActivity(intent);
*/
            }
        });

        buttonClose = (FancyButton) findViewById(R.id.button_close);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
