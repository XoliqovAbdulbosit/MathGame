package com.example.mathgame.Model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreference(context: Context) {
    private val shared = context.getSharedPreferences("data", 0)
    private val edit = shared.edit()
    private val gson = Gson()
    private val typeToken = object : TypeToken<List<Pair<String, Int>>>() {}.type

    enum class RecordType(val key: String) {
        EASY("easy_records"), MEDIUM("medium_records"), HARD("hard_records")
    }

    fun getRecords(recordType: RecordType): List<Pair<String, Int>> {
        val data = shared.getString(recordType.key, "")
        if (data == "") return listOf()
        return gson.fromJson(data, typeToken)
    }

    fun addRecord(name: String, score: Int, recordType: RecordType): List<Pair<String, Int>> {
        val list = getRecords(recordType).toMutableList()
        list.add(Pair(name, score))
        edit.putString(recordType.key, gson.toJson(list)).apply()
        return list
    }
}