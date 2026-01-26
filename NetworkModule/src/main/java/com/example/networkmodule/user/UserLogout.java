package com.example.networkmodule.user;

import com.example.networkmodule.common.CheckInternet;
import com.example.networkmodule.common.MyAsynckTask;
import com.example.networkmodule.common.MyResponseCallback;
import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

public class UserLogout extends MyAsynckTask {
    String token;
    public UserLogout(String token, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.token = token;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";


        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "user/logout")
                    .ignoreConnectType(true)
                    .ignoreHttpsErrors(true)
                    .method(Connection.Method.POST)
                    .header("token", token)
                    .execute();

            if (response.statusCode() == 200)
                return response.body();
            else
                return "Error: " + response.body();
        }
        catch (IOException e)
        {
            return "Error: "+e.getMessage();
        }
    }


}
