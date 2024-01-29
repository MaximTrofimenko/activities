package com.tmg.activities.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

class LoggerMain<in R : Any> : ReadOnlyProperty<R, Logger> {

    private fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)

    override fun getValue(thisRef: R, property: KProperty<*>) = getLogger(getClassForLogging(thisRef.javaClass))

    private fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
        return javaClass.enclosingClass?.takeIf {
            it.kotlin.companionObject?.java == javaClass
        } ?: javaClass
    }
}