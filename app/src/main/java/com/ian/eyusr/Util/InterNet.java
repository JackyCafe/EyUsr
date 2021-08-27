package com.ian.eyusr.Util;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public interface InterNet {

    interface IPost {
        public String doPost(JSONObject json) throws IOException;


    }

    interface IGet<T> {
        public String doGet() throws IOException;

        public T parseJson(String response, Type type);

        public List<T> parseJsonList(String response, Type type);
    }
}