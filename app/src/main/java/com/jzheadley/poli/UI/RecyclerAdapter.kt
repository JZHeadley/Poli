package com.jzheadley.poli.UI

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter>(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecyclerAdapter> {
        override fun createFromParcel(parcel: Parcel): RecyclerAdapter {
            return RecyclerAdapter(parcel)
        }

        override fun newArray(size: Int): Array<RecyclerAdapter?> {
            return arrayOfNulls(size)
        }
    }
}