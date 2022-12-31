package com.secondworld.globaltestproject.ui

import android.app.Activity
import android.opengl.GLSurfaceView
import android.os.Bundle

class MainActivity : Activity() {

    private lateinit var gLView: GLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gLView = MyGLSurfaceView(this)
        setContentView(gLView)
    }

    // https://developer.android.com/develop/ui/views/graphics/opengl/projection
    // продолжить отсюда

}

