<%@include file="shared/header.jsp" %>
<h1>Available Course</h1>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <c:forEach var="course" items="${courses}">
        <%--<c:forEach var="course" items="${courses}">--%>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#course-body-${course.id}" aria-expanded="true" aria-controls="collapseOne">
                        ${course.name}
                    </a>
                </h4>
            </div>
            <div id="course-body-${course.id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body">
                    ${course.name}
                    <div class="pull-right">
                        <a href="${SITE_URL}/enroll?ref=${course.id}" class="btn btn-info">Apply Now</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="shared/footer.jsp" %>