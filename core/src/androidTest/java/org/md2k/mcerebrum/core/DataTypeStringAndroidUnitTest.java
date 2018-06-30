package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeString;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeStringAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final String testSample = "test sample";
    private DataTypeString mDataTypeString;

    // Create the object.
    @Before
    public void createDataTypeString() {
        mDataTypeString = new DataTypeString(testTimestamp, testSample);
    }

    @Test
    public void dataTypeString_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeString.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeString_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeString.writeToParcel(parcel, mDataTypeString.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeString createdFromParcel = DataTypeString.CREATOR.createFromParcel(parcel);
        DataTypeString[] createdFromParcelArray = DataTypeString.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeString.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeString.getSample());
    }
}