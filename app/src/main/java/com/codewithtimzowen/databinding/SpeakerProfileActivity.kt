package com.codewithtimzowen.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codewithtimzowen.databinding.databinding.ActivitySpeakerProfileBinding

class SpeakerProfileActivity : AppCompatActivity() {

    lateinit var bindingSpeaker : ActivitySpeakerProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSpeaker = ActivitySpeakerProfileBinding.inflate(layoutInflater)
        setContentView(bindingSpeaker.root)

        //get the data from podcast list and post them over here
        val bundle: Bundle? = intent.extras

        val name = bundle!!.getInt("speakerName")
        val topic = bundle.getInt("speakerTopic")
        val profile = bundle.getInt("profilePicture")
        val role = bundle.getInt("speakerRole")

        bindingSpeaker.ivProfile.setImageResource(profile)
        bindingSpeaker.speaker.setText(name)
        bindingSpeaker.tvTopic.setText(topic)
        bindingSpeaker.role.setText(role)




    }
}