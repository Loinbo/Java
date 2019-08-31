package com.lamb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Loinbo
 * DATE:2019/8/30
 * TIME:10:43
 */

public class StaticController implements Controller {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        String url = request.getUrl();
        if (url.equals("/")) {
            url = "post.html";
        }
        String filename = "D:\\\\LAMB\\Code\\MyHTTPDemoController\\webapp\\" + url;
        File file = new File(filename);

        InputStream is = new FileInputStream(file);

        byte[] buf = new byte[8192];
        int len = is.read(buf);
        response.write(buf, len);

        is.close();
    }
}
