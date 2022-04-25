package com.secondworld.globaltestproject.ui

import javax.inject.Inject

interface CommunicationFoo : Communication<Foo> {
    class UpdateUi @Inject constructor() : Communication.UiUpdate<Foo>(), CommunicationFoo
}