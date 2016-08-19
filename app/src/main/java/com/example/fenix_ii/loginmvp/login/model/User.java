package com.example.fenix_ii.loginmvp.login.model;

/**
 * Created by fenix-ii on 9/8/16.
 */
public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


                String id;//": "1393",
                String email;//": "vinitmundada@gmail.com8",
                String mobile;//": "9422522891",
                String type;//": "1",
                String first_name;//": "Vinit",
                String middle_name;//": null,
                String last_name;//": "Mundada",
                String gender;//": "m",
                String email_code;//": "243638",
                String mobile_code;//": "",
                String forget_code;//": "",
                String created_at;//": "2016-07-25 10:19:32",
                String updated_at;//": "2016-08-17 08:30:05",
                String creator_id;//": "0",
                String email_verified;//": "0",
                String mobile_verified;//": "1",
                String aadhar_id;//": "FVBGGHBBHHJU",
                String aadhar_verified;//": "0",
                String date_of_birth;//": "1933-03-23",
                String profile_gallery;//: "",
                String user_id;//: "8",
                String token;//": "eyJhY2Nlc3NfdG9rZW4iOiI3NTljNjBhNGMwYzU0NjFhMmM2NGQwY2I1ZDA1NjdlZjE4YzA3NzY1IiwiYXV0aF9pZCI6IjEzOTMiLCJjcmVhdGVkX2F0IjoiMjAxNi0wOC0xOSAxMjowMDowNSJ9"

    public String getGender() {
        if (gender.equals("m")) {
            return "Male";
        } else {
            return gender;
        }
    }

    public String getEmail_code() {
        return email_code;
    }

    public String getMobile_code() {
        return mobile_code;
    }

    public String getForget_code() {
        return forget_code;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public String getEmail_verified() {
        return email_verified;
    }

    public String getMobile_verified() {
        return mobile_verified;
    }

    public String getAadhar_id() {
        return aadhar_id;
    }

    public String getAadhar_verified() {
        return aadhar_verified;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getProfile_gallery() {
        return profile_gallery;
    }

    public String getUser_id() {
        return user_id;
    }


    public String getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getType() {
        return type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        if (middle_name == null)
            return "";
        else
            return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getToken() {
        return token;
    }
}
