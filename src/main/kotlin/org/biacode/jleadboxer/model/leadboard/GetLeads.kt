package org.biacode.jleadboxer.model.leadboard

/**
 * Created by Arthur Asatryan.
 * Date: 12/8/17
 * Time: 3:10 PM
 */
class GetLeadsRequest(
        val apiKey: String,
        val site: String,
        val search: String = "*",
        val limit: Int = 50,
        val locale: String = "en_US",
        val nextToken: String? = null,
        val criteriaTextFilter: String? = null,
        val criteriaNumberFilter: String? = null,
        val criteriaTimeFilter: String? = null,
        val criteriaFieldFilter: String? = null,
        val criteriaExitLinkFilter: String? = null,
        val usePresetExclusionList: String? = null,
        val usePresetInclusionList: String? = null,
        val showColumns: String = "*",
        val email: String? = null,
        val login: String? = null,
        val period: String = "1d",
        val noShortenEmail: String? = null,
        val date: String? = null,
        val unixTime: Int? = null,
        val sortBy: String? = null,
        val showLeadList: String? = null,
        val showAllLeadsFor: String? = null,
        val dataType: String = "jsonData",
        val col: String? = null,
        val hideColumns: String? = null,
        val variant: String? = null,
        val ignoreLocale: Boolean = true,
        val dateFormat: String = "yyyy-MM-dd HH:mm:ss"
) {

    private constructor(builder: Builder) : this(
            builder.apiKey,
            builder.site,
            builder.search,
            builder.limit,
            builder.locale,
            builder.nextToken,
            builder.criteriaTextFilter,
            builder.criteriaNumberFilter,
            builder.criteriaTimeFilter,
            builder.criteriaFieldFilter,
            builder.criteriaExitLinkFilter,
            builder.usePresetExclusionList,
            builder.usePresetInclusionList,
            builder.showColumns,
            builder.email,
            builder.login,
            builder.period,
            builder.noShortenEmail,
            builder.date,
            builder.unixTime,
            builder.sortBy,
            builder.showLeadList,
            builder.showAllLeadsFor,
            builder.dataType,
            builder.col,
            builder.hideColumns,
            builder.variant,
            builder.ignoreLocale,
            builder.dateFormat
    )

    companion object {
        inline fun build(
                apiKey: String,
                site: String,
                block: Builder.() -> Unit
        ) = Builder(apiKey, site).apply(block).build()
    }

    class Builder(
            val apiKey: String,
            val site: String
    ) {
        var search: String = "*"
        var limit: Int = 50
        var locale: String = "en_US"
        var nextToken: String? = null
        var criteriaTextFilter: String? = null
        var criteriaNumberFilter: String? = null
        var criteriaTimeFilter: String? = null
        var criteriaFieldFilter: String? = null
        var criteriaExitLinkFilter: String? = null
        var usePresetExclusionList: String? = null
        var usePresetInclusionList: String? = null
        var showColumns: String = "*"
        var email: String? = null
        var login: String? = null
        var period: String = "1d"
        var noShortenEmail: String? = null
        var date: String? = null
        var unixTime: Int? = null
        var sortBy: String? = null
        var showLeadList: String? = null
        var showAllLeadsFor: String? = null
        var dataType: String = "jsonData"
        var col: String? = null
        var hideColumns: String? = null
        var variant: String? = null
        var ignoreLocale: Boolean = true
        var dateFormat: String = "yyyy-MM-dd HH:mm:ss"

        fun build() = GetLeadsRequest(this)
    }
}

data class GetLeadsResponse(
        val rows: Int? = null,
        val nextToken: String? = null,
        val total: Int? = null,
        val resultsList: List<Map<String, Any>>? = null,
        val site: String? = null,
        val timeZone: String? = null
)