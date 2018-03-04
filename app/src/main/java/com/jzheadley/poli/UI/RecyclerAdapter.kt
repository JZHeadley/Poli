package com.jzheadley.poli.UI

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter>(), Parcelable {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerAdapter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerAdapter?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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