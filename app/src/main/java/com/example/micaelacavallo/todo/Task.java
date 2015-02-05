package com.example.micaelacavallo.todo;

/**
 * Created by micaela.cavallo on 05/02/2015.
 */
public class Task {
    private String mTitle;
    private Boolean mDone;

    public Task(String mTitle) {
        this.mTitle = mTitle;
        mDone = false;
    }

    public Boolean getDone() {
        return mDone;
    }

    public void setDone(Boolean mDone) {
        this.mDone = mDone;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String toString (){
        return mTitle;
    }
}
