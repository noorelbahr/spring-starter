package com.mobayar.app.services.callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobayar.app.entities.User;

import java.io.Serializable;

public class CallbackAuth implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("data")
    @Expose
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
