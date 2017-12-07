package org.biacode.jleadboxer.client.helper

import com.fasterxml.jackson.core.type.TypeReference
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.jackson.mapper
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:05 PM
 */
object ResourceClientHelper {

    //region Json helpers
    fun convertToMap(data: String?): HashMap<String, Any> {
        val typeRef = object : TypeReference<HashMap<String, Any>>() {}
        return mapper.readValue<HashMap<String, Any>>(data, typeRef)
    }

    fun convertToJson(theMap: Map<String, Any>): String {
        return mapper.writeValueAsString(theMap)
    }
    //endregion

    //region Fuel deserializer
    class JacksonFuelDeserializer<out T : Any> : ResponseDeserializable<T> {
        override fun deserialize(bytes: ByteArray): T? {
            return mapper.readValue(bytes, object : TypeReference<T>() {})
        }
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