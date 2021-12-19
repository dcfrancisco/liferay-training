<%@ include file="../init.jsp"%>
<div class="container-fluid-1280">
	<h1>${assignment.title}</h1>
	<h2>
		<liferay-ui:message key="assignment-information" />
	</h2>
	<div class="assignment-metadata">
		<dl>
			<dt>
				<liferay-ui:message key="created" />
			</dt>
			<dd>${createDate}</dd>
			<dt>
				<liferay-ui:message key="created-by" />
			</dt>
			<dd>${assignment.userName}</dd>
			<dt>
				<liferay-ui:message key="assignment-duedate" />
			</dt>
			<dd>${dueDate}</dd>
			<dt>
				<liferay-ui:message key="description" />
			</dt>
			<dd>${assignment.description}</dd>
		</dl>
	</div>
</div>