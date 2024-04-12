package `in`.bitcode.sqlite

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.widget.Toast

class DBUtil(
    private val context: Context
) {

    private val db : SQLiteDatabase = ProductsDBHelper(context, "db_products", null, 1)
        .writableDatabase

    /*private val db: SQLiteDatabase =
        context.openOrCreateDatabase("db_products", Activity.MODE_PRIVATE, null)

    init {
        try {
            db.execSQL("create table products(id integer primary key, title text not null, price integer)")
        } catch (e: Exception) {
        }
    }
    */


    fun addProduct(id: Int, title: String, price: Int): Boolean {
        val values = ContentValues()
        values.put("id", id)
        values.put("title", title)
        values.put("price", price)

        val rowNum = db.insert("products", null, values)
        mt("$rowNum")

        return rowNum.toInt() != -1
    }

    fun fetchProducts() : ArrayList<Product>{

        //"select id , title , price from products where price > 1000 and price < 3000 and dept = 'electronics' group by dept having sum(price) < 10000 order by id asc"
        //val c: Cursor = db.rawQuery("select id, title, price from products", null)
        /*
        //Ecample
        val columns = arrayOf("id", "title", "price")
        val where = "price > ? and price < ? and dept = ?"
        val whereArgs = arrayOf("1000", "2000", "Electronics")
        val groupBy = "dept"
        val having = "sum(price) < 10000"
        val sortOrder = "price desc"
        val c : Cursor = db.query(
            "products",
            columns,
            where,
            whereArgs,
            groupBy,
            having,
            sortOrder
        )*/

        val c = db.query("products", null, null, null, null, null, "id desc")
        val products = ArrayList<Product>()

        while (c.moveToNext()) {
            val id = c.getInt(0)
            val title = c.getString(1)
            val price = c.getInt(2)

            products.add(
                Product(id, title, price)
            )
            mt("id: $id title: $title  price: $price")
        }
        c.close()
        return products
    }

    fun updateProduct(id : Int, title : String, price : Int) : Boolean {
        val values = ContentValues()
        values.put("title", title)
        values.put("price", price)

        val count = db.update("products", values, "id = ?", arrayOf(id.toString()))
        return count != 0
    }

    fun deleteProduct(id : Int) : Boolean {
        val count = db.delete("products", "id = ?", arrayOf(id.toString()))
        return count != 0
    }

    private fun mt(text: String) {
        Log.e("tag", text)
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}