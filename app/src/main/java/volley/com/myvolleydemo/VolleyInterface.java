package volley.com.myvolleydemo;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by Eva-Beta on 2016/4/11.
 */
public abstract class VolleyInterface {
    private Context mContext;
    private Response.Listener<String> mListener;
    private Response.ErrorListener mErrorListener;
    public VolleyInterface(Context context){
        this.mContext=context;

    }
    public abstract void onMySuccess(String result);
    public abstract void onMyError(VolleyError volleyError);
    public Response.Listener<String> loadingListener(){
        mListener=new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                //请求成功
                onMySuccess(s);
            }
        };
        return mListener;
    }
    public Response.ErrorListener loadingErrorListener(){
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //请求失败
                onMyError(volleyError);
            }
        };
        return mErrorListener;
    }
}
