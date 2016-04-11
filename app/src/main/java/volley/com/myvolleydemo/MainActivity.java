package volley.com.myvolleydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;


public class MainActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Volley_Change();
        //Volley_Post();
        //Volley_Json();
    }

    /**
     * 二次简单封装
     */
    private void Volley_Change(){
        String url="https://tcc.taobao.com/cc/json/mobile_tel_segment.html";
        VolleyRequest.RequestGet(MainActivity.this, url, "Volleytest", new VolleyInterface(MainActivity.this) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMyError(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    private void Volley_Post(){
        String url="https://tcc.taobao.com/cc/json/mobile_tel_segment.html";
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
            }
        });
        request.setTag("VolleyPost");
        MyApplication.getHttpQueue().add(request);
    }

    private void Volley_Json(){
        String url="";
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("phone","13990169602");
        map.put("key","1111111111111");
        JSONObject object=new JSONObject(map);
        JsonObjectRequest Jrequest=new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Toast.makeText(MainActivity.this,jsonObject.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Jrequest.setTag("JsonVolley");
        MyApplication.getHttpQueue().add(Jrequest);
    }
    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getHttpQueue().cancelAll("JsonVolley");
    }
}
