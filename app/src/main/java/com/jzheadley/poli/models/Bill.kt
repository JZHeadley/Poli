package com.jzheadley.poli.models

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
class Bill(
        val billId: Long,
        val summary: String,
        val urlToArticle: String) : Parcelable
