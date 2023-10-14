package comtugas.salmajasmine.travelapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Dashboard : AppCompatActivity() {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val FULLNAME = "fullname"
        const val EMAIL_KEY = "email_key"
        const val USERNAME = "username"
        const val DATEBIRTH = "date_birth"
        const val PASSWORD_KEY = "password_key"
        const val PHONE = "phone"
    }

    lateinit var txtWelcome: TextView

    lateinit var btnOrder: Button
    lateinit var btnLogout: Button

    private lateinit var sharedPreferences: SharedPreferences

    private var fullname: String? = null
    private var username: String? = null
    private var email: String? = null


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        txtWelcome = findViewById(R.id.txtWelcome)
        btnOrder = findViewById(R.id.btnOrder)
        btnLogout = findViewById(R.id.btnLogout)

        sharedPreferences = getSharedPreferences(Register.SHARED_PREFS, Context.MODE_PRIVATE)

        username = sharedPreferences.getString(USERNAME, null)
        fullname = sharedPreferences.getString(FULLNAME, null)
        email = sharedPreferences.getString(EMAIL_KEY, null)

        txtWelcome.text = "Welcome , $fullname"

        btnOrder.setOnClickListener {
            val i = Intent(this@Dashboard, Order::class.java)
            startActivity(i)
            finish()
        }

        btnLogout.setOnClickListener {
            val i = Intent(this@Dashboard, Login::class.java)
            startActivity(i)
            finish()
        }

    }
}