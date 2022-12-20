package com.secondworld.globaltestproject.core.recycler


/**
 * Данным интерфейсом помечаем модель данных для которой будем создавать diffUtil
 */
interface Match<T> : MatchId<T>, MatchContent<T>

interface MatchContent<T> {
    fun matches(model: T): Boolean
}

interface MatchId<T> {
    fun matchesId(model: T): Boolean
}