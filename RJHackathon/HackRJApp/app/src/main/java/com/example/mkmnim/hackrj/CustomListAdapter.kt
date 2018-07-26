package com.example.mkmnim.hackrj

/**
 * Created by nimish on 26/7/18.
 */
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by Sanjeev k Saroj on 28/2/17.
 */

class CustomListAdapter(internal var activity: Activity, customListDataModelArray: List<Test>) : BaseAdapter()
{
    lateinit var customListDataModelArrayList:List<Test>
    internal var layoutInflater: LayoutInflater? = null
    private var viewHolder: ViewHolder? = null

    init
    {
        this.customListDataModelArrayList = customListDataModelArray
        layoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getCount(): Int
    {
        return customListDataModelArrayList.size
    }

    override fun getItem(i: Int): Any
    {
        return customListDataModelArrayList.get(i)
    }

    override fun getItemId(i: Int): Long
    {
        return i.toLong()
    }

    private class ViewHolder
    {
        internal var image_view: ImageView? = null
        internal var tv_name: TextView? = null
        internal var tv_discription: TextView? = null

    }


    // this method  is called each time for arraylist data size.
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View?
    {

        var vi: View? = view
        if (vi == null)
        {

            // create  viewholder object for list_rowcell View.
            viewHolder = ViewHolder()
            // inflate list_rowcell for each row
            vi = layoutInflater!!.inflate(R.layout.list_rowcell, null)
//            viewHolder!!.image_view = vi!!.findViewById(R.id.image_view) as ImageView
            viewHolder!!.tv_name = vi.findViewById(R.id.tv_name) as TextView
            viewHolder!!.tv_discription = vi.findViewById(R.id.tv_discription) as TextView
            /*We can use setTag() and getTag() to set and get custom objects as per our requirement.
            The setTag() method takes an argument of type Object, and getTag() returns an Object.*/
            vi.tag = viewHolder
        }
        else
        {

            /* We recycle a View that already exists */
            viewHolder = vi.tag as ViewHolder
        }

//        viewHolder!!.image_view!!.setImageResource(customListDataModelArrayList.get(position).image_id)
        viewHolder!!.tv_name!!.setText(customListDataModelArrayList.get(position).name)
        viewHolder!!.tv_discription!!.setText(customListDataModelArrayList.get(position).api_endpoint)


        return vi
    }
}