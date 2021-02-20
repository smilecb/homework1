package com.blb.util;

import java.util.UUID;

public class GetId {
    public static String getUserId() {
        // ctrl +shift+o 快速导包
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}
