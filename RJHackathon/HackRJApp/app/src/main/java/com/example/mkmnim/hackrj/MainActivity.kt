package com.example.mkmnim.hackrj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity  : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var testList = Details.tests
        testList[0].jsonData = utils.getJson("Narcism.json", this)
        var adapter = CustomListAdapter(this,testList)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
                        var quizActivity = Intent(applicationContext, QuestionActivity::class.java)
            quizActivity.putExtra("position", position)
            quizActivity.putExtra("json", testList[0].jsonData)
            startActivity(quizActivity)
//            startActivity(Intent(applicationContext,QuestionActivity::class.java))
        }

    }
}