package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataType;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeAndroidUnitTest {

    private final long dateTime = 1268660460;
    private DataType mDataType;

    // Create the dataType object.
    @Before
    public void createDataType() {
        mDataType = new DataType(dateTime);
    }

    @Test
    public void stringTest() {
        String dataTypePreParcel = mDataType.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataType_ParcelableWriteRead() {
        // Write the data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataType.writeToParcel(parcel, mDataType.describeContents());

        // After writing, you need to reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataType createdFromParcel = DataType.CREATOR.createFromParcel(parcel);
        DataType[] createdFromParcelArray = DataType.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataType.getDateTime());
    }
}
