package com.exampl.anagramtexts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    var string1: EditText?=null
    var string2: EditText?=null
    //var first: String?=null
    // var second:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        string1 = findViewById<EditText>(R.id.edit_query1)
        string2 = findViewById<EditText>(R.id.edit_query2)

        findViewById<View>(R.id.buttonPanel).setOnClickListener {
            val input1 = string1?.text.toString().trim()
            val input2 = string2?.text.toString().trim()

            if ( input1.trim()=="" ||  input2.trim()==""){
                Toast.makeText(this,"please input text, edit text cannot be blank", Toast.LENGTH_LONG).show()
            }else{
                if (isAnagrams(input1, input2)) {
                    Toast.makeText(this, "Both texts are Anagram", Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this, "Both texts are not Anagram", Toast.LENGTH_LONG).show()
            }

        }

    }
}

/**
 * Function to check two strings are anagram string or not
 */

fun isAnagrams(str1: String, str2: String): Boolean {


    //Both String Length must be Equal
    if (str1.length != str2.length) {
        return false
    }

    //Convert Strings to character Array
    val strArray1 = str1.toCharArray()
    val strArray2 = str2.toCharArray()

    //Sort the Arrays
    Arrays.sort(strArray1)
    Arrays.sort(strArray2)

    //Convert Arrays to String
    val sortedStr1 = String(strArray1)
    val sortedStr2 = String(strArray2)

    //Check Both String Equals or not After Sorting
    //and Return value True or False
    return sortedStr1 == sortedStr2
}
