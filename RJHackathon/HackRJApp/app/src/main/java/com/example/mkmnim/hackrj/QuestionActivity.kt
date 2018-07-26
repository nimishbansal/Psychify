package com.example.mkmnim.hackrj

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_question.*
import org.json.JSONArray

class QuestionActivity : AppCompatActivity()
{
    lateinit var questionTest: String
    lateinit var options : List<String>

    fun showQuestions(json_data:String,position: Int)
    {
        try
        {

            var choice = 0
            while (true)
            {
                var values: JSONArray = JSONArray(json_data).get(choice) as JSONArray
                val listdata = ArrayList<String>()
                if (values != null)
                {
                    for (i in 0..values.length() - 1)
                    {
                        listdata.add(values.getString(i))
                        Log.i("mytag",listdata.toString())
                    }
                }
                radioButton.visibility = View.GONE
                for (option in 0..listdata.size - 1)
                {
                    var radioOption = RadioButton(this)
                    radioOption.text = listdata[option]
                    questionLinear.addView(radioOption)
                    radioOption.setOnClickListener {
//                        questionLinear.removeAllViews()
                    }

                }
                choice += 1

            }
        }
        catch (ex:Exception)
        {
            Log.i("mytag",ex.message.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        Log.i("mytag","ques")
        var json_data = intent.extras.get("json")
        var position = intent.extras.get("position")
        showQuestions(json_data.toString(),Integer.parseInt(position.toString()))
    }
}