<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

<h1><liferay-ui:message key="Assignments" /></h1>

<%-- Clay management toolbar. --%>
<clay:management-toolbar
disabled="${assignmentCount eq 0}"
displayContext="${assignmentsManagementToolbarDisplayContext}"
itemsTotal="${assignmentCount}"
searchContainerId="assignmentEntries"
selectable="false"
/>

<%-- Search container. --%>
<liferay-ui:search-container
emptyResultsMessage="no-assignments"
id="assignmentEntries"
iteratorURL="${portletURL}"
total="${assignmentCount}">

<liferay-ui:search-container-results results="${assignments}" />

<liferay-ui:search-container-row
className="com.liferay.training.gradebook.model.Assignment"
modelVar="entry">

<%@ include file="/assignment/entry_search_columns.jspf" %>

</liferay-ui:search-container-row>

<%-- Iterator / Paging --%>
<liferay-ui:search-iterator
displayStyle="${assignmentsManagementToolbarDisplayContext.getDisplayStyle()}"
markupView="lexicon"
/>
</liferay-ui:search-container>
</div>