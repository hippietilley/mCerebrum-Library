package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import com.google.gson.*;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeJSONObject;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeJSONObjectArray;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@SmallTest
public class DataTypeJSONObjectArrayAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private DataTypeJSONObjectArray mDataTypeJSONObjectArray;

    // Create the object.
    @Before
    public void createDataTypeJSONObjectArray() {
        JsonArray testJSON = new JsonArray();
        testJSON.add(true);
        mDataTypeJSONObjectArray = new DataTypeJSONObjectArray(testTimestamp, testJSON);
    }

    @Test
    public void dataTypeString_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeJSONObjectArray.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeString_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeJSONObjectArray.writeToParcel(parcel, mDataTypeJSONObjectArray.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeJSONObjectArray createdFromParcel = DataTypeJSONObjectArray.CREATOR.createFromParcel(parcel);
        DataTypeJSONObjectArray[] createdFromParcelArray = DataTypeJSONObjectArray.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeJSONObjectArray.getDateTime());
        assertEquals(createdFromParcel.getSample().getAsBoolean(), mDataTypeJSONObjectArray.getSample().getAsBoolean());
    }
}
