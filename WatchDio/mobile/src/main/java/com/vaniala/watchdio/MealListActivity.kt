package com.vaniala.watchdio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vaniala.watchdio.databinding.ActivityMealListBinding

class MealListActivity : AppCompatActivity(), MealListAdapter.Callback {

  private var adapter: MealListAdapter? = null

  private lateinit var binding: ActivityMealListBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMealListBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val meals = MealStore.fetchMeals(this)
    adapter = MealListAdapter(meals, this)
    binding.list.adapter = adapter
    binding.list.layoutManager = LinearLayoutManager(this)
  }

  override fun mealClicked(meal: Meal) {
    // TODO: Handle this meal click!
  }
}
