package org.biacode.jleadboxer.model.smartlist

/**
 * User: Syuzanna Eprikyan
 * Date: 1/11/18
 * Time: 12:08 PM
 */

data class SmartList @JvmOverloads constructor(
        val accountId: String? = null,
        val additionalCsvFields: String? = null,
        val createdTimestamp: String? = null,
        val datasetId: String? = null,
        val dayOfWeek: Int? = null,
        val exitLinkFilter: String? = null,
        val fieldFilter: String? = null,
        val format: String? = null,
        val mailTemplate: String? = null,
        val modifiedTimestamp: String? = null,
        val name: String? = null,
        val notificationMailIds: String? = null,
        val notificationType: String? = null,
        val numberFilter: String? = null,
        val search: String? = null,
        var smartlistId: Int? = null,
        var sortBy: String? = null,
        var sortOrder: String? = null,
        var textFilter: String? = null,
        var timeFilter: String? = null,
        var type: String? = null,
        val userId: Int? = null
)

enum class NotificationType { NONE, DAILY, WEEKLY }

enum class SortOrder(val order: String) { ASC("asc"), DESC("desc") }

enum class SortBy(val sortProperty: String) { SCORE("_score"), LAST_EVENT("lastEvent") }

enum class SmartListType { USER, ACCOUNT}

enum class DayOfWeek(val day: Int){ MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7)}

enum class Format(val format: String) { HTML("html"), CSV("csv")}