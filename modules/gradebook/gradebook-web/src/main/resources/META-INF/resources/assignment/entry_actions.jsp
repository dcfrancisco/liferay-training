<%@ include file="../init.jsp"%>

<c:set var="assignment" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>
	<portlet:renderURL var="viewAssignmentURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_ASSIGNMENT%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewAssignmentURL}" />

	<%-- Edit action. --%>
	<portlet:renderURL var="editAssignmentURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_ASSIGNMENT%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editAssignmentURL}" />
	
	<%-- Delete action. --%>
	<portlet:actionURL name="<%=MVCCommandNames.DELETE_ASSIGNMENT%>"
		var="deleteAssignmentURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="assignmentId" value="${assignment.assignmentId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteAssignmentURL}" />
</liferay-ui:icon-menu>