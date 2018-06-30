package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeByteArray;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeByteArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final byte[] testSample = {-126, 0, 126, 127};
    private DataTypeByteArray mDataTypeByteArray;

    // Create the object.
    @Before
    public void createDataTypeByteArray() {
        mDataTypeByteArray = new DataTypeByteArray(testTimestamp, testSample);
    }

    @Test
    public void dataTypeByte_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeByteArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeByteArray_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeByteArray.writeToParcel(parcel, mDataTypeByteArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeByteArray createdFromParcel = DataTypeByteArray.CREATOR.createFromParcel(parcel);
        DataTypeByteArray[] createdFromParcelArray = DataTypeByteArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeByteArray.getDateTime());
        for (int i = 0; i < createdFromParcel.getSample().length; i++)
            assertEquals(createdFromParcel.getSample()[i], mDataTypeByteArray.getSample()[i]);
    }
}