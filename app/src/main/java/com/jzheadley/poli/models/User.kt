package com.jzheadley.poli.models

import java.sql.Date

data class User(
        val userId: String,
        var name: String,
        var dob: Date,
        var race: String,
        var gender: String,
        var maritalStatus: String,
        var religion: String,
        var annHouseholdIncome: String,
        var politicalStanding: String,
        var numChildren: Int,
        var sexualOrientation: String)