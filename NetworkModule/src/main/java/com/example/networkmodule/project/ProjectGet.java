package com.example.networkmodule.project;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;

public class ProjectGet extends MyAsynckTask {
    public String token;
    public ProjectGet(String token, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.token = token;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";


        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "project/get")
                    .ignoreConnectType(true)
                    .ignoreHttpsErrors(true)
                    .method(Connection.Method.GET)
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
