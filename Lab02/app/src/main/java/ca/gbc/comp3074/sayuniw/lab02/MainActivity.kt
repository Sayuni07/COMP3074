package ca.gbc.comp3074.sayuniw.lab02

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0
    private var step = 1

    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOutput = findViewById(R.id.tvOutput)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnStep = findViewById<Button>(R.id.btnStep)


        savedInstanceState?.let {
            count = it.getInt("count", 0)
            step = it.getInt("step", 1)
        }
        updateOutput()

        btnAdd.setOnClickListener {
            count += step
            updateOutput()
        }

        btnSubtract.setOnClickListener {
            count -= step
            updateOutput()
        }

        btnReset.setOnClickListener {
            count = 0
            step = 1
            updateOutput()
        }

        btnStep.setOnClickListener {
            step = 2
        }
    }

    private fun updateOutput() {
        tvOutput.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
        outState.putInt("step", step)
    }
}