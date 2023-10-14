package comtugas.salmajasmine.travelapp

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Order : AppCompatActivity() {
    lateinit var spinFrom: Spinner
    lateinit var spinPlan: Spinner
    lateinit var spinClass: Spinner

    lateinit var edtHarga: EditText
    lateinit var edtQty: EditText

    lateinit var btnCekHarga: Button




    private lateinit var sharedPreferences: SharedPreferences

    private var fullname: String? = null
    private var username: String? = null
    private var sharga: String? = null
    private var sqty: String? = null
    private var harga: Int? = 0
    private var qty: Int? = 0
    private var stotal: String? = null
    private var total: Int? = 0
    private var email: String? = null
    private var vFrom: String? = null
    private var vPlan: String? = null
    private var vClass: String? = null
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        spinClass = findViewById(R.id.spinClass)
        spinFrom = findViewById(R.id.spinFrom)
        spinPlan = findViewById(R.id.spinPlan)
        edtQty = findViewById(R.id.edtQty)
        edtHarga = findViewById(R.id.edtHarga)
        btnCekHarga = findViewById(R.id.btnCekHarga)

        btnCekHarga.setOnClickListener {
           vFrom = spinFrom.selectedItemId.toString()
            vPlan = spinPlan.selectedItemId.toString()
            vClass = spinClass.selectedItemId.toString()

            if(vClass.equals("1")){
                if(vFrom.equals("1")){
                    if(vPlan.equals("2")){
                        sharga = "60000"
                        edtHarga.setText(sharga)
                    }
                }else if(vFrom.equals("2")){
                    if(vPlan.equals("1")){
                        sharga = "70000"
                        edtHarga.setText(sharga)
                    }
                }
            }else if(vClass.equals("2")){
                if(vFrom.equals("1")){
                    if(vPlan.equals("2")){
                        sharga = "90000"
                        edtHarga.setText(sharga)
                    }
                }else if(vFrom.equals("2")){
                    if(vPlan.equals("1")){
                        sharga = "100000"
                        edtHarga.setText(sharga)
                    }
                }
            }
        }


    }
}