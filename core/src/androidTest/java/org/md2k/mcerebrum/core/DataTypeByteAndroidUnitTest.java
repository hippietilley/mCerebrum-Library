package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeByte;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeByteAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final byte testSample = 127;
    private DataTypeByte mDataTypeByte;

    // Create the object.
    @Before
    public void createDataTypeByte() {
        mDataTypeByte = new DataTypeByte(testTimestamp, testSample);
    }

    @Test
    public void dataTypeByte_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeByte.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeByte_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeByte.writeToParcel(parcel, mDataTypeByte.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeByte createdFromParcel = DataTypeByte.CREATOR.createFromParcel(parcel);
        DataTypeByte[] createdFromParcelArray = DataTypeByte.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeByte.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeByte.getSample());
    }
}