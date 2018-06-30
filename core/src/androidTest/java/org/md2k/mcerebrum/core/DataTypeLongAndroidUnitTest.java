package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeLong;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeLongAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final long testSample = 1268660460;
    private DataTypeLong mDataTypeLong;

    // Create the object.
    @Before
    public void createDataTypeLong() {
        mDataTypeLong = new DataTypeLong(testTimestamp, testSample);
    }

    @Test
    public void dataTypeLong_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeLong.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeLong_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeLong.writeToParcel(parcel, mDataTypeLong.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeLong createdFromParcel = DataTypeLong.CREATOR.createFromParcel(parcel);
        DataTypeLong[] createdFromParcelArray = DataTypeLong.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeLong.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeLong.getSample());
    }
}
