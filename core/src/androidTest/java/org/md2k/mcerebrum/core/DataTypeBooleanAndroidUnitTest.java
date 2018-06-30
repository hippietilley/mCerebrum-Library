package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeBoolean;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeBooleanAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final boolean testSample = true;
    private DataTypeBoolean mDataTypeBoolean;

    // Create the object.
    @Before
    public void createDataTypeBoolean() {
        mDataTypeBoolean = new DataTypeBoolean(testTimestamp, testSample);
    }

    @Test
    public void dataTypeBoolean_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeBoolean.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeBoolean_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeBoolean.writeToParcel(parcel, mDataTypeBoolean.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeBoolean createdFromParcel = DataTypeBoolean.CREATOR.createFromParcel(parcel);
        DataTypeBoolean[] createdFromParcelArray = DataTypeBoolean.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeBoolean.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeBoolean.getSample());
    }
}
