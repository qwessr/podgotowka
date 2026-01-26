package com.example.networkmodule.product;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;

public class ProductGet extends MyAsynckTask {
    public ProductGet(CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);
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

