package org.md2k.mcerebrum.commons.dialog;
/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
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

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import org.md2k.mcerebrum.commons.R;

import java.util.ArrayList;
import java.util.Collections;

public class Dialog {
    public static MaterialDialog.Builder singleChoice(Activity activity, String title, ArrayList<String> items, int selected, final DialogCallback dialogCallback) {
        return new MaterialDialog.Builder(activity)
                .title(title)
                .items(items)
                .itemsCallbackSingleChoice(selected, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        /**
                         * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected radio button to actually be selected.
                         **/
                        dialogCallback.onSelected(text.toString());
                        return true;
                    }
                })
                .autoDismiss(true)
                .cancelable(false);
    }
    public static MaterialDialog.Builder singleChoice(Activity activity, String title, String[] items, int selected, final DialogCallback dialogCallback) {
        ArrayList<String> tempItems=new ArrayList<>();
        Collections.addAll(tempItems, items);
        return singleChoice(activity, title,tempItems, selected, dialogCallback);
    }

    public static void Simple(Activity activity, String title, String content, final String buttonPositive, final String buttonNegative, Object o, final DialogCallback dialogCallback) {
        new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .positiveText(buttonPositive)
                .negativeText(buttonNegative)
                .autoDismiss(false)
                .cancelable(false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(buttonPositive);
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(buttonNegative);
                    }
                })
                .show();
    }
    public static MaterialDialog.Builder editbox(Activity activity, String title, String content, final DialogCallback dialogCallback){
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL)
                .input("abc", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        dialogCallback.onSelected(input.toString());
                        // Do something
                    }
                });
    }


    public static MaterialDialog.Builder editbox_numeric(Activity activity, String title, String content, final DialogCallback dialogCallback){
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .inputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL)
                .input("abc", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        dialogCallback.onSelected(input.toString());
                        // Do something
                    }
                });
    }

    public static MaterialDialog.Builder simple(Activity activity, String title, String content, final String buttonPositive, final String buttonNegative, final DialogCallback dialogCallback) {
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .positiveText(buttonPositive)
                .negativeText(buttonNegative)
                .cancelable(false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(buttonPositive);
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(buttonNegative);
                    }
                });
    }
    public static MaterialDialog.Builder progress(Activity activity, String content){
        return new MaterialDialog.Builder(activity)
                .content(content)
                .progress(false, 100, true)
                .cancelable(false)
                .autoDismiss(false);

    }
}
