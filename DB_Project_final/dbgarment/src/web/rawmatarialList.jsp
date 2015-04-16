<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.RawMatarial"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initRawMatarialSearch.do"><strong>RawMatarial <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initRawMatarial.do?idRawMatarial=null&"><strong><bean:message key="entity.new"/> RawMatarial</strong></a>
</div>
<html:form action='initRawMatarialSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='rawMatarialSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='rawMatarialSearchForm' property='pageListSizes'/>
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
<display:table requestURI="initRawMatarialSearch.do" id="parent" name="rawMatarialSearchForm.rawMatarialList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idRawMatarial" group="1" sortable="true" headerClass="sortable" href="initRawMatarial.do" paramId="idRawMatarial" paramProperty="primaryKey" />
  <display:column property="idRawMaterialType" group="2" sortable="true" headerClass="sortable" href="initRawMatarial.do" paramId="idRawMatarial" paramProperty="primaryKey" />
  <display:column property="rawMaterialAmount" group="3" sortable="true" headerClass="sortable" href="initRawMatarial.do" paramId="idRawMatarial" paramProperty="primaryKey" />
  <display:column property="perUnitPrice" group="4" sortable="true" headerClass="sortable" href="initRawMatarial.do" paramId="idRawMatarial" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
