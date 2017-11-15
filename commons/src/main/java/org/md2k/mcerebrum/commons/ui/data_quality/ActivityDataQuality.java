package org.md2k.mcerebrum.commons.ui.data_quality;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.exception.DataKitException;
import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceClient;
import org.md2k.datakitapi.source.datasource.DataSourceType;
import org.md2k.datakitapi.source.platform.Platform;
import org.md2k.datakitapi.source.platform.PlatformBuilder;
import org.md2k.mcerebrum.commons.R;
import org.md2k.mcerebrum.core.access.appinfo.AppCP;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
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
        final String title = getIntent().getStringExtra("title");
        String message = getIntent().getStringExtra("message");
        final String video_link = getIntent().getStringExtra("video_link");
        final DataSource read = getIntent().getParcelableExtra("read");
        final DataSource plot = getIntent().getParcelableExtra("plot");
//        configDataQuality=getll Intent().getParcelableExtra(ConfigDataQuality.class.getSimpleName());
        ((TextView) findViewById(R.id.textview_title)).setText(title);
        ((TextView) findViewById(R.id.textview_content)).setText(message);


        buttonPlot = (FancyButton) findViewById(R.id.button_graph);
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                DataKitAPI dataKitAPI=DataKitAPI.getInstance(ActivityDataQuality.this);
                try {
                    ArrayList<DataSourceClient> ds = dataKitAPI.find(new DataSourceBuilder(plot));
                    if(ds.size()==0){
                        Toasty.error(ActivityDataQuality.this, "Device not registered with datakit", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    b.putParcelable(org.md2k.datakitapi.source.datasource.DataSource.class.getSimpleName(), ds.get(0).getDataSource());
                    intent.putExtra(DataSource.class.getSimpleName(), ds.get(0).getDataSource());
                    intent.putExtras(b);
                    String packageName = ds.get(0).getDataSource().getApplication().getId();
                    intent.setComponent(new ComponentName(packageName, AppCP.getFuncReport(ActivityDataQuality.this, packageName)));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                intent.putExtra ("title", title);

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
