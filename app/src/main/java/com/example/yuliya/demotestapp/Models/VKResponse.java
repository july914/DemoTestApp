package com.example.yuliya.demotestapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliya on 23.08.17.
 */

public class VKResponse {

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


    public class Response {

        @SerializedName("count")
        @Expose
        private int count;
        @SerializedName("items")
        @Expose
        private List<Item> items = new ArrayList<Item>();

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems() {
            this.items = items;
        }

    }

    public class Item {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("photo_100")
        @Expose
        private String photo100;
        @SerializedName("hidden")
        @Expose
        private int hidden;
        @SerializedName("deactivated")
        @Expose
        private String deactivated;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoto100() {
            return photo100;
        }

        public void setPhoto100(String photo100) {
            this.photo100 = photo100;
        }

    }

}



