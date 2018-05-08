package org.md2k.mcerebrum.commons.ui.day;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mikepenz.materialize.color.Material;

import org.md2k.datakitapi.time.DateTime;
import org.md2k.mcerebrum.commons.R;
import org.md2k.mcerebrum.commons.dialog.Dialog;
import org.md2k.mcerebrum.commons.dialog.DialogCallback;

import mehdi.sakout.fancybuttons.FancyButton;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;

/**
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p>
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * <p>
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class ViewDay extends LinearLayout {
    private Activity activity;
    private CallbackDay callbackDay;
    private boolean isStartActive = false;
    private boolean isEndActive = false;
    private Subscription subscription;
    PhoneTone phoneTone;
    PhoneDialog phoneDialog;

    public ViewDay(Activity activity, AttributeSet attrs) {
        super(activity, attrs);
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_day, this, true);
        LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(LLParams);
        this.activity = activity;
        this.phoneTone = new PhoneTone(activity);
        this.phoneDialog = new PhoneDialog(activity);
    }

    public void setCallbackDay(CallbackDay callbackDay) {
        this.callbackDay = callbackDay;
    }

    public ViewDay(Activity context) {
        this(context, null);
    }

    public void setStartButton(boolean isActive, int color, String text) {
        final FancyButton bs = (FancyButton) findViewById(R.id.button_start);
//        bs.setEnabled(isActive);
        bs.setText(text);
        bs.setTextColor(color);
        isStartActive = isActive;
        bs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isStartActive) return;
                Dialog.simple(activity, "Start Day", "Start the day now?", "Yes", "Cancel", new DialogCallback() {
                    @Override
                    public void onSelected(String value) {
                        if (value.equalsIgnoreCase("Yes")) {
                            callbackDay.onReceive("START");
                        }
                    }
                }).show();
            }
        });

    }

    public void setEndButton(boolean isActive, int color, String text) {
        FancyButton bs = (FancyButton) findViewById(R.id.button_end);
//        bs.setEnabled(isActive);
        bs.setText(text);
        bs.setTextColor(color);
        isEndActive = isActive;
        bs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEndActive) return;
                Dialog.simple(activity, "End Day", "End the day now?", "Yes", "Cancel", new DialogCallback() {
                    @Override
                    public void onSelected(String value) {
                        if (value.equalsIgnoreCase("Yes")) {
                            callbackDay.onReceive("END");
                        }
                    }
                }).show();
            }
        });

    }

    public void removeNotify() {
        Log.d("abc","Day: ViewDay -> removeNotify()");
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
        subscription = null;
    }

    public void setNotify(String format, long interval) {
        Log.d("abc","Day: ViewDay -> setNotify()");

        subscription = Observable.merge(phoneTone.getObservable(format, interval), phoneDialog.getObservable())
                .takeWhile(new Func1<Boolean, Boolean>() {
                    @Override
                    public Boolean call(Boolean aBoolean) {
                        if (aBoolean) {
                            callbackDay.onReceive("START");
                        }
                        return !aBoolean;
                    }
                })
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Boolean integer) {

                    }
                });
    }
}
