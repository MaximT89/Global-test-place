package com.secondworld.globaltestproject.ui.feature_one.screen_one

import com.secondworld.globaltestproject.core.recycler.Match

data class AdapterModel(val id: Int, val name: String) : Match<AdapterModel> {
    override fun matches(model: AdapterModel): Boolean {
        return model == this
    }

    override fun matchesId(model: AdapterModel): Boolean {
        return model.id == this.id
    }
}