package `in`.bitcode.sqlite

import android.app.Activity
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    //private lateinit var db : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbUtil = DBUtil(this)

        /*dbUtil.addProduct(104, "Demo product 4", 1004)
        dbUtil.addProduct(105, "Demo product 5", 1005)
        dbUtil.fetchProducts()


        dbUtil.addProduct(106, "Demo product 6", 1006)
        val products = dbUtil.fetchProducts()
        for(product in products) {
            mt(product.toString())
        }

        var isUpdated = dbUtil.updateProduct(104, "New Product title 04", 4000)
        mt("Update: $isUpdated")
        isUpdated = dbUtil.updateProduct(1004, "New Product title 04", 4000)
        mt("Update: $isUpdated")*/

        dbUtil.addProduct(3001, "Test Product 3001", 30000)
        for(product in dbUtil.fetchProducts() ) {
            mt(product.toString())
        }

        dbUtil.updateProduct(3001, "Test Product 3001-Updated", 3333)
        for(product in dbUtil.fetchProducts() ) {
            mt(product.toString())
        }

        dbUtil.deleteProduct(3001)
        for(product in dbUtil.fetchProducts() ) {
            mt(product.toString())
        }


        /*var isDeleted = dbUtil.deleteProduct(104)
        mt("Delete: $isDeleted")
        isDeleted = dbUtil.deleteProduct(104)
        mt("Delete: $isDeleted")
        */

        /*db = openOrCreateDatabase("db_ecomm", Activity.MODE_PRIVATE, null)

        try {
            db.execSQL("create table products(id integer primary key, title text not null, price integer)")
        }
        catch (e : Exception){}*/

        /*db.rawQuery("insert into products values(101, 'Demo Product 1', 1001)", null)
        val args = arrayOf("102", "Demo product 2", "1002")
        db.rawQuery("insert into products values(?, ?, ?)", args)*/

        /*val values = ContentValues()
        values.put("id", 103)
        values.put("title", "Demo product 3")
        values.put("price", 1003)

        var rowNum = db.insert("products", null, values)
        mt("Row num: $rowNum")

        db.close()*/
    }

    private fun mt(text : String) {
        Log.e("tag", text)
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}