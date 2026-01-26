package com.example.networkmodule.basket;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;

public class BasketDelete extends MyAsynckTask {
    public String token;
    public BasketDelete(String token, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.token = token;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";


        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "basket/delete")
                    .ignoreConnectType(true)
                    .ignoreHttpsErrors(true)
                    .method(Connection.Method.DELETE)
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
