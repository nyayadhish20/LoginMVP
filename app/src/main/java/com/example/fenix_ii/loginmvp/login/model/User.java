package com.example.fenix_ii.loginmvp.login.model;

import io.realm.RealmObject;

/**
 * Created by fenix-ii on 9/8/16.
 */
public class User  extends RealmObject{
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


    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail_code(String email_code) {
        this.email_code = email_code;
    }

    public void setMobile_code(String mobile_code) {
        this.mobile_code = mobile_code;
    }

    public void setForget_code(String forget_code) {
        this.forget_code = forget_code;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public void setEmail_verified(String email_verified) {
        this.email_verified = email_verified;
    }

    public void setMobile_verified(String mobile_verified) {
        this.mobile_verified = mobile_verified;
    }

    public void setAadhar_id(String aadhar_id) {
        this.aadhar_id = aadhar_id;
    }

    public void setAadhar_verified(String aadhar_verified) {
        this.aadhar_verified = aadhar_verified;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setProfile_gallery(String profile_gallery) {
        this.profile_gallery = profile_gallery;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type='" + type + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email_code='" + email_code + '\'' +
                ", mobile_code='" + mobile_code + '\'' +
                ", forget_code='" + forget_code + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", creator_id='" + creator_id + '\'' +
                ", email_verified='" + email_verified + '\'' +
                ", mobile_verified='" + mobile_verified + '\'' +
                ", aadhar_id='" + aadhar_id + '\'' +
                ", aadhar_verified='" + aadhar_verified + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", profile_gallery='" + profile_gallery + '\'' +
                ", user_id='" + user_id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
