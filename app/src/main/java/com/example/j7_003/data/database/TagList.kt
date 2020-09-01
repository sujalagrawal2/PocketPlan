package com.example.j7_003.data.database

import com.example.j7_003.data.database.database_objects.Tag
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.example.j7_003.MainActivity.Companion.myActivity as mainContext

class TagList : ArrayList<Tag>() {

    init {
        loadFromStaticList()
    }

    private fun loadFromStaticList() {
        val jsonString = mainContext.assets.open("Tags.json").bufferedReader().readText()

        //todo this throws error when adding item due to wrong json?!?!
        this.addAll(GsonBuilder().create()
            .fromJson(jsonString, object : TypeToken<ArrayList<Tag>>() {}.type))
    }
}