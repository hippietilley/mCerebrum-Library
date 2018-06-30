package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeDouble;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeDoubleAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final double testSample = 3.14159265359;
    private DataTypeDouble mDataTypeDouble;

    // Create the object.
    @Before
    public void createDataTypeDouble() {
        mDataTypeDouble = new DataTypeDouble(testTimestamp, testSample);
    }

    @Test
    public void dataTypeDouble_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeDouble.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeDouble_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeDouble.writeToParcel(parcel, mDataTypeDouble.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeDouble createdFromParcel = DataTypeDouble.CREATOR.createFromParcel(parcel);
        DataTypeDouble[] createdFromParcelArray = DataTypeDouble.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeDouble.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeDouble.getSample(), 0.1);
    }
}
