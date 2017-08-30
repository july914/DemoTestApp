package com.example.yuliya.demotestapp.Models;

import java.util.Comparator;

/**
 * Created by yuliya on 30.08.17.
 */
public class UserIdComparator implements Comparator<VKResponse.Item> {
    public int compare(VKResponse.Item left1, VKResponse.Item right1){
        return left1.getId() - right1.getId();
    }
}
