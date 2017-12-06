package org.biacode.jleadboxer.client.helper

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:05 PM
 */
object ResourceClientHelper {
    fun convertToMap(data: String?): HashMap<String, Any> {
        val mapper = ObjectMapper()
        val typeRef = object : TypeReference<HashMap<String, Any>>() {}
        return mapper.readValue<HashMap<String, Any>>(data, typeRef)
    }

    fun toJson(theMap: Map<String, Any>): String {
        return ObjectMapper().writeValueAsString(theMap)
    }

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
}