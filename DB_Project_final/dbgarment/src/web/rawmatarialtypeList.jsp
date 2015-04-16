<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.RawMatarialType"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initRawMatarialTypeSearch.do"><strong>RawMatarialType <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initRawMatarialType.do?idRawMaterialType=null&"><strong><bean:message key="entity.new"/> RawMatarialType</strong></a>
</div>
<html:form action='initRawMatarialTypeSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='rawMatarialTypeSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='rawMatarialTypeSearchForm' property='pageListSizes'/>
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
<display:table requestURI="initRawMatarialTypeSearch.do" id="parent" name="rawMatarialTypeSearchForm.rawMatarialTypeList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idRawMaterialType" group="1" sortable="true" headerClass="sortable" href="initRawMatarialType.do" paramId="idRawMaterialType" paramProperty="primaryKey" />
  <display:column property="rawMaterialTypeName" group="2" sortable="true" headerClass="sortable" href="initRawMatarialType.do" paramId="idRawMaterialType" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
