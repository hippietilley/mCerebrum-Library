package org.md2k.mcerebrum.commons.ui.settings;

import android.app.TimePickerDialog;
import android.icu.text.DisplayContext;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.md2k.mcerebrum.commons.R;
import org.md2k.mcerebrum.commons.dialog.Dialog;
import org.md2k.mcerebrum.commons.dialog.DialogCallback;

import java.util.Calendar;

import static android.R.attr.value;

/**
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p/>
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * <p/>
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p/>
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
public class PrefsFragmentSettings extends PreferenceFragment {


    int inputNumericValue;
    String inputEditTextValue;
    String inputSingleChoice;
    String inputDateValue;
    TimePickerDialog mDialogHourMinute;
    int mHour, mMinute;
    EditText  txtTime;

    int mHour1, mMinute1;
    EditText  txtTime1;

   // final FragmentController mFragments = FragmentController.createController(new FragmentActivity.HostCallbacks());
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_settings);
        setSettings();
    }
    void setSettings() {
        PreferenceCategory category = (PreferenceCategory) findPreference("key_settings");
        category.removeAll();
        Preference preference=createPreference("DATE_TIME");
        category.addPreference(preference);
        Preference preference2=createPreference("TIME");
        category.addPreference(preference2);
        Preference preference3=createPreference("NUMERIC");
        category.addPreference(preference2);
        Preference preference4=createPreference("SINGLE_SELECT");
        category.addPreference(preference2);
        Preference preference5=createPreference("EDIT_TEXT");
        category.addPreference(preference2);

    }

    Preference createPreference(final String type){
        Preference preference = new Preference(getActivity());
        preference.setKey("abc");
        preference.setTitle("title");
        preference.setSummary("summary");
        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                switch(type){
                    case "TIME":
                        inputTime("TITLE");
                        break;
                    case "DATE_TIME":
                        inputDateTime("TITLE");
                        break;
                    case "EDIT_TEXT":
                        inputEditText("TITLE");
                        break;
                    case "SINGLE_SELECT":
                        inputSingleSelect("TITLE");
                        break;
                    case "NUMERIC":
                        inputNumeric("TITLE");
                        break;


                }

              //  Toast.makeText(getActivity(),"abc",Toast.LENGTH_SHORT).show();
                return false;
            }


        });
        return preference;
    }
/*
    void addToPreferenceScreenAvailable(String type, String deviceId) {
        final PreferenceCategory category = (PreferenceCategory) findPreference("key_device_available");
        for (int i = 0; i < category.getPreferenceCount(); i++)
            if (category.getPreference(i).getKey().equals(deviceId))
                return;
        ListPreference listPreference = new ListPreference(getActivity());
        if (deviceManager.hasDefault()) {
            listPreference.setEntryValues(R.array.wrist_entryValues);
            listPreference.setEntries(R.array.wrist_entries);
        } else {
            listPreference.setEntryValues(R.array.wrist_entryValues_extended);
            listPreference.setEntries(R.array.wrist_entries_extended);
        }
        listPreference.setKey(deviceId);
        listPreference.setTitle(deviceId);
        listPreference.setSummary(type);
        if (type.equals(PlatformType.MOTION_SENSE_HRV))
            listPreference.setIcon(R.drawable.ic_watch_heart);
        else
            listPreference.setIcon(R.drawable.ic_watch);
        listPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            if (deviceManager.isConfigured(newValue.toString(), preference.getKey()))
                Toast.makeText(getActivity(), "Device: " + preference.getKey() + "and/or Placement:" + newValue.toString() + " already configured", Toast.LENGTH_LONG).show();
            else {
                deviceManager.add(preference.getSummary().toString(), newValue.toString(), preference.getKey());
                deviceManager.writeConfiguration(getActivity());
                setPreferenceScreenConfigured();
                category.removePreference(preference);
            }
            return false;
        });
        category.addPreference(listPreference);
    }
*/

/*
    private Preference.OnPreferenceClickListener preferenceListenerConfigured() {
        return preference -> {
            final String deviceId = preference.getKey();
            Dialog.simple(getActivity(), "Delete Device", "Delete Device (" + preference.getTitle() + ")?", "Delete", "Cancel", new DialogCallback() {
                @Override
                public void onSelected(String value) {
                    if ("Delete".equals(value)) {
                        deviceManager.delete(deviceId);
                        deviceManager.writeConfiguration(getActivity());
                        setPreferenceScreenConfigured();
                    }
                }
            }).show();
            return true;
        };
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        assert v != null;
        ListView lv = (ListView) v.findViewById(android.R.id.list);
        lv.setPadding(0, 0, 0, 0);
        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                getActivity().finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    void  inputTime(String title){

        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity (),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                   //     txtTime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();

    }



    void inputDateTime(String title){
        Dialog.showCustomDatePicker(getActivity(), "Enter "+title, "Select date", new DialogCallback() {
        @Override
        public void onSelected(String value) {

                try {
                    inputTime("TITLE");

                    inputDateValue = value;
                    Toast.makeText(getActivity(),"value: "+inputDateValue,Toast.LENGTH_SHORT).show();
                    //     saveToDataKit(inputNumericValue);
                } catch (Exception e) {

                }
            }
        }).show();
  /*      TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity (),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        txtTime1.setText(hourOfDay + ":" + minute);
                    }
                }, mHour1, mMinute1, false);
        timePickerDialog.show();
  */

    }

    void inputEditText(String title){
        Dialog.editboxText(getActivity(), "Enter "+title, "Enter Text", new DialogCallback() {
            @Override
            public void onSelected(String value) {
                try {
                    inputEditTextValue = value;
                    //     saveToDataKit(inputNumericValue);
                } catch (Exception e) {

                }
            }
        }).show();

    }

    void inputSingleSelect(String title){
        Dialog.singleChoice(getActivity(), "Select " +title, new String[]{"Home", "Work", "Other"}, 0, new DialogCallback() {
            @Override
            public void onSelected(String value) {
                try {
                    inputSingleChoice = value;
                    //     saveToDataKit(inputNumericValue);
                } catch (Exception e) {

                }
            }
        }).show();


    }
    void inputNumeric(String title){
        Dialog.editbox_numeric(getActivity(), "Enter "+title, "Enter Numeric Value", new DialogCallback() {
            @Override
            public void onSelected(String value) {
                try {
                    inputNumericValue = Integer.parseInt(value);
                    Toast.makeText(getActivity(),"value: "+inputNumericValue,Toast.LENGTH_SHORT).show();
                    //     saveToDataKit(inputNumericValue);
                } catch (Exception e) {

                }
            }
        }).show();


            }


}