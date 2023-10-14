package comtugas.salmajasmine.travelapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class Register : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val FULLNAME = "fullname"
        const val EMAIL_KEY = "email_key"
        const val USERNAME = "username"
        const val DATEBIRTH = "date_birth"
        const val PASSWORD_KEY = "password_key"
        const val PHONE = "phone"
    }

    lateinit var btnDatePicker: Button
    lateinit var btnRegister: Button

    lateinit var edtFullname: EditText
    lateinit var edtEmail: EditText
    lateinit var edtUsername: EditText
    lateinit var edtPassword: EditText
    lateinit var edtPhone: EditText

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
        setContentView(R.layout.activity_register)

        btnDatePicker = findViewById(R.id.btnDatePicker)
        btnRegister = findViewById(R.id.btnRegister)

        edtFullname = findViewById(R.id.edtFullName)
        edtEmail = findViewById(R.id.edtEmail)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        edtPhone = findViewById(R.id.edtPhone)

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        email = sharedPreferences.getString("EMAIL_KEY", null)
        password = sharedPreferences.getString("PASSWORD_KEY", null)
        username = sharedPreferences.getString("USERNAME", null)
        fullname = sharedPreferences.getString("FULLNAME", null)
        phone = sharedPreferences.getString("PHONE", null)
        datebirth = sharedPreferences.getString("DATEBIRTH", null)




        btnDatePicker.setOnClickListener {
            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting
            // our day, month and year.
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // on below line we are creating a
            // variable for date picker dialog.
            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our text view.
                    btnDatePicker.text =
                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day
            )
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.show()
        }

        btnRegister.setOnClickListener{
            val editor = sharedPreferences.edit()

            editor.putString(USERNAME, edtUsername.text.toString())
            editor.putString(PASSWORD_KEY, edtPassword.text.toString())
            editor.putString(FULLNAME, edtFullname.text.toString())
            editor.putString(EMAIL_KEY, edtEmail.text.toString())
            editor.putString(PHONE, edtPhone.text.toString())
            editor.putString(DATEBIRTH, btnDatePicker.text.toString())

            // to save our data with key and value.
            editor.apply()

            val i = Intent(this@Register, Login::class.java)
            startActivity(i)
            finish()
        }
    }
}