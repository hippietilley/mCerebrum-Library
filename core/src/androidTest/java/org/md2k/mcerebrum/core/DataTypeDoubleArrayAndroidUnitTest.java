package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeDoubleArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeDoubleArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final double[] testSample = {3.14159265359, 1.61803398874989484, 2.71828, 6.2831853071};
    private DataTypeDoubleArray mDataTypeDoubleArray;

    // Create the object.
    @Before
    public void createDataTypeDoubleArray() {
        mDataTypeDoubleArray = new DataTypeDoubleArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeDouble_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeDoubleArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeDoubleArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeDoubleArray.writeToParcel(parcel, mDataTypeDoubleArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeDoubleArray createdFromParcel = DataTypeDoubleArray.CREATOR.createFromParcel(parcel);
        DataTypeDoubleArray[] createdFromParcelArray = DataTypeDoubleArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeDoubleArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeDoubleArray.getSample()[i], 0.1);
    }
}