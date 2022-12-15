package com.secondworld.globaltestproject.ui.screens.first.model.main_rv

data class BigModel(
    val listCategory : List<Category>? = null
)

data class Category(
    val id : Int,
    val bannerImg : Int? = null,
    val button : ButtonClass? = null,
    val mainContentItems : List<MainContentItems>? = null
)

data class ButtonClass(
    val titleButton : String
)

data class MainContentItems(
    val title : String,
    val listSmallItems : List<SmallItem>? = null
)

data class SmallItem(
    val image : Int,
    val title : String
)