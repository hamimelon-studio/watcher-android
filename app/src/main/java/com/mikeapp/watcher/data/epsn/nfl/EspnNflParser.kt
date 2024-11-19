package com.mikeapp.watcher.data.epsn.nfl

import com.google.gson.Gson
import com.mikeapp.watcher.data.epsn.nfl.model.NflTeamScheduleQuery

class EspnNflParser {
    fun parse(json: String): NflTeamScheduleQuery {
        val gson = Gson()
        val query: NflTeamScheduleQuery = gson.fromJson(json, NflTeamScheduleQuery::class.java)
        return query
    }
}