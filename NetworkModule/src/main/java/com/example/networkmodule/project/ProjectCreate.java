package com.example.networkmodule.project;

import com.example.uikit.edit_text.common.MyAsynckTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.example.uikit.edit_text.models.Project;

public class ProjectCreate extends MyAsynckTask {
    String token;
    Project project;
    public ProjectCreate(String token, Project project, CheckInternet checkInternet, MyResponseCallback callback) {
        super(checkInternet, callback);

        this.token = token;
        this.project = project;
    }

    @Override
    protected String doInBackground(Void...voids)
    {
        if(!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return  "Error : no internet connection";

        Map<String,String> params = new HashMap<>();
        params.put("IdType", project.idType.toString());
        params.put("Name", project.name());
        params.put("Description", project.description());
        params.put("StartDate", project.startDate());
        params.put("EndDate", project.endDate());
        params.put("IdCategory", project.idCategory.toString());
        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "project/create")
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
