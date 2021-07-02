package com.sdos.aplication.Model;

public class DataClient {

    private String mCode;
    private String mName;
    private String mPhone;
    private String mEmail;
    private String mVisit;


    public DataClient(String mCode, String mName, String mPhone, String mEmail, String mVisit) {
        this.mCode = mCode;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mEmail = mEmail;
        this.mVisit = mVisit;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getVisit() {
        return mVisit;
    }

    public void setVisit(String mVisit) {
        this.mVisit = mVisit;
    }
}
