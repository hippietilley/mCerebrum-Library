package org.md2k.cerebralcortexwebapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequest {

    @SerializedName("email_id")
    @Expose
    private Object emailId;
    @SerializedName("password")
    @Expose
    private Object password;

    public AuthRequest(Object userName, Object userPassword) {
        this.emailId = userName;
        this.password = userPassword;
    }

    public Object getEmailId() {
        return emailId;
    }

    public void setEmailId(Object emailId) {
        this.emailId = emailId;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

}