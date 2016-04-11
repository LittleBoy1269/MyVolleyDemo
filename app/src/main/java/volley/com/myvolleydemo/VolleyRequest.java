package volley.com.myvolleydemo;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by Eva-Beta on 2016/4/11.
 */
public class VolleyRequest{
    public static StringRequest stringRequest;
    public static Context context;
    public static void RequestGet(Context mContext,String url,String tag,VolleyInterface vif) {
        MyApplication.getHttpQueue().cancelAll(tag);
        stringRequest=new StringRequest(Request.Method.GET,url,vif.loadingListener(),vif.loadingErrorListener());
        stringRequest.setTag(tag);
        MyApplication.getHttpQueue().add(stringRequest);
        MyApplication.getHttpQueue().start();
    }
    public static void RequestPost(Context mContext,String url,String tag,
                                   final Map<String,String> params, VolleyInterface vif){
        MyApplication.getHttpQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.POST, url,
                vif.loadingListener(),vif.loadingErrorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getHttpQueue().add(stringRequest);
        MyApplication.getHttpQueue().start();
    }
}
