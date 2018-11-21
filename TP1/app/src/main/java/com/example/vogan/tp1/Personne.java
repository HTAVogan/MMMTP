package com.example.vogan.tp1;

import android.os.Parcel;
import android.os.Parcelable;

public class Personne implements Parcelable {
    String pnom;
    String placeOfBirth;
    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(pnom);
        dest.writeString(placeOfBirth);
    }

    public static final Parcelable.Creator<Personne> CREATOR
            = new Parcelable.Creator<Personne>() {
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }

        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };

    private Personne(Parcel in){
        pnom =in.readString();
        placeOfBirth=in.readString();
    }

}
