package comtugas.salmajasmine.travelapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val FULLNAME = "fullname"
        const val EMAIL_KEY = "email_key"
        const val USERNAME = "username"
        const val DATEBIRTH = "date_birth"
        const val PASSWORD_KEY = "password_key"
        const val PHONE = "phone"
    }

    lateinit var btnLogin: Button

    lateinit var edtUsername: EditText
    lateinit var edtPassword: EditText

    private var vUsername: String? = null
    private var vPassword: String? = null

    private lateinit var sharedPreferences: SharedPreferences

    private var fullname: String? = null
    private var username: String? = null
    private var email: String? = null
    private var password: String? = null
    private var datebirth: String? = null
    private var phone: String? = null
    @SuppressLint("SetTextI18n")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)


        sharedPreferences = getSharedPreferences(Register.SHARED_PREFS, Context.MODE_PRIVATE)

        username = sharedPreferences.getString(USERNAME, null)
        password = sharedPreferences.getString(PASSWORD_KEY, null)

        btnLogin.setOnClickListener {
            vUsername = edtUsername.text.toString()
            vPassword = edtPassword.text.toString()

            if(vUsername.equals(username) && vPassword.equals(password)){
                val i = Intent(this@Login, Dashboard::class.java)
                startActivity(i)
                finish()
            }else{
                if(vUsername.equals("") || vPassword.equals("")){
                    Toast.makeText(applicationContext,"Username dan/atau Password masih kosong.",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext,"Username atau Password salah.",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}