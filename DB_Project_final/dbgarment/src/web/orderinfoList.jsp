<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.OrderInfo"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderInfoSearch.do"><strong>OrderInfo <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderInfo.do?idOrderInfo=null&"><strong><bean:message key="entity.new"/> OrderInfo</strong></a>
</div>
<html:form action='initOrderInfoSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='orderInfoSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='orderInfoSearchForm' property='pageListSizes'/>
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
<display:table requestURI="initOrderInfoSearch.do" id="parent" name="orderInfoSearchForm.orderInfoList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idOrderInfo" group="1" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="idUser" group="2" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="idOrderType" group="3" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="productAmount" group="4" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="orderEstimatedDate" group="5" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="idProduct" group="6" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="orderDetail" group="7" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />
  <display:column property="idOrderStatus" group="8" sortable="true" headerClass="sortable" href="initOrderInfo.do" paramId="idOrderInfo" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
