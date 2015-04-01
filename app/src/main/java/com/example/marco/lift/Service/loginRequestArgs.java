package com.example.marco.lift.Service;

import com.example.marco.lift.Interface.IHttpCallbackListener;

/**
 * Created by kting_000 on 3/31/2015.
 */
public class loginRequestArgs {
    private IHttpCallbackListener listener;
    private String url;

    public IHttpCallbackListener getListener(){
        return listener;
    }
    public void setListener(IHttpCallbackListener listener){
        this.listener=listener;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }
}
