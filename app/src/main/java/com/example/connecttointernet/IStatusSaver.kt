package com.example.connecttointernet

interface IStatusSaver {
    fun saveStatus(status: Boolean)//abstraction should NOT depend on details(used tool)
}