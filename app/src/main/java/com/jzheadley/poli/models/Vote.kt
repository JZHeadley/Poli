package com.jzheadley.poli.models

import java.sql.Date

class Vote(
        val voteId: Long,
        val user: User,
        val bill: Bill,
        val date: Date,
        val supporting: Boolean,
        val comments: String) {
}