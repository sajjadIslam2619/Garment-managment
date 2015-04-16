<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.UserInfo"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initUserInfoSearch.do"><strong>UserInfo <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initUserInfo.do?idUser=null&"><strong><bean:message key="entity.new"/> UserInfo</strong></a>
</div>
<html:form action='initUserInfoSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='userInfoSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='userInfoSearchForm' property='pageListSizes'/>
   Size: <html:select property="pageListSize">
       <html:options collection="pageListSizes" labelProperty="name" property="id" />
    </html:select>
 <%
    int size = dbGarmentHibernate.forms.ServiceBaseForm.DEFAULT_PAGE_LIST_SIZE;
    if (request.getParameter("pageListSize") != null) {
      size = new Integer(request.getParameter("pageListSize")).intValue();
    }
 %>
    <html:submit property="Search">Search</html:submit>
<display:table requestURI="initUserInfoSearch.do" id="parent" name="userInfoSearchForm.userInfoList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idUser" group="1" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />
  <display:column property="userName" group="2" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />
  <display:column property="fullName" group="3" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />
  <display:column property="userEmail" group="4" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />
  <display:column property="idUserType" group="5" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />
  <display:column property="password" group="6" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />
  <display:column property="companyName" group="7" sortable="true" headerClass="sortable" href="initUserInfo.do" paramId="idUser" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
