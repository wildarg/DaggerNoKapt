package com.wild.mydaggernokaptapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wild.mydaggernokaptapp.di.ActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var greetings: Greetings

    private val button: View by lazy { findViewById(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityComponent.initAndInject(this)
        button.setOnClickListener(this::onClick)
    }

    private fun onClick(view: View) {
        greetings.sayHello("Alexey")
    }
}

interface Toaster {
    fun toast(msg: String)
}

interface Greetings {
    fun sayHello(name: String)
}

class GreetingsImpl @Inject constructor(
    private val toaster: Toaster
) : Greetings {

    override fun sayHello(name: String) {
        toaster.toast("Hello $name")
    }

}

class AndroidToaster @Inject constructor(private val context: Context) : Toaster {

    override fun toast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}