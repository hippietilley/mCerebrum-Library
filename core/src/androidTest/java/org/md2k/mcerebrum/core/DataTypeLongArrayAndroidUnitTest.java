package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeLongArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeLongArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final long[] testSample = {314159265, 1618033988, 271828, 628318530};
    private DataTypeLongArray mDataTypeLongArray;

    // Create the object.
    @Before
    public void createDataTypeLongArray() {
        mDataTypeLongArray = new DataTypeLongArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeLong_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeLongArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeLongArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeLongArray.writeToParcel(parcel, mDataTypeLongArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeLongArray createdFromParcel = DataTypeLongArray.CREATOR.createFromParcel(parcel);
        DataTypeLongArray[] createdFromParcelArray = DataTypeLongArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeLongArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeLongArray.getSample()[i]);
    }
}