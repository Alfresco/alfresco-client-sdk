package com.alfresco.client.api.search;

import com.alfresco.client.api.search.body.QueryBody;
import com.alfresco.client.api.search.model.ResultNodeRepresentation;
import com.alfresco.client.api.search.model.ResultSetRepresentation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jpascal on 04/10/2016.
 */
public interface SearchAPI
{

    // ///////////////////////////////////////////////////////////////////////////
    // LISTING
    // ///////////////////////////////////////////////////////////////////////////
    /**
     * Searches Alfresco **Note**: this endpoint is available in Alfresco 5.2
     * and newer versions. **You specify all the parameters in this API in a
     * JSON body**, URL parameters are not supported. A basic query looks like
     * this: &#x60;&#x60;&#x60;JSON { \&quot;query\&quot;: {
     * \&quot;query\&quot;: \&quot;foo\&quot; } } &#x60;&#x60;&#x60; **Note:**
     * These are the minimum possible query parameters. The default search
     * language is **afts** ([Alfresco Full Text
     * Search](http://docs.alfresco.com/5.1/concepts/rm-searchsyntax-intro.html)
     * ), but you can also specify **cmis**, and **lucene**. A basic CMIS query
     * looks like this: &#x60;&#x60;&#x60;JSON { \&quot;query\&quot;: {
     * \&quot;query\&quot;: \&quot;select * from cmis:folder\&quot;,
     * \&quot;language\&quot;: \&quot;cmis\&quot; } } &#x60;&#x60;&#x60; By
     * default, **results are limited to the first 100.** Results can be
     * restricted using \&quot;paging\&quot;. For example:
     * &#x60;&#x60;&#x60;JSON \&quot;paging\&quot;: { \&quot;maxItems\&quot;:
     * \&quot;50\&quot;, \&quot;skipCount\&quot;: \&quot;28\&quot; }
     * &#x60;&#x60;&#x60; This example would ensure that results are **limited
     * by Final Size**, skipping the first 28 results and returning the next 50.
     * Alternatively, you can limit the results by using the **limits JSON body
     * parameter**. For example, &#x60;&#x60;&#x60;JSON \&quot;limits\&quot;: {
     * \&quot;permissionEvaluationTime\&quot;: 20000,
     * \&quot;permissionEvaluationCount\&quot;: 2000 } &#x60;&#x60;&#x60; The
     * **default search uses workspace://SpacesStore**. To change the scope to a
     * particular store you can use the **scope JSON body parameter**. For
     * example, &#x60;&#x60;&#x60;JSON \&quot;scope\&quot;: {
     * \&quot;stores\&quot;: [\&quot;archive://SpacesStore\&quot;,
     * \&quot;workspace://SpacesStore\&quot;] } &#x60;&#x60;&#x60; You can use
     * the **include JSON body parameter** to return additional information.
     * This works in the same way as in the /nodes/{nodeId}/children method in
     * the core API. For example: &#x60;&#x60;&#x60;JSON \&quot;include\&quot;:
     * [\&quot;aspectNames\&quot;, \&quot;properties\&quot;,
     * \&quot;isLink\&quot;] &#x60;&#x60;&#x60; You can use the **fields JSON
     * body parameter** to restrict the fields returned within a response if,
     * for example, you want to save on overall bandwidth. This works in the
     * same way as in the /nodes/{nodeId}/children method in the core API. For
     * example: &#x60;&#x60;&#x60;JSON \&quot;fields\&quot;: [\&quot;id\&quot;,
     * \&quot;name\&quot;, \&quot;search\&quot;] &#x60;&#x60;&#x60; You can sort
     * the results using the **sort JSON body parameter**, for example:
     * &#x60;&#x60;&#x60;JSON \&quot;sort\&quot;:
     * [{\&quot;type\&quot;:\&quot;FIELD\&quot;,
     * \&quot;field\&quot;:\&quot;cm:description\&quot;,
     * \&quot;ascending\&quot;:\&quot;true\&quot;}] &#x60;&#x60;&#x60; **Note:**
     * the **sort** parameter is not supported for CMIS queries. You can specify
     * templates using the **templates JSON body parameter**, for example:
     * &#x60;&#x60;&#x60;JSON \&quot;templates\&quot;: [{\&quot;name\&quot;:
     * \&quot;_PERSON\&quot;,\&quot;template\&quot;: \&quot;|%firstName OR
     * |%lastName OR |%userName\&quot;}, {\&quot;name\&quot;:
     * \&quot;mytemplate\&quot;,\&quot;template\&quot;:
     * \&quot;%cm:content\&quot;}] &#x60;&#x60;&#x60; For **spell checking** you
     * can use a query like this: &#x60;&#x60;&#x60;JSON { \&quot;query\&quot;:
     * { \&quot;query\&quot;: \&quot;cm:title:alfrezco\&quot;,
     * \&quot;language\&quot;: \&quot;afts\&quot; }, \&quot;spellcheck\&quot;:
     * {\&quot;query\&quot;: \&quot;alfrezco\&quot;} } &#x60;&#x60;&#x60; If you
     * are already specifying \&quot;userQuery\&quot; then the following may be
     * easier and produces the same result : &#x60;&#x60;&#x60;JSON {
     * \&quot;query\&quot;: { \&quot;query\&quot;:
     * \&quot;cm:title:alfrezco\&quot;, \&quot;userQuery\&quot;:
     * \&quot;alfrezco\&quot;, \&quot;language\&quot;: \&quot;afts\&quot; },
     * \&quot;spellcheck\&quot;: {} } &#x60;&#x60;&#x60; The spellcheck response
     * includes a spellCheck context like this: &#x60;&#x60;&#x60;JSON
     * \&quot;context\&quot;: { \&quot;spellCheck\&quot;: { \&quot;type\&quot;:
     * \&quot;searchInsteadFor\&quot;, \&quot;suggestions\&quot;:
     * [\&quot;alfresco\&quot;] } }, &#x60;&#x60;&#x60; To specify defaults, you
     * use a **defaults JSON body parameter**, for example:
     * &#x60;&#x60;&#x60;JSON \&quot;defaults\&quot;: {
     * \&quot;textAttributes\&quot;: [ \&quot;cm:content\&quot;,
     * \&quot;cm:name\&quot; ], \&quot;defaultFTSOperator\&quot;:
     * \&quot;AND\&quot;, \&quot;defaultFTSFieldOperator\&quot;:
     * \&quot;OR\&quot;, \&quot;namespace\&quot;: \&quot;cm\&quot;,
     * \&quot;defaultFieldName\&quot;: \&quot;PATH\&quot; } &#x60;&#x60;&#x60;
     * You can specify several filter queries using the **filterQueries JSON
     * body parameter**, for example: &#x60;&#x60;&#x60;JSON
     * \&quot;filterQueries\&quot;: [{\&quot;query\&quot;:
     * \&quot;TYPE:&#39;cm:folder&#39;\&quot;},{\&quot;query\&quot;:
     * \&quot;cm:creator:mjackson\&quot;}] &#x60;&#x60;&#x60; You can specify
     * several facet queries using the **facetQueries JSON body parameter**, for
     * example: &#x60;&#x60;&#x60;JSON \&quot;facetQueries\&quot;:
     * [{\&quot;query\&quot;: \&quot;created:2016\&quot;,\&quot;label\&quot;:
     * \&quot;CreatedThisYear\&quot;}] &#x60;&#x60;&#x60; The response will
     * contain a matching \&quot;context\&quot; section, the \&quot;label\&quot;
     * will match the facet query. &#x60;&#x60;&#x60;JSON \&quot;context\&quot;:
     * { \&quot;facetQueries\&quot;: [ {\&quot;label\&quot;:
     * \&quot;CreatedThisYear\&quot;,\&quot;count\&quot;: 3} ] },
     * &#x60;&#x60;&#x60; A complete query for facetting via the content.size
     * field looks this: &#x60;&#x60;&#x60;JSON { \&quot;query\&quot;: {
     * \&quot;query\&quot;: \&quot;presentation\&quot;, \&quot;language\&quot;:
     * \&quot;afts\&quot; }, \&quot;facetQueries\&quot;: [ {\&quot;query\&quot;:
     * \&quot;content.size:[0 TO 10240]\&quot;, \&quot;label\&quot;: \&quot;xtra
     * small\&quot;}, {\&quot;query\&quot;: \&quot;content.size:[10240 TO
     * 102400]\&quot;, \&quot;label\&quot;: \&quot;small\&quot;},
     * {\&quot;query\&quot;: \&quot;content.size:[102400 TO 1048576]\&quot;,
     * \&quot;label\&quot;: \&quot;medium\&quot;}, {\&quot;query\&quot;:
     * \&quot;content.size:[1048576 TO 16777216]\&quot;, \&quot;label\&quot;:
     * \&quot;large\&quot;}, {\&quot;query\&quot;: \&quot;content.size:[16777216
     * TO 134217728]\&quot;, \&quot;label\&quot;: \&quot;xtra large\&quot;},
     * {\&quot;query\&quot;: \&quot;content.size:[134217728 TO MAX]\&quot;,
     * \&quot;label\&quot;: \&quot;XX large\&quot;} ],
     * \&quot;facetFields\&quot;: {\&quot;facets\&quot;: [{\&quot;field\&quot;:
     * \&quot;&#39;content.size&#39;\&quot;}]} } &#x60;&#x60;&#x60; The response
     * will contain a matching \&quot;context\&quot; section, the
     * \&quot;label\&quot; will match the facet query. &#x60;&#x60;&#x60;JSON
     * \&quot;context\&quot;: { \&quot;facetQueries\&quot;: [ {
     * \&quot;label\&quot;: \&quot;small\&quot;,\&quot;count\&quot;: 2 }, {
     * \&quot;label\&quot;: \&quot;large\&quot;,\&quot;count\&quot;: 0 }, {
     * \&quot;label\&quot;: \&quot;xtra small\&quot;,\&quot;count\&quot;: 5 }, {
     * \&quot;label\&quot;: \&quot;xtra large\&quot;,\&quot;count\&quot;: 56}, {
     * \&quot;label\&quot;: \&quot;medium\&quot;,\&quot;count\&quot;: 4 }, {
     * \&quot;label\&quot;: \&quot;XX large\&quot;, \&quot;count\&quot;: 1 } ]
     * }, &#x60;&#x60;&#x60; You can specify several facet fields using the
     * **facetFields JSON body parameter**, for example: &#x60;&#x60;&#x60;JSON
     * \&quot;facetFields\&quot;: {\&quot;facets\&quot;: [{\&quot;field\&quot;:
     * \&quot;creator\&quot;, \&quot;mincount\&quot;: 1}, {\&quot;field\&quot;:
     * \&quot;modifier\&quot;, \&quot;mincount\&quot;: 1}]} &#x60;&#x60;&#x60;
     * The response will contain a matching \&quot;context\&quot; section, the
     * \&quot;label\&quot; will match the facet field. &#x60;&#x60;&#x60;JSON
     * \&quot;context\&quot;: { \&quot;facetsFields\&quot;: [ {
     * \&quot;label\&quot;: \&quot;creator\&quot;, \&quot;buckets\&quot;: [ {
     * \&quot;label\&quot;: \&quot;System\&quot;, \&quot;count\&quot;: 75 }, {
     * \&quot;label\&quot;: \&quot;mjackson\&quot;, \&quot;count\&quot;: 5 } ]},
     * { \&quot;label\&quot;: \&quot;modifier\&quot;, \&quot;buckets\&quot;: [ {
     * \&quot;label\&quot;: \&quot;System\&quot;, \&quot;count\&quot;: 72 }, {
     * \&quot;label\&quot;: \&quot;mjackson\&quot;, \&quot;count\&quot;: 5 }, {
     * \&quot;label\&quot;: \&quot;admin\&quot;, \&quot;count\&quot;: 3 } ]} ]
     * }, &#x60;&#x60;&#x60;
     */
    @POST(SearchConstant.SEARCH_PUBLIC_API_V1 + "/search")
    Call<ResultSetRepresentation<ResultNodeRepresentation>> searchCall(@Body QueryBody queryBody);

}
