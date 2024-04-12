package `in`.bitcode.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProductsDBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    //DB management logic goes here

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table products(id integer primary key, title text not null, price integer)")
        db!!.execSQL("create table customers(id integer primary key, name text not null, contact integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}