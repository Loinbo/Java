package com.lamb;

import java.io.IOException;

/**
 * Created by Loinbo
 * DATE:2019/8/30
 * TIME:10:42
 */

public interface Controller {
    default void doGet(Request request, Response response) throws IOException {
        response.status = "405 Method Not Allowed";
        response.println("Method Error");
    }

    default void doPost(Request request, Response response) throws IOException {
        response.status = "405 Method Not Allowed";
        response.println("Method Error");
    }
}
