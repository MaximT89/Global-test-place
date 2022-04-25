package com.secondworld.globaltestproject.ui

interface CommunicationFoo : Communication<Foo> {
    class UpdateUi : Communication.UiUpdate<Foo>(), CommunicationFoo
}