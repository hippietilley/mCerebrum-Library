package org.md2k.mcerebrum.commons.ui.buttons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


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

public class ViewButtons extends LinearLayout {
    public ViewButtons(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_buttons, this, true);
        for(int i=1;i<=6;i++){
            FancyButton b=getButton(i);
         //   b.setVisibility(INVISIBLE);
        }
    }

    public ViewButtons(Context context) {
        this(context, null);
    }


    FancyButton getButton(int index){
        switch(index){
            case 1: return (FancyButton) findViewById(R.id.button_1);
            case 2: return (FancyButton) findViewById(R.id.button_2);
            case 3: return (FancyButton) findViewById(R.id.button_3);
            case 4: return (FancyButton) findViewById(R.id.button_4);
            case 5: return (FancyButton) findViewById(R.id.button_5);
            case 6: return (FancyButton) findViewById(R.id.button_6);
            default: return (FancyButton) findViewById(R.id.button_1);
        }
    }

    ImageView getImageView(int index){
        switch(index){
            case 1: return (ImageView) findViewById(R.id.imageview_button_1);

            case 2: return (ImageView) findViewById(R.id.imageview_button_2);
            case 3: return (ImageView) findViewById(R.id.imageview_button_3);
            case 4: return (ImageView) findViewById(R.id.imageview_button_4);
            case 5: return (ImageView) findViewById(R.id.imageview_button_5);
            case 6: return (ImageView) findViewById(R.id.imageview_button_6);

            default: return (ImageView) findViewById(R.id.imageview_button_1);
        }
    }
    TextView getTextView(int index){
        switch(index){
            case 1: return (TextView) findViewById(R.id.textview_button_1);

            case 2: return (TextView) findViewById(R.id.textview_button_2);
            case 3: return (TextView) findViewById(R.id.textview_button_3);
            case 4: return (TextView) findViewById(R.id.textview_button_4);
            case 5: return (TextView) findViewById(R.id.textview_button_5);
            case 6: return (TextView) findViewById(R.id.textview_button_6);

            default: return (TextView) findViewById(R.id.textview_button_1);
        }
    }

    public void addButton(int index, String title, Drawable image, OnClickListener onClickListener) {
        ImageView i = getImageView (index);
        TextView t = getTextView (index);
        i.setImageDrawable (image);
        FancyButton b=getButton(index);
            t.setText(title);
            b.setVisibility(VISIBLE);
                  i.setImageDrawable (image);
            b.setOnClickListener(onClickListener);

    }
}
