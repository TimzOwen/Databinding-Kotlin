package com.codewithtimzowen.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.icon_share -> shareMeetUp()
            R.id.icon_home -> startActivity(Intent(this@SpeakerProfileActivity, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    // open a an activity to share intents
    private fun shareMeetUp() {
        Toast.makeText(this, "No links yet....", Toast.LENGTH_SHORT).show()
    }
}