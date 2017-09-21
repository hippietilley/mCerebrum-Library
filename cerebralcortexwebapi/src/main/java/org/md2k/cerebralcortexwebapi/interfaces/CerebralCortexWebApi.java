package org.md2k.cerebralcortexwebapi.interfaces;

import org.md2k.cerebralcortexwebapi.models.AuthResponse;
import org.md2k.cerebralcortexwebapi.models.AuthRequest;
import org.md2k.cerebralcortexwebapi.models.MinioBucketsList;
import org.md2k.cerebralcortexwebapi.models.MinioObjectStats;
import org.md2k.cerebralcortexwebapi.models.MinioObjectsListInBucket;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Body;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Header;

public interface CerebralCortexWebApi {

    @GET("/api/v1/auth/")
    Call<AuthResponse> getAccessToken(@Header("Authorization") String accessToken);

    @POST("/api/v1/auth/")
    Call<AuthResponse> authenticateUser(@Body AuthRequest authRequest);



    @GET("/api/v1/object/")
    Call<MinioBucketsList> bucketsList(@Header("Authorization") String authorization);

    @GET("/api/v1/object/{bucket}/")
    Call<MinioObjectsListInBucket> objectsListInBucket(@Header("Authorization") String authorization,
                                       @Path("bucket") String bucket);

    @GET("/api/v1/object/stats/{bucket}/{resource}")
    Call<MinioObjectStats> getMinioObjectStats(@Header("Authorization") String authorization,
                                    @Path("bucket") String bucket,
                                    @Path("resource") String resource);

    @GET("/api/v1/object/{bucket}/{resource}")
    Call<ResponseBody> downloadMinioObject(@Header("Authorization") String authorization,
                                           @Path("bucket") String bucket,
                                           @Path("resource") String resource);


    /*@Multipart
    @PUT("/api/v1/stream/zip/")
    Call<ResponseBody> putArchiveWithMetadata(@Header("Authorization") String authorization,
                             @Part("metadata") RequestBody dataStreamMetadata,
                             @Part MultipartBody.Part file);*/

    @Multipart
    @PUT("/api/v1/stream/zip/")
    Call<ResponseBody> putArchiveWithMetadata(
            @Header("Authorization") String authorization,
            @Part("metadata") RequestBody jsonMetadata,
            @Part MultipartBody.Part file);

    /*@PUT("/api/v1/stream/zip/")
    Call<CCMessage> putZipFile(@Header("Authorization") String authorization,
                               MetadataHeader header,
                               String filepath);*/
}