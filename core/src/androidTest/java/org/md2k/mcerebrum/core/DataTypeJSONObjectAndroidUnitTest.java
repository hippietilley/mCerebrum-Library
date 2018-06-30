package org.md2k.mcerebrum.core;

import android.os.Parcel;
import android.support.test.filters.SmallTest;

import com.google.gson.*;

import org.junit.Before;
import org.junit.Test;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeJSONObject;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SmallTest
public class DataTypeJSONObjectAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private final String testSample = "test sample";
    private DataTypeJSONObject mDataTypeJSONObject;

    // Create the object.
    @Before
    public void createDataTypeJSONObject() {
        JsonObject testJSON = new JsonObject();
        testJSON.addProperty("sample", testSample);
        mDataTypeJSONObject = new DataTypeJSONObject(testTimestamp, testJSON);
    }

    @Test
    public void dataTypeString_ToStringTest() {
        // Checks the toString() method.
        String dataTypePreParcel = mDataTypeJSONObject.toString();
        assertThat(dataTypePreParcel, not(isEmptyOrNullString()));
    }

    @Test
    public void dataTypeString_ParcelableWriteRead() {
        // Write data to a parcel.
        Parcel parcel = Parcel.obtain();
        mDataTypeJSONObject.writeToParcel(parcel, mDataTypeJSONObject.describeContents());

        // After writing, reset the parcel for reading.
        parcel.setDataPosition(0);

        // Read the data.
        DataTypeJSONObject createdFromParcel = DataTypeJSONObject.CREATOR.createFromParcel(parcel);
        DataTypeJSONObject[] createdFromParcelArray = DataTypeJSONObject.CREATOR.newArray(1);

        // Verify results.
        assertThat(createdFromParcelArray.length, is(not(0)));
        assertEquals(createdFromParcel.getDateTime(), mDataTypeJSONObject.getDateTime());
        assertEquals(createdFromParcel.getSample(), mDataTypeJSONObject.getSample());
    }
}
