package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme




import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var taskLayout: LinearLayout
    private lateinit var addButton: Button
    private lateinit var taskInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        // Створюємо LinearLayout для всього інтерфейсу
        val mainLayout = LinearLayout(this)
        mainLayout.orientation = LinearLayout.VERTICAL

        // Створюємо поле для введення нового завдання
        taskInput = EditText(this)
        taskInput.hint = "Enter task"
        mainLayout.addView(taskInput)

        // Кнопка для додавання завдання
        addButton = Button(this)
        addButton.text = "Add Task"
        mainLayout.addView(addButton)

        // LinearLayout для списку завдань
        taskLayout = LinearLayout(this)
        taskLayout.orientation = LinearLayout.VERTICAL
        mainLayout.addView(taskLayout)

        // Встановлюємо головний макет активності
        setContentView(mainLayout)

        // Дія для додавання нового завдання
        addButton.setOnClickListener {
            val taskText = taskInput.text.toString()
            if (taskText.isNotEmpty()) {
                addTask(taskText)
                taskInput.text.clear()  // Очищаємо поле вводу після додавання завдання
            }
        }
    }

    // Функція для додавання нового завдання в список
    private fun addTask(taskName: String) {
        val taskLayoutItem = LinearLayout(this)
        taskLayoutItem.orientation = LinearLayout.HORIZONTAL

        // Створюємо CheckBox для позначення завдання як виконаного
        val checkBox = CheckBox(this)
        taskLayoutItem.addView(checkBox)

        // Створюємо TextView для відображення тексту завдання
        val taskTextView = TextView(this)
        taskTextView.text = taskName
        taskLayoutItem.addView(taskTextView)

        // Додаємо нове завдання в taskLayout (це буде відображатися в інтерфейсі)
        taskLayout.addView(taskLayoutItem)
    }
}