package org.biacode.jleadboxer.client.helper

import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Reader
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:05 PM
 */
object ResourceClientHelper {

    //region Java helpers
    fun ignoreHandling() = { _: Request, _: Response, _: Result<Any, Exception> -> Unit }
    //endregion

    //region Deserialization helpers
    fun convertToJson(entity: Any?): String {
        return Gson().toJson(entity)
    }

    fun <T : Any> deserializer(): ResponseDeserializable<T> = JLeadBoxerJsonDeserializer()

    private class JLeadBoxerJsonDeserializer<out T : Any> : ResponseDeserializable<T> {
        override fun deserialize(reader: Reader): T? {
            return Gson().fromJson(reader, object : TypeToken<T>() {}.type)
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