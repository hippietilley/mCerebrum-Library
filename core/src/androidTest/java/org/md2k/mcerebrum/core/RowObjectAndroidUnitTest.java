package org.md2k.mcerebrum.core;

import android.support.test.filters.SmallTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.md2k.mcerebrum.core.datakitapi.datatype.DataType;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeBoolean;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeBooleanArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeByte;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeByteArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeDouble;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeDoubleArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeFloat;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeFloatArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeInt;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeIntArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeJSONObject;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeJSONObjectArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeLong;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeLongArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeString;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeStringArray;

@SmallTest
public class RowObjectAndroidUnitTest {

    private final long testTimestamp = 1268660460;
    private long testRowKey = 0;

    public DataTypeBoolean boolTestData = new DataTypeBoolean(testTimestamp, true);
    boolean[] boolSampleArray = {true, false, true, false};
    public DataTypeBooleanArray boolArrayTestData = new DataTypeBooleanArray(testTimestamp, boolSampleArray);
    public DataTypeByte byteTestData = new DataTypeByte(testTimestamp, (byte)127);
    byte[] byteSampleArray = {-126, 0, 126, 127};
    public DataTypeByteArray byteArrayTestData = new DataTypeByteArray(testTimestamp, byteSampleArray);
    public DataTypeDouble doubleTestData = new DataTypeDouble(testTimestamp, 3.14159265359);
    double[] doubleSampleArray = {3.14159265359, 1.61803398874989484, 2.71828, 6.2831853071};
    public DataTypeDoubleArray doubleArrayTestData = new DataTypeDoubleArray(testTimestamp, doubleSampleArray);
    public DataTypeFloat floatTestData = new DataTypeFloat(testTimestamp, 6.28f);
    float[] floatSampleArray = {3.14159265359f, 1.61803398874989484f, 2.71828f, 6.2831853071f};
    public DataTypeFloatArray floatArrayTestData = new DataTypeFloatArray(testTimestamp, floatSampleArray);
    public DataTypeInt intTestData = new DataTypeInt(testTimestamp, -126);
    int[] intSampleArray = {127, -1, 0, 1};
    public DataTypeIntArray intArrayTestData = new DataTypeIntArray(testTimestamp, intSampleArray);
    JsonObject jsonObjectSample = createJsonObjectSample();
    public DataTypeJSONObject jsonObjectTestData = new DataTypeJSONObject(testTimestamp, jsonObjectSample);
    JsonArray jsonArraySample = createJsonArraySample();
    public DataTypeJSONObjectArray jsonObjectArrayTestData = new DataTypeJSONObjectArray(testTimestamp, jsonArraySample);
    public DataTypeLong longTestData = new DataTypeLong(testTimestamp, 1268660460);
    long[] longSampleArray = {314159265, 1618033988, -271828, 628318530};
    public DataTypeLongArray longArrayTestData = new DataTypeLongArray(testTimestamp, longSampleArray);
    public DataTypeString stringTestData = new DataTypeString(testTimestamp, "test string");
    String[] stringSampleArray = {"Test sample 1", "Test sample 2", "Test sample 3", "Test sample 4"};
    public DataTypeStringArray stringArrayTestData = new DataTypeStringArray(testTimestamp, stringSampleArray);
    public DataType[] data = {boolTestData, boolArrayTestData,
                              byteTestData, byteArrayTestData,
                              doubleTestData, doubleArrayTestData,
                              floatTestData, floatArrayTestData,
                              intTestData, intArrayTestData,
                              jsonObjectTestData, jsonObjectArrayTestData,
                              longTestData, longArrayTestData,
                              stringTestData, stringArrayTestData};

    private JsonObject createJsonObjectSample() {
        JsonObject object = new JsonObject();
        object.addProperty("sample", "test sample");
        return object;
    }

    private JsonArray createJsonArraySample() {
        JsonArray array = new JsonArray();
        array.add(true);
        return array;
    }
}
