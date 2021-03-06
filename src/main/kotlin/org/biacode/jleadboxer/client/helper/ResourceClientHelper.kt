package org.biacode.jleadboxer.client.helper

import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.result.Result
import com.google.gson.Gson
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

    fun <T : Any> deserializer(clazz: Class<T>): ResponseDeserializable<T> = JLeadBoxerJsonDeserializer(clazz)

    private class JLeadBoxerJsonDeserializer<out T : Any>(private val clazz: Class<T>) : ResponseDeserializable<T> {
        override fun deserialize(reader: Reader): T? {
            return Gson().fromJson(reader, clazz)
        }
    }
    //endregion

    //region Lazy initialization helpers
    internal fun <T> readWriteLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = ReadWriteLazyVal(initializer)

    private class ReadWriteLazyVal<T>(private val initializer: () -> T) : ReadWriteProperty<Any?, T> {

        private var value: Any? = null

        override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            if (value == null) {
                value = (initializer()) ?: throw IllegalStateException("Initializer block of property ${property.name} return null")
            }
            @Suppress("UNCHECKED_CAST")
            return value as T
        }

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = value
        }

    }
    //endregion
}