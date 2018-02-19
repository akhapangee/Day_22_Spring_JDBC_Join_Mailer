<%@include file="../shared/header.jsp" %>
<h1>Enroll Now</h1>
<form id="enquiry" method="POST" action="${SITE_URL}/enroll/">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control" tabindex="1" required="required"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" class="form-control" tabindex="3" required="required"/>
            </div>
            <div class="form-group">
                <label>Interested Course</label>
                <select name="course.id" class="form-control" required="required" tabindex="5">
                    <option value="">Select Course</option>
                    <c:forEach var="course" items="${courses}">
                        <option value="${course.id}" 
                                <c:if test="${param.ref == course.id}">
                                    selected
                                </c:if>>
                            <c:out value="${course.name}" />
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control" tabindex="2" required="required"/>
            </div>
            <div class="form-group">
                <label>Contact no</label>
                <input type="text" name="contactNo" class="form-control" tabindex="4" required="required"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Message</label>
        <textarea name="message" class="form-control" required="required" rows="5" tabindex="6"></textarea>
    </div>
    <input type="hidden" name="status.id" value="4" />
    <button type="submit" class="btn btn-success" tabindex="7">Enroll</button>
</form>
<%@include file="../shared/footer.jsp" %>