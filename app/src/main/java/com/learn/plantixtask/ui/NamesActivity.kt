package com.learn.plantixtask.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.learn.plantixtask.R
import com.learn.plantixtask.ui.adapter.NamesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_names.*

@AndroidEntryPoint
class NamesActivity : AppCompatActivity() {

    private val namesViewModel: NamesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names)
        observeLiveData()
        namesViewModel.getNames()
    }

    private fun observeLiveData() {
        namesViewModel.namesList.observe(this, {
            setDataToListView(it)
            progressCircular.visibility = View.GONE
        })

        namesViewModel.error.observe(this, {
            progressCircular.visibility = View.GONE
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun setDataToListView(list: List<String>) {
        rvNames.adapter = NamesAdapter(list)
    }
}