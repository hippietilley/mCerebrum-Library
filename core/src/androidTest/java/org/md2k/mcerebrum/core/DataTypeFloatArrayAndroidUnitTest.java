package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeFloatArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeFloatArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final float[] testSample = {3.14159265359f, 1.61803398874989484f, 2.71828f, 6.2831853071f};
    private DataTypeFloatArray mDataTypeFloatArray;

    // Create the object.
    @Before
    public void createDataTypeFloatArray() {
        mDataTypeFloatArray = new DataTypeFloatArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeFloat_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeFloatArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeFloatArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeFloatArray.writeToParcel(parcel, mDataTypeFloatArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeFloatArray createdFromParcel = DataTypeFloatArray.CREATOR.createFromParcel(parcel);
        DataTypeFloatArray[] createdFromParcelArray = DataTypeFloatArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeFloatArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeFloatArray.getSample()[i], 0.1);
    }
}