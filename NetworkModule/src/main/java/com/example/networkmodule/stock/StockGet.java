package com.example.networkmodule.stock;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;
import java.sql.Connection;

public class StockGet extends MyAsynckTask {
    public StockGet(CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";

        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "user/get")
                    .ignoreConnectType(true)
                    .ignoreHttpsErrors(true)
                    .method(Connection.Method.GET)
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
