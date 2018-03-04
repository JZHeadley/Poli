package com.jzheadley.poli.models

import java.sql.Date

class Bill(
        val billId: Long,
        val summary: String,
        val dateFound: Date,
        val urlToArticle: String) {
}