package com.secondworld.globaltestproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.secondworld.globaltestproject.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

   private val _listData = MutableLiveData<List<PizzaItem>>()
   val listData : LiveData<List<PizzaItem>> = _listData

    init {
        newList()
    }

    private fun newList() {
        _listData.value = generateItems()
    }

    private fun generateItems() : List<PizzaItem> {

        val list = mutableListOf<PizzaItem>()
        list.add(PizzaItem("Маргарита", "Тесто дрожжевое, сыр Моцарелла, соус чеддер, сливки, вешенки, сыр пармезан, куриное филе, бекон, масло чесночное, сушеный базилик", R.drawable.pizza_1, 450))
        list.add(PizzaItem("Поморская", "Тесто дрожжевое, сыр Моцарелла, соус фирменный, филе трески, помидоры черри, соус песто, брокколи, салат руккола, сушеный базилик", R.drawable.pizza_2, 800))
        list.add(PizzaItem("Ветчина и грибы ", "Тесто дрожжевое, сыр моцарелла, ветчина, соус томатный, помидоры свежие, шампиньоны свежие, сушеный базилик.", R.drawable.pizza_3, 650))
        list.add(PizzaItem("4 сыра", "Тесто дрожжевое, сыр гауда, сыр пармезан, сыр с голубой плесенью, сушеный базилик.", R.drawable.pizza_4, 380))
        return list
    }
}