package za.ac.iie.myassigment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTextTime = findViewById<EditText>(R.id. edtTextTime)
        val btnMeal = findViewById<Button>(R.id. btnMeal)
        val txtViewMeal = findViewById<TextView>(R.id. txtViewMeal)
        val btnReset = findViewById<Button>(R.id.btnReset )

        btnMeal.setOnClickListener {
            val timeOfDay = edtTextTime.text.toString().trim()


            var mealSuggestion = ""

            if (timeOfDay=="Morning") {
                mealSuggestion = "Breakfast: Eggs, Bacon / Sausage, Toast and Orange Juice"
            }else if (timeOfDay== "Mid-morning") {
                mealSuggestion = "Snack: Fruits or nuts"
            }else if (timeOfDay== "Afternoon"){
                mealSuggestion = "Lunch: Pizza and hot-dogs "
            }else if (timeOfDay== "Mid-afternoon"){
                mealSuggestion = "snack:Pop-corn Tea/Muffins"
            }else if (timeOfDay== "Night"){
                mealSuggestion = "Dinner: Stir Fry or Rice and Chicken/ Burrito"
            }else if (timeOfDay== "Night snack") {
                mealSuggestion = "Snack: Donut, Chocolate cake or a You "
            }else {
                mealSuggestion ="Invalid Input. Please enter Morning, Mid-morning, Afternoon, Mid-afternoon, Night, Night snack. "
            }

            txtViewMeal.text=mealSuggestion


        }

        btnReset.setOnClickListener {
            edtTextTime.text.clear()
            txtViewMeal.text="Meal Suggesten "
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}