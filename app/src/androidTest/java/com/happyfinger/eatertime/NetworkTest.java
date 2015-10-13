package com.happyfinger.eatertime;

import android.test.AndroidTestCase;
import com.google.gson.Gson;
import com.happyfinger.eatertime.model.MainPageUpBean;
import com.happyfinger.eatertime.utils.NetworkUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaoyang on 9/26/15.
 */
public class NetworkTest extends AndroidTestCase {

    public void atestGet() {
        String search = "http://www.haitaochuan.com/cy/eatertime/v1/search.php";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "苹果");
        params.put("page", 1);
        try {
            String result = NetworkUtils.get(search, params);
            assertEquals("result", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testPost() {
        String url = "http://www.haitaochuan.com/cy/eatertime/v1/ind.php";
        MainPageUpBean bean = new MainPageUpBean();
        bean.id = "10";
        bean.amount = 10;
        bean.type = 1;
        bean.cal = 20;
        Gson gson = new Gson();
        String data = gson.toJson(new MainPageUpBean[]{bean});
//        assertEquals("data", data);
        try {
            String result = NetworkUtils.post(url, data);
            assertEquals("result", result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
