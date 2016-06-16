package com.testejson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by Victor on 28/03/2016.
 */
public class TransferUtil {
        private static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();

        public static <T> T getObjectFromJSON(String json, Class<T> clazz){
            return gson.fromJson(json, clazz);
        }

        public static <T> T getArrayFromJSON(String json, Type type) {
            return gson.fromJson(json, type);
        }

        public static String getJSONFromObject(Object object) {
            return gson.toJson(object);
        }

}
