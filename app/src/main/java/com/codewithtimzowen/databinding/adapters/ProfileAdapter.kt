package com.codewithtimzowen.databinding.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codewithtimzowen.databinding.R
import com.codewithtimzowen.databinding.models.DataProfile

// step 3 ---> profile adapter and extending recyclerView & implement methods
class ProfileAdapter (private val mSpeakerList : List<DataProfile>) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>(){

    // onclick 003
    private lateinit var mListener : OnItemClickListener

    // step 4--->implement the methods of the recyclerview (ALT + ENTER with cursor in profile adapter)

    // step 6---> inflate the layout created in the xml for speaker profile
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewSpeaker = LayoutInflater.from(parent.context)
            .inflate(R.layout.speaker_profile, parent,false)

        return ViewHolder(viewSpeaker, mListener)
    }

    // step 7----- get the current item in list and match it to the data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentSpeaker =mSpeakerList[position]

        holder.userNameSpeaker.setText(currentSpeaker.speakerName)
        holder.userTopicSpeaker.setText(currentSpeaker.speakerTopic)
        holder.userRoleSpeaker.setText(currentSpeaker.speakerRole)
        holder.userProfileSpeaker.setImageResource(currentSpeaker.speakerProfile)
    }

    // step 5----> get item count
    override fun getItemCount(): Int {
        return mSpeakerList.size
    }


    //step 01--->Define a class that will hold our vies from the layout defined
    // onClick 001 --> add lister as parameter
    class ViewHolder(ItemView : View,listener : OnItemClickListener) : RecyclerView.ViewHolder(ItemView){

        // step 02---->Attach the views from the layout
        val userNameSpeaker : TextView = itemView.findViewById(R.id.tv_Name)
        val userTopicSpeaker : TextView = itemView.findViewById(R.id.tv_Topic)
        val userRoleSpeaker : TextView = itemView.findViewById(R.id.tv_Role)
        val userProfileSpeaker : ImageView = itemView.findViewById(R.id.iv_speakerProfile)

        // onclick 002
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }

    }

    // onclick ---> 004
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    // onclick --005
    fun setOnClickListener(listener: OnItemClickListener){
        mListener = listener
    }
}