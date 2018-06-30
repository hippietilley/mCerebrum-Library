package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeIntArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeIntArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final int[] testSample = {3, 1, 2, 6};
    private DataTypeIntArray mDataTypeIntArray;

    // Create the object.
    @Before
    public void createDataTypeIntArray() {
        mDataTypeIntArray = new DataTypeIntArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeInt_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeIntArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeIntArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeIntArray.writeToParcel(parcel, mDataTypeIntArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeIntArray createdFromParcel = DataTypeIntArray.CREATOR.createFromParcel(parcel);
        DataTypeIntArray[] createdFromParcelArray = DataTypeIntArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeIntArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeIntArray.getSample()[i]);
    }
}