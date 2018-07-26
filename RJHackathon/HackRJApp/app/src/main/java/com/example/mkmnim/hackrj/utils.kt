package com.example.mkmnim.hackrj


import android.content.Context
import android.util.Log
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by nimish on 26/7/18.
 */
object utils
{
    fun getJson(filename: String, context: Context): String?
    {
        var json: String? = null
        try
        {
            var iqw = context.getAssets().open(filename)
            val size = iqw.available()

            val buffer = ByteArray(size)
            iqw.read(buffer)
            iqw.close()
            json = String(buffer, Charset.defaultCharset())
        }
        catch (ex: IOException)
        {
            ex.printStackTrace()
            Log.i("mytag", "error hai bhyi")

        }
        return json
    }
}