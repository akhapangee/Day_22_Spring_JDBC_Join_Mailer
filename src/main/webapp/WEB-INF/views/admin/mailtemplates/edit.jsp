<%@include file="../shared/header.jsp" %>
<h1>Edit Email Template</h1>
<form id="template" method="POST" action="${SITE_URL}/admin/templates/save">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" class="form-control" tabindex="1" required="required" value="${template.name}"/>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Slug</label>
                <input type="text" name="slug" class="form-control" tabindex="2" required="required" value="${template.slug}"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label>Content</label>
        <textarea name="content" class="form-control" required="required" rows="5" tabindex="3">${template.content}</textarea>
    </div>
    <div class="form-inline">
        <label>Status</label>
        <label>
            <input type="checkbox" name="status"  required="required" tabindex="4"
                   <c:if test="${template.status != null}">checked="checked"</c:if>  />
            Is Active
        </label>
    </div>
    <input type="hidden" name="id" value="${template.id}" />
    <button type="submit" class="btn btn-success" tabindex="5">Save</button>
</form>
<%@include file="../shared/footer.jsp" %>