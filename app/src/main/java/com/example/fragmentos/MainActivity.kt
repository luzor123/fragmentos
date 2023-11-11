package com.example.fragmentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fragmentos.ui.theme.FragmentosTheme
import androidx.appcompat.app.AppCompatActivity
/*
class MainActivity : AppCompatActivity(), OnSubmitClickListener {

    private lateinit var outputFragment: OutputFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState==null) {
            outputFragment = OutputFragment()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentConatiner, outputFragment)
                .commit()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentConatiner, InputFragment())
                .commit()
        }
    }
/*override fun onSubmitClick(name: String) {
    val newOutputFragment = OutputFragment()
    newOutputFragment.displayGreeting(name)

    supportFragmentManager.beginTransaction()
        .replace(R.id.fragmentConatiner, newOutputFragment)
        .addToBackStack(null)
        .commit()

    }*/
override fun onSubmitClick(name: String) {
    outputFragment.displayGreeting(name)

    // Reemplaza el fragmento de entrada con el fragmento de salida
    supportFragmentManager.beginTransaction()
        .replace(R.id.fragmentConatiner, outputFragment, OutputFragment::class.java.simpleName)
        .addToBackStack(null)
        .commit()
}
}
*/
class MainActivity : AppCompatActivity(), OnSubmitClickListener {

    private lateinit var outputFragment: OutputFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputFragment = supportFragmentManager.findFragmentByTag(OutputFragment::class.java.simpleName) as? OutputFragment
            ?: OutputFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentConatiner, outputFragment, OutputFragment::class.java.simpleName)
                .commit()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentConatiner, InputFragment())
                .commit()
        }
    }

    override fun onSubmitClick(name: String) {
        outputFragment.displayGreeting(name)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentConatiner, outputFragment, OutputFragment::class.java.simpleName)
            .addToBackStack(null)
            .commit()
    }
}



