package com.example.networkmodule.user;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class UserCreate extends MyAsynckTask {
    User user;

    public UserCreate(User user, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.user= user;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";

        Map<String, String> params = new HashMap<>();
        params.put("Email",user.email);
        params.put("Password",user.password);
        params.put("Firstname",user.firstname);
        params.put("Lastname",user.lastname);
        params.put("Surname",user.surname);
        params.put("DateOfBirth",user.dateOfBirth);
        params.put("Gender",user.gender.toString());

        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "user/create")
                    .ignoreConnectType(true)
                    .ignoreHttpsErrors(true)
                    .method(Connection.Method.POST)
                    .date(params)
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
