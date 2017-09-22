package org.md2k.cerebralcortexwebapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    @SerializedName("access_token")
    @Expose
    private Object accessToken;
    @SerializedName("message")
    @Expose
    private Object message;

    public AuthResponse(Object accessToken, Object message) {
        this.accessToken = accessToken;
        this.message = message;
    }

    public AuthResponse(Object message) {
        this.message = message;
    }

    public Object getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Object accessToken) {
        this.accessToken = accessToken;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

}