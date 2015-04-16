<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.OrderType"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderTypeSearch.do"><strong>OrderType <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderType.do?idOrderType=null&"><strong><bean:message key="entity.new"/> OrderType</strong></a>
</div>
<html:form action='initOrderTypeSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='orderTypeSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='orderTypeSearchForm' property='pageListSizes'/>
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
<display:table requestURI="initOrderTypeSearch.do" id="parent" name="orderTypeSearchForm.orderTypeList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idOrderType" group="1" sortable="true" headerClass="sortable" href="initOrderType.do" paramId="idOrderType" paramProperty="primaryKey" />
  <display:column property="orderName" group="2" sortable="true" headerClass="sortable" href="initOrderType.do" paramId="idOrderType" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
