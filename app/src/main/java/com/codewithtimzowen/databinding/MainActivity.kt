package com.codewithtimzowen.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codewithtimzowen.databinding.adapters.ProfileAdapter
import com.codewithtimzowen.databinding.databinding.ActivityMainBinding
import com.codewithtimzowen.databinding.models.DataProfile

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding  // step 001 ---> initialize data dinging to allow direct calls (avoid crowding onCreate)

    //step 004 -(a)
    lateinit var speakerImages : Array<Int>
    lateinit var speakerNames : Array<Int>
    lateinit var speakerTopics : Array<Int>
    lateinit var speakerRoles : Array<Int>
    lateinit var recyclerView: RecyclerView
    lateinit var speakersList : ArrayList<DataProfile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // -----step 002 (instantiate binding
        setContentView(binding.root) // -----> step 003 ( bind to the root)


        // step 004 (a) ----> // initialize all arrays up the onCreate with the respective data types
        // step 004 (b) ---->create data for images, name, topic , and Role ("Arrays of )

        speakerImages = arrayOf(
            R.drawable.speaker1,
            R.drawable.speaker2,
            R.drawable.speaker3,
            R.drawable.speaker4,
            R.drawable.speaker5,
            R.drawable.speaker6,
        )
        speakerNames = arrayOf(
            R.string.speaker1,
            R.string.speaker2,
            R.string.speaker3,
            R.string.speaker4,
            R.string.speaker5,
            R.string.speaker6,
        )
        speakerTopics = arrayOf(
            R.string.topic1,
            R.string.topic2,
            R.string.topic3,
            R.string.topic4,
            R.string.topic5,
            R.string.topic6,
        )
        speakerRoles = arrayOf(
            R.string.role1,
            R.string.role2,
            R.string.role3,
            R.string.role4,
            R.string.role5,
            R.string.role6,
        )

        // step 5---> find the recyclerview and pass in the layout manager, fixeSize
        recyclerView =binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()

        // step 006 ---> create object instance of ProfileData class
        speakersList = arrayListOf()

        // step 007 ----> call the function to load the data
        getSpeakerData()
    }

    // step 006 ---> get all speaker data and match them
    private fun getSpeakerData(){
        for(i in speakerImages.indices){
            val speakers = DataProfile(speakerImages[i],speakerNames[i],speakerTopics[i],speakerRoles[i])
            speakersList.add(speakers)
        }
        val adapter = ProfileAdapter(speakersList)
        recyclerView.adapter = adapter
    }
}