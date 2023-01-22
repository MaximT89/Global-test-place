package com.secondworld.globaltestproject.ui.screens.first

import android.graphics.Typeface
import android.text.Annotation
import android.text.SpannableStringBuilder
import android.text.SpannedString
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseViewModel
import com.secondworld.globaltestproject.core.common.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FirstViewModel @Inject constructor(private val provider: ResourceProvider) : BaseViewModel()