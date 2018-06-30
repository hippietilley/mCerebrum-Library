package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeStringArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeStringArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final String[] testSample = {"Test sample 1", "Test sample 2", "Test sample 3", "Test sample 4"};
    private DataTypeStringArray mDataTypeStringArray;

    // Create the object.
    @Before
    public void createDataTypeStringArray() {
        mDataTypeStringArray = new DataTypeStringArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeString_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeStringArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeStringArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeStringArray.writeToParcel(parcel, mDataTypeStringArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeStringArray createdFromParcel = DataTypeStringArray.CREATOR.createFromParcel(parcel);
        DataTypeStringArray[] createdFromParcelArray = DataTypeStringArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeStringArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeStringArray.getSample()[i]);
    }
}