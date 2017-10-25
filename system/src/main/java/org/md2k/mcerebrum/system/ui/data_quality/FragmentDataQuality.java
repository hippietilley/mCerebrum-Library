package org.md2k.mcerebrum.system.ui.data_quality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.mcerebrum.system.R;

public class FragmentDataQuality extends Fragment {
    DataSource[] dataSources;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        dataSources = (DataSource[]) getArguments().getParcelableArray(DataSource.class.getSimpleName());
        if (dataSources == null) {
            view = inflater.inflate(R.layout.fragment_data_quality_4, container, false);
        } else {
            switch (dataSources.length) {
                case 1:
                    view = inflater.inflate(R.layout.fragment_data_quality_4, container, false);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.fragment_data_quality_4, container, false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.fragment_data_quality_4, container, false);
                    break;
                case 4:
                    view = inflater.inflate(R.layout.fragment_data_quality_4, container, false);
                    break;
                default:
                    view = inflater.inflate(R.layout.fragment_data_quality_4, container, false);
            }
        }
        return view;
    }
}