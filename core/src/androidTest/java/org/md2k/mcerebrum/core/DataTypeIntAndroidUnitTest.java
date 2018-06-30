package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeInt;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeIntAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final int testSample = 3;
    private DataTypeInt mDataTypeInt;

    // Create the object.
    @Before
    public void createDataTypeInt() {
        mDataTypeInt = new DataTypeInt(testTimestamp, testSample);
    }

    @Test
    public void dataTypeInt_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeInt.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeInt_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeInt.writeToParcel(parcel, mDataTypeInt.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeInt createdFromParcel = DataTypeInt.CREATOR.createFromParcel(parcel);
        DataTypeInt[] createdFromParcelArray = DataTypeInt.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeInt.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeInt.getSample());
    }
}
