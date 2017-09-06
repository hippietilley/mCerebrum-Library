package org.md2k.mcerebrum.core.access;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.md2k.mcerebrum.core.access.Access;
import org.md2k.mcerebrum.core.access.Info;


public abstract class AbstractActivityMCerebrumAccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int request = getIntent().getIntExtra(Access.REQUEST, -1);
        Intent returnIntent = new Intent();
        try {
            switch (request) {
                case Access.REQUEST_INITIALIZE:
                    returnIntent.putExtra(Access.RESPONSE, initialize());
                    break;
                case Access.REQUEST_CONFIGURE:
                    returnIntent.putExtra(Access.RESPONSE, configure());
                    break;
                case Access.REQUEST_START:
                    if (isRunning())
                        returnIntent.putExtra(Access.RESPONSE, true);
                    else {
                        start();
                        returnIntent.putExtra(Access.RESPONSE, true);
                    }
                    break;
                case Access.REQUEST_STOP:
                    if (isRunning()) {
                        stop();
                    }
                    returnIntent.putExtra(Access.RESPONSE, true);
                    break;
                case Access.REQUEST_INFO:
                    returnIntent.putExtra(Access.RESPONSE, getInfo());
                    break;
                case Access.REQUEST_REPORT:
                    returnIntent.putExtra(Access.RESPONSE, plot());
                    break;
                case Access.REQUEST_CLEAR:
                    returnIntent.putExtra(Access.RESPONSE, clear());
                    break;
                default:
                    returnIntent.putExtra(Access.RESPONSE, Access.RESPONSE_INVALID_REQUEST);
                    break;

            }
        }catch (Exception ignored){
            returnIntent.putExtra(Access.RESPONSE, Access.RESPONSE_INVALID_REQUEST);
        }
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    public boolean initialize() {
        return true;
    }

    public boolean isConfigured() {
        return true;
    }

    public boolean configure() {
        return true;
    }

    public boolean isRunning() {
        return false;
    }

    public long runningTime() {
        return -1;
    }

    public boolean start() {
        return false;
    }

    public boolean stop() {
        return false;
    }
    public boolean isConfigurable(){
        return false;
    }

    public Info getInfo() {
        return new Info(this.getPackageName(), isConfigurable(), isConfigured(), isRunning(), runningTime(), IsRunInBackground(), hasReport());
    }

    private boolean hasReport() {
        return false;
    }

    private boolean IsRunInBackground() {
        return false;
    }

    public boolean plot() {
        return false;
    }

    public boolean clear() {
        return true;
    }
}
