package com.example.networkmodule.basket;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BasketCreate extends MyAsynckTask {
    public Integer idProduct;
    public String token;
    public BasketCreate(Integer idProduct, String token, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.idProduct = idProduct;
        this.token = token;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";

        Map<String,String> params =new HashMap<>();
        params.put("idProduct", this.idProduct.toString());

        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "baslet/create")
                    .ignoreConnectType(true)
                    .ignoreHttpsErrors(true)
                    .method(Connection.Method.POST)
                    .header("token", token)
                    .data(params)
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
