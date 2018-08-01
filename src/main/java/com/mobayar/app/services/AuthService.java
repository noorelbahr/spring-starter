package com.mobayar.app.services;

import com.mobayar.app.services.callbacks.CallbackAuth;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthService {

    @FormUrlEncoded
    @POST("user/loginWithPin")
    Call<CallbackAuth> loginWithPin(@Field("phone_number") String phone,
                                    @Field("pin") Integer pin,
                                    @Field("device_token") String device_token,
                                    @Field("device_type") String device_type,
                                    @Field("app_version") String app_version
                                    );

}
