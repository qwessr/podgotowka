package com.example.networkmodule.product;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;

public class ProductGetId extends MyAsynckTask {

    Integer id;
    public ProductGetId(Integer id,CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);
        this.id = id;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";


        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "product/"+id.toString())
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
