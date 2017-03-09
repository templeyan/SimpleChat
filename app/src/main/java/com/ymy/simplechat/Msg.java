package com.ymy.simplechat;

import android.content.Context;

/**
 * Created by ymy on 2017/3/9.
 */

public class Msg {
    public  static  int  send = 0;
    public static  int recive = 1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
