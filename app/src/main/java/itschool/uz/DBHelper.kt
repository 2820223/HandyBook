package itschool.uz

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: LoginFragment):SQLiteOpenHelper(context.requireActivity(), "Userdata", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
 db?.execSQL("create table Userdata (email TEXT primary key, password TEXT primary key) ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Userdata")
    }
fun insertdata(email : String, password : String): Boolean{
    val db = this.writableDatabase
    val cv = ContentValues()
    cv.put("email", email)
    cv.put("password", password)
    val result = db.insert("Userdata", null, cv)
    if(result== -1  .toLong()){
        return false
    }
    return true
}
    @SuppressLint("SuspiciousIndentation")
    fun checkuserpass(email: String, password: String): Boolean{
        val db = this.writableDatabase
        val query = "select * from Userdata where email= '$email' and password= '$password'"
        val cursor = db.rawQuery(query, null)
            if (cursor.count<=0){
                cursor.close()
                return false
            }
        cursor.close()
        return true
    }


}