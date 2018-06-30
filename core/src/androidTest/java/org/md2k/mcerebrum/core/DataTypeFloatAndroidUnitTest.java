package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeFloat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeFloatAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final float testSample = 3.14f;
    private DataTypeFloat mDataTypeFloat;

    // Create the object.
    @Before
    public void createDataTypeFloat() {
        mDataTypeFloat = new DataTypeFloat(testTimestamp, testSample);
    }

    @Test
    public void dataTypeFloat_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeFloat.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeFloat_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeFloat.writeToParcel(parcel, mDataTypeFloat.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeFloat createdFromParcel = DataTypeFloat.CREATOR.createFromParcel(parcel);
        DataTypeFloat[] createdFromParcelArray = DataTypeFloat.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeFloat.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeFloat.getSample(), 0.1);
    }
}
