<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.OrderStatusType"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderStatusTypeSearch.do"><strong>OrderStatusType <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderStatusType.do?idOrderStatusType=null&"><strong><bean:message key="entity.new"/> OrderStatusType</strong></a>
</div>
<html:form action='initOrderStatusTypeSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='orderStatusTypeSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='orderStatusTypeSearchForm' property='pageListSizes'/>
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
<display:table requestURI="initOrderStatusTypeSearch.do" id="parent" name="orderStatusTypeSearchForm.orderStatusTypeList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idOrderStatusType" group="1" sortable="true" headerClass="sortable" href="initOrderStatusType.do" paramId="idOrderStatusType" paramProperty="primaryKey" />
  <display:column property="orderStatusName" group="2" sortable="true" headerClass="sortable" href="initOrderStatusType.do" paramId="idOrderStatusType" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
