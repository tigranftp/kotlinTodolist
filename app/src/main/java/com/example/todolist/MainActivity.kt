package com.example.todolist

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapter.TaskAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.TaskModel
import java.util.UUID


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var adapter: TaskAdapter
    lateinit var recycler: RecyclerView
    var curList =  ArrayList<TaskModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        recycler = binding.tasksRecyclerView
        adapter = TaskAdapter()
        recycler.adapter = adapter
        initList()
        adapter.setList(curList)
    }

    private fun initList() {
        val task1 = TaskModel("task 1", true)
        curList.add(task1)
        val task2 = TaskModel("task 2", false)
        curList.add(task2)
    }

    fun onClick(view: View) {
        val newTask = TaskModel("task " + UUID.randomUUID().toString(), false)
        curList.add(newTask)
        adapter.setList(curList)
    }
}