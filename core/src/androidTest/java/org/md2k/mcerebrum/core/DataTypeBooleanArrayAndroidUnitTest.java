package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeBooleanArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeBooleanArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final boolean[] testSample = {true, false, true, false};
    private DataTypeBooleanArray mDataTypeBooleanArray;

    // Create the object.
    @Before
    public void createDataTypeBooleanArray() {
        mDataTypeBooleanArray = new DataTypeBooleanArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeBoolean_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeBooleanArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeBooleanArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeBooleanArray.writeToParcel(parcel, mDataTypeBooleanArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeBooleanArray createdFromParcel = DataTypeBooleanArray.CREATOR.createFromParcel(parcel);
        DataTypeBooleanArray[] createdFromParcelArray = DataTypeBooleanArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeBooleanArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeBooleanArray.getSample()[i]);
    }
}
