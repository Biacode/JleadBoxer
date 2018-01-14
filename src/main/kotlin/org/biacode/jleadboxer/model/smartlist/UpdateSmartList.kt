package org.biacode.jleadboxer.model.smartlist

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * User: Syuzanna Eprikyan
 * Date: 1/10/18
 * Time: 5:10 PM
 */

class UpdateSmartListRequest(
        val apiKey: String,
        val email: String,
        val accountId: String,
        val smartlistId: String,
        val type: SmartListType? = null,
        val additionalCsvFields: String? = null,
        val dayOfWeek: DayOfWeek = DayOfWeek.MONDAY,
        val exitLinkFilter: String? = null,
        val fieldFilter: String? = null,
        val format: Format? = null,
        val mailTemplate: String? = null,
        val notificationMailIds: String? = null,
        val notificationType: NotificationType? = null,
        val numberFilter: String? = null,
        val search: String? = null,
        val sortBy: SortBy = SortBy.SCORE,
        val sortOrder: SortOrder = SortOrder.DESC,
        val textFilter: String? = null,
        val timeFilter: String? = null
) {
    private constructor(builder: Builder) : this(
            builder.apiKey,
            builder.email,
            builder.accountId,
            builder.smartlistId,
            builder.type,
            builder.additionalCsvFields,
            builder.dayOfWeek,
            builder.exitLinkFilter,
            builder.fieldFilter,
            builder.format,
            builder.mailTemplate,
            builder.notificationMailIds,
            builder.notificationType,
            builder.numberFilter,
            builder.search,
            builder.sortBy,
            builder.sortOrder,
            builder.textFilter,
            builder.timeFilter
    )

    companion object {
        inline fun build(
                apiKey: String,
                email: String,
                accountId: String,
                smartlistId: String,
                type: SmartListType? = null,
                block: Builder.() -> Unit
        ) = Builder(apiKey, email, accountId, smartlistId, type).apply(block).build()
    }

    class Builder(
            val apiKey: String,
            val email: String,
            val accountId: String,
            val smartlistId: String,
            val type: SmartListType? = null
    ) {
        var additionalCsvFields: String? = null
        var dayOfWeek: DayOfWeek = DayOfWeek.MONDAY
        var exitLinkFilter: String? = null
        var fieldFilter: String? = null
        var format: Format? = null
        var mailTemplate: String? = null
        var notificationMailIds: String? = null
        var notificationType: NotificationType? = null
        var numberFilter: String? = null
        var search: String? = null
        var sortBy: SortBy = SortBy.SCORE
        var sortOrder: SortOrder = SortOrder.DESC
        var textFilter: String? = null
        var timeFilter: String? = null

        fun build() = UpdateSmartListRequest(this)
    }
}

class UpdateSmartListResponse : CommonJLeadBoxerResponse()