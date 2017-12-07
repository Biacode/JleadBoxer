package org.biacode.jleadboxer.client.helper

import com.google.gson.Gson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:05 PM
 */
object ResourceClientHelper {

    //region Deserialization helpers
    fun convertToJson(entity: Any?): String {
        return Gson().toJson(entity)
    }
    //endregion

    //region Lazy initialization helpers
    internal fun <T> readWriteLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = ReadWriteLazyVal(initializer)

    private class ReadWriteLazyVal<T>(private val initializer: () -> T) : ReadWriteProperty<Any?, T> {

        private var value: Any? = null

        operator override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            if (value == null) {
                value = (initializer()) ?: throw IllegalStateException("Initializer block of property ${property.name} return null")
            }
            @Suppress("UNCHECKED_CAST")
            return value as T
        }

        operator override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = value
        }

    }
    //endregion
}