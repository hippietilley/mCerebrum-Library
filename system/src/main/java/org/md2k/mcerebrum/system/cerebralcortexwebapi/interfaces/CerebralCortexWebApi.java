/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.mcerebrum.system.cerebralcortexwebapi.interfaces;

import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.MinioBucketsList;
import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.AuthRequest;
import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.AuthResponse;
import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.MinioObjectStats;
import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.MinioObjectsListInBucket;

import okhttp3.Response;
import okhttp3.ResponseBody;

import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.UserRegisterRequest;
import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.stream.StreamMetadata;
import org.md2k.mcerebrum.system.cerebralcortexwebapi.models.stream.RegisterResponse;

import java.io.File;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Interface for the HTTP API.
 */
public interface CerebralCortexWebApi {

    /**
     * Gets the access token.
     *
     * @param accessToken Authorization access token
     * @return An <code>AuthResponse</code> call.
     */
//    @GET("/api/v3/user/")
//    Call<AuthResponse> getAccessToken(@Header("Authorization") String accessToken);

    /**
     * Checks if the user route of Cerebral Cortex is working properly.
     * @return a <code>Response</code> object
     */
    @GET("/api/v3/user")
    Call<ResponseBody> checkUserRoute();

    /**
     * Fetches the user's configuration from Cerebral Cortex
     * @param accessToken Access token returned from Cerebral Cortex when a user logs in.
     * @return
     */
    @GET("/api/v3/user/config")
    Call<AuthResponse> getUserConfig(@Header("Authorization") String accessToken);

    /**
     * Authenticates the user.
     *
     * @param authRequest Authorization request.
     * @return An <code>AuthResponse</code> call.
     */
    @POST("/api/v3/user/login")
    Call<AuthResponse> authenticateUser(@Body AuthRequest authRequest);

    @POST("/api/v3/user/register")
    Call<ResponseBody> registerUser(@Body UserRegisterRequest userRegisterRequest);


    /**
     * Gets the list of Minio buckets.
     *
     * @param authorization Authorization header.
     * @return A <code>MinioBucketsList</code> call.
     */
    @GET("/api/v3/bucket/")
    Call<MinioBucketsList> getBucketsList(@Header("Authorization") String authorization);

    /**
     * Gets a single Minio object from the given bucket.
     *
     * @param authorization Authorization header.
     * @param objectName The Minio object.
     * @param bucketName Bucket the object is in.
     * @return A <code>MinioObjectStats</code> call.
     */
    @GET("/api/v3/object/stats/{bucket_name}/{object_name}")
    Call<MinioObjectStats> getMinioObjectStats(@Path("bucket_name") String bucketName,
                                               @Path("object_name") String objectName,
                                               @Header("Authorization") String authorization);

    /**
     * Gets the list of objects in the given Minio bucket.
     *
     * @param authorization Authorization header.
     * @param bucketName Bucket to list.
     * @return A <code>MinioObjectsListInBucket</code> call.
     */
    @GET("/api/v3/bucket/{bucket_name}/")
    Call<MinioObjectsListInBucket> objectsListInBucket(@Path("bucket_name") String bucketName,
                                                       @Header("Authorization") String authorization);

    /**
     * Downloads a Minio object via a <code>ResponseBody</code>.
     *
     * @param authorization Authorization header.
     * @param objectName The Minio object.
     * @param bucketName Bucket the object is in.
     * @return A <code>ResponseBody</code> call.
     */
    @GET("/api/v3/bucket/{bucket_name}/{object_name}")
    Call<ResponseBody> downloadMinioObject(@Path("object_name") String objectName,
                                           @Path("bucket_name") String bucketName,
                                           @Header("Authorization") String authorization);

    @GET("/api/v3/stream/data/{stream_name}")
    Call<ResponseBody> getStreamData(@Path("stream_name") String streamName,
                                     @Header("Authorization") String authorization);

    @GET("api/v3/stream/metadata/{stream_name}")
    Call<StreamMetadata> getStreamMetadata(@Path("stream_name") String streamName,
                                           @Header("Authorization") String authorization);

    @POST("/api/v3/stream/register")
    Call<RegisterResponse> registerDataStream(@Header("Authorization") String authorization,
                                              @Body StreamMetadata streamMetadata);

    @Multipart
    @PUT("/api/v3/stream/{metadata_hash}")
    Call<ResponseBody> putDataStream(@Path("metadata_hash") String metadataHash,
                                     @Part("file") File fileToUpload,
                                     @Header("Authorization") String authorization);
}