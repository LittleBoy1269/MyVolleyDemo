package volley.com.myvolleydemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Eva-Beta on 2016/4/11.
 */
public class MyApplication extends Application{
    private static RequestQueue mQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        mQueue= Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getHttpQueue(){
        return mQueue;
    }
}
