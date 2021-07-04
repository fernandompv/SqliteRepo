package com.sdos.aplication.Model;

import android.provider.ContactsContract;

public class DataClient implements Comparable<DataClient>{

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

    @Override
    public int compareTo(DataClient dataClient) {
        if(dataClient.getCode().equals("CODIGO") || this.mCode.equals("CODIGO"))
            return 0;
        else
            return Integer.compare(Integer.parseInt(this.mCode), Integer.parseInt(dataClient.getCode()));
    }
}
