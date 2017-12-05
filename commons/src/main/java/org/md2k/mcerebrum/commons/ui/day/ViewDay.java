package org.md2k.mcerebrum.commons.ui.day;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.md2k.datakitapi.time.DateTime;
import org.md2k.mcerebrum.commons.R;

import mehdi.sakout.fancybuttons.FancyButton;

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
    public ViewDay(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_day, this, true);

    }
    public ViewDay(Context context) {
        this(context, null);
    }
    public void setButtons(long w1, long s1, long w2, long s2, long ds, long de){
        long c = DateTime.getDateTime();
        if(w1<0 || s1<0){
            set(false, false);
        }else if(ds<0 || ds<w1){
            if(w1<c && c<s1){
                set(true, false);
            }else if(s1<c){
                set(false, false);
            }
        }else{
            if(ds<0){
                if(ds<s1){
                    set(false, true);
                }else{
                    set(false, false);
                }
            }else if(ds<de){
                set(false, false);
            }
            else if(ds>de){
                set(false, true);
            }
        }
    }
    private void set(boolean s1, boolean s2){
/*
        FancyButton bs = findViewById(R.id.button_start);
        FancyButton be = findViewById(R.id.button_end);
        bs.setEnabled(s1);
        be.setEnabled(s2);
*/
    }
}
