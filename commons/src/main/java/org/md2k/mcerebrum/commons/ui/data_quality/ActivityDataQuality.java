package org.md2k.mcerebrum.commons.ui.data_quality;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;


import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceType;
import org.md2k.datakitapi.source.platform.Platform;
import org.md2k.datakitapi.source.platform.PlatformBuilder;
import org.md2k.mcerebrum.commons.R;

import mehdi.sakout.fancybuttons.FancyButton;

public class ActivityDataQuality extends FragmentActivity {
    FancyButton buttonPlot;
    FancyButton buttonVideo;
    FancyButton buttonClose;
//    ConfigDataQuality configDataQuality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Defines the xml file for the fragment
        setContentView(R.layout.activity_data_quality);
        String title = getIntent().getStringExtra("title");
        String message = getIntent().getStringExtra("message");
        final String video_link = getIntent().getStringExtra("video_link");
        final DataSource datasource = (DataSource) (getIntent().getParcelableExtra("datasource"));
//        configDataQuality=getIntent().getParcelableExtra(ConfigDataQuality.class.getSimpleName());
        ((TextView) findViewById(R.id.textview_title)).setText(title);
        ((TextView) findViewById(R.id.textview_content)).setText(message);


        buttonPlot = (FancyButton) findViewById(R.id.button_graph);
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                Platform p=datasource.getPlatform();
                org.md2k.datakitapi.source.datasource.DataSource d = new DataSourceBuilder().setType(DataSourceType.ACCELEROMETER).setPlatform(p).build();
                b.putParcelable(org.md2k.datakitapi.source.datasource.DataSource.class.getSimpleName(), d);
                intent.putExtras(b);
                intent.setComponent(new ComponentName("org.md2k.motionsense", "org.md2k.motionsense.plot.ActivityPlot"));
                intent.putExtra("datasource", datasource);
                startActivity(intent);
//

//                Intent intent=new Intent(ActivityLeftWrist.this,ActivityPieChartDataCollection.class);


//                startActivity(intent);
            }
        });

        buttonVideo = (FancyButton) findViewById(R.id.button_video);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityDataQuality.this, ActivityYouTube.class);
                intent.putExtra("video_link", video_link);
                startActivity(intent);

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
