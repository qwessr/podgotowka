package com.example.networkmodule.product;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;

public class ProductSearch extends MyAsynckTask {
    String text;
    public ProductSearch(String text, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.text = text;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";


        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "product/search?search="+this.text)
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
