package ru.easycode.zerotoheroandroidtdd

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.databinding.ListItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val inputText = binding.inputEditText.text
            addTextView(inputText.toString())
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textList = binding.contentLayout.children.map{ (it as TextView).text.toString() }.toList()
        outState.putStringArrayList(KEY, ArrayList(textList ))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList(KEY) ?: ArrayList()
        list.forEach { inputText ->
            addTextView(inputText)
        }
    }

    fun addTextView(inputText: CharSequence) {
        val listBinding = ListItemBinding.inflate(layoutInflater)
        val textView = listBinding.root
        textView.text = inputText
        binding.contentLayout.addView(textView)
    }

    companion object {
        private const val KEY = "list"
    }
}