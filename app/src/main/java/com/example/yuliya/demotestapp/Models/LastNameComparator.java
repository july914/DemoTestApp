package com.example.yuliya.demotestapp.Models;

import java.util.Comparator;

/**
 * Created by yuliya on 30.08.17.
 */

public class LastNameComparator implements Comparator <VKResponse.Item> {
    public int compare(VKResponse.Item left, VKResponse.Item right){
        return left.getLastName().compareTo(right.getLastName());
    }
}
