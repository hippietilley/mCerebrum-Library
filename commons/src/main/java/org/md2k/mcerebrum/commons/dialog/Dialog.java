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

package org.md2k.mcerebrum.commons.dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.datatype.DataTypeLong;
import org.md2k.datakitapi.exception.DataKitException;
import org.md2k.datakitapi.time.DateTime;
import org.md2k.mcerebrum.commons.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import es.dmoral.toasty.Toasty;

import static android.R.id.input;

/**
 *
 */
public class Dialog {
    /**
     * @param activity Activity needing a dialog.
     * @param title
     * @param items
     * @param selected
     * @param dialogCallback Dialog callback interface.
     * @return A <code>MaterialDialog</code> builder.
     */
    public static MaterialDialog.Builder singleChoice(Activity activity, String title, String[] items,
                                                      int selected, final DialogCallback dialogCallback) {
        ArrayList<String> tempItems = new ArrayList<>();
        Collections.addAll(tempItems, items);
        return new MaterialDialog.Builder(activity)
                .title(title)
                .items(items)
                .itemsCallbackSingleChoice(selected, new MaterialDialog.ListCallbackSingleChoice() {
                    /**
                     * @param dialog
                     * @param view
                     * @param which
                     * @param text
                     * @return
                     */
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        dialogCallback.onSelected(text.toString());
                        return true;
                    }
                })
                .autoDismiss(true)
                .cancelable(true);
    }

    /**
     * @param activity Activity needing a dialog.
     * @param title
     * @param items
     * @param selected
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static MaterialDialog.Builder singleChoiceConfirm(final Activity activity, String title,
                                                             final String[] items, int selected,
                                                             final DialogCallback dialogCallback) {
        return new MaterialDialog.Builder(activity)
                .title(title)
                .items(items)
                .positiveText("Select")
                .negativeText("Cancel")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    /**
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if(dialog.getSelectedIndex()==-1){
                            Toasty.error(activity, "File is not selected", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        dialogCallback.onSelected(items[dialog.getSelectedIndex()]);
                        dialog.dismiss();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    /**
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(null);
                        dialog.dismiss();
                    }
                })
                .itemsCallbackSingleChoice(selected, new MaterialDialog.ListCallbackSingleChoice() {
                    /**
                     * @param dialog
                     * @param view
                     * @param which
                     * @param text
                     * @return
                     */
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        return false;
                    }
                })
                .autoDismiss(false)
                .cancelable(false);
    }

    /**
     * @param activity Activity needing a dialog.
     * @param title
     * @param content
     * @param input
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static MaterialDialog.Builder editboxText(Activity activity, String title, String content,
                                                     String input, final DialogCallback dialogCallback){
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("", input, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        dialogCallback.onSelected(input.toString());
                    }
                });
    }

    /**
     * @param activity Activity needing a dialog.
     * @param title
     * @param content
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static MaterialDialog.Builder editbox(Activity activity, String title, String content,
                                                 final DialogCallback dialogCallback){
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("abc", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        dialogCallback.onSelected(input.toString());
                    }
                });
    }


    /**
     * @param activity Activity needing a dialog.
     * @param title
     * @param content
     * @param selectedValue
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static MaterialDialog.Builder editbox_numeric(Activity activity, String title, String content,
                                                         String selectedValue, final DialogCallback dialogCallback){
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input(null, selectedValue, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        dialogCallback.onSelected(input.toString());
                    }
                });
    }

    /**
     * @param activity Activity needing a dialog.
     * @param title
     * @param content
     * @param buttonPositive
     * @param buttonNegative
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static MaterialDialog.Builder simple(Activity activity, String title, String content,
                                                final String buttonPositive, final String buttonNegative,
                                                final DialogCallback dialogCallback) {
        return new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .positiveText(buttonPositive)
                .negativeText(buttonNegative)
                .cancelable(false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    /**
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(buttonPositive);
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    /**
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialogCallback.onSelected(buttonNegative);
                    }
                });
    }

    /**
     * @param activity Activity needing a dialog.
     * @param content
     * @return
     */
    public static MaterialDialog.Builder progressWithBar(Activity activity, String content){
        return new MaterialDialog.Builder(activity)
                .content(content)
                .progress(false, 100, true)
                .cancelable(false)
                .autoDismiss(false);

    }

    /**
     * @param activity Activity needing a dialog.
     * @param content
     * @return
     */
    public static MaterialDialog.Builder progressIndeterminate(Activity activity, String content){
        return new MaterialDialog.Builder(activity)
                .content(content)
                .progress(true, 100)
                .cancelable(false)
                .autoDismiss(false);

    }

    /**
     * @param activity Activity needing a dialog.
     * @param year
     * @param month
     * @param day
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static DatePickerDialog dateTimePicker(Activity activity, int year, int month, int day,
                                                  final DialogCallback dialogCallback) {
        return new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            /**
             * @param view
             * @param year
             * @param month
             * @param dayOfMonth
             */
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, dayOfMonth, 0,0, 0);
                c.set(Calendar.MILLISECOND, 0);
                long time = c.getTimeInMillis();
                dialogCallback.onSelected(String.valueOf(time));
            }
        },year, month, day);
    }

    /**
     * @param activity Activity needing a dialog.
     * @param hourOfDay
     * @param minute
     * @param dialogCallback Dialog callback interface.
     * @return
     */
    public static TimePickerDialog timePicker(Activity activity, int hourOfDay, int minute,
                                              final DialogCallback dialogCallback) {
        return new TimePickerDialog(activity,
                new TimePickerDialog.OnTimeSetListener() {

                    /**
                     * @param view
                     * @param hourOfDay
                     * @param minute
                     */
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        long time = hourOfDay * 60 * 60 * 1000 + minute * 60 * 1000;
                        dialogCallback.onSelected(String.valueOf(time));
                    }
                }, hourOfDay, minute, false);
    }
}
