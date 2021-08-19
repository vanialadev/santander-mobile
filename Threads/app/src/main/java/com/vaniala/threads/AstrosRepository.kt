package com.vaniala.threads

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class AstrosRepository {

    fun loadAstros(): AstrosResult? {
        val client = OkHttpClient()
        val request = Request
            .Builder()
            .url("http://api.open-notify.org/astros.json")
            .build()

        val response = client.newCall(request).execute()
        return parseResultToJson(response.body?.string())
    }

    private fun parseResultToJson(body: String?) =
        Gson().fromJson(body, AstrosResult::class.java)

}