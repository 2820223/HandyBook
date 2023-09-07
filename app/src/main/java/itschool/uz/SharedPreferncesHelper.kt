package itschool.uz

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    fun saveUserDetails(email: String, password: String) {
        sharedPreferences.edit().apply {
            putString("email", email)
            putString("password", password)
            putBoolean("status", true)
            apply()
        }
    }

    fun getUserEmail(): String? {
        return sharedPreferences.getString("email", null)
    }

    fun getUserPassword(): String? {
        return sharedPreferences.getString("password", null)
    }

    fun getUserStatus(): Boolean {
        return sharedPreferences.getBoolean("status", false)
    }
}
