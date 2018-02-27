/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
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

package org.md2k.mcerebrum.commons.ui.day;

import android.os.Handler;
import android.view.View;

import org.md2k.datakitapi.time.DateTime;
import org.md2k.mcerebrum.commons.R;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * TODO: Ask about this zombie class.
 */
public class UserViewDay {
/*
    private static final String TAG = UserViewDay.class.getSimpleName();
    private Handler handler;
    private DayManager dayManager;
    private ViewDay viewDay;
    public UserViewDay(ViewDay viewDay) {
        handler = new Handler();
        this.viewDay = viewDay;
        dayManager = new DayManager();
    }


/*
    private Runnable runnableDay = new Runnable() {
        @Override
        public void run() {
            dayManager.set(viewDay.getContext());
           */
/* viewDay.setButtons(dayManager.getWakeupTime()
            long remainingTime = dayManager.getRemainingTime();
            if (remainingTime > 0) {
                remainingTime /= 1000;
                int sec = (int) (remainingTime % 60);
                remainingTime /= 60;
                int min = (int) (remainingTime % 60);
                remainingTime /= 60;
                int hour = (int) (remainingTime);
                String show = "Resumed after " + String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, min, sec);
                AwesomeTextView t = ((AwesomeTextView) viewPrivacy.findViewById(R.id.textview_privacy_status));
                t.setBootstrapText(new BootstrapText.Builder(viewPrivacy.getContext()).addText(show).build());
                t.setBootstrapBrand(DefaultBootstrapBrand.DANGER);
//                t.setText(show);
                *//*
*/
/*
//                t.setTextColor(ContextCompat.getColor(viewPrivacy.getContext(), R.color.headerOrange));
                FancyButton button = (FancyButton) viewPrivacy.findViewById(R.id.btn_pause_resume_data_collection);
                button.setFontIconSize(16);
                button.setIconResource("\uf00d");

            button.setIconColor(ContextCompat.getColor(viewPrivacy.getContext(), R.color.headerOrange));
            *//*
}
        }
    };
*/


    private void prepareButton() {
/*        FancyButton button;
  */
/*      final long lastTime= DateTime.getDateTime();
        button = (FancyButton) viewDay.findViewById(R.id.btn_pause_resume_data_collection);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
*//*
*/
/*
                if(DateTime.getDateTime()-lastTime<500) return;
                Intent intent = new Intent();
                intent.setClassName("org.md2k.datakit", "org.md2k.datakit.ActivityPrivacy");
                viewPrivacy.getContext().startActivity(intent);
*//*
*/
/*
            }
        });
  *//*
  }
    public void set() {
/*
        handler.removeCallbacks(runnableDay);
        prepareButton();
        handler.post(runnableDay);
*/
    }

    public void clear() {
//        handler.removeCallbacks(runnablePrivacy);
    }

}
