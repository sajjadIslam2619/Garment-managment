<%@ include file="inc/header.jsp" %>
<%@ page import="dbGarmentHibernate.entity.ProductInfo"%>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initProductInfoSearch.do"><strong>ProductInfo <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initProductInfo.do?idProduct=null&"><strong><bean:message key="entity.new"/> ProductInfo</strong></a>
</div>
<html:form action='initProductInfoSearch.do' method='post' >
    Query: <html:text property="query" size="25"/>
    <bean:define id='queryFields' name='productInfoSearchForm' property='queryFields'/>
    Field: <html:select property="queryField">
        <html:options collection="queryFields" labelProperty="name" property="id"/>
     </html:select>
   <bean:define id='pageListSizes' name='productInfoSearchForm' property='pageListSizes'/>
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
<display:table requestURI="initProductInfoSearch.do" id="parent" name="productInfoSearchForm.productInfoList" export="true" sort="list" pagesize="<%= size %>"
 >
  <display:column maxLength="5" media="html" property="checkbox" title="&nbsp;&nbsp;X"/>
  <display:column property="idProduct" group="1" sortable="true" headerClass="sortable" href="initProductInfo.do" paramId="idProduct" paramProperty="primaryKey" />
  <display:column property="productName" group="2" sortable="true" headerClass="sortable" href="initProductInfo.do" paramId="idProduct" paramProperty="primaryKey" />
  <display:column property="idProductType" group="3" sortable="true" headerClass="sortable" href="initProductInfo.do" paramId="idProduct" paramProperty="primaryKey" />
  <display:column property="productPrice" group="4" sortable="true" headerClass="sortable" href="initProductInfo.do" paramId="idProduct" paramProperty="primaryKey" />
  <display:column property="productImage" group="5" sortable="true" headerClass="sortable" href="initProductInfo.do" paramId="idProduct" paramProperty="primaryKey" />

</display:table>
<html:submit onclick="return confirm('Are you sure?');" property="Delete">Delete</html:submit>&nbsp;&nbsp;Select all:&nbsp;<input onclick="javascript:selectAll(this)" type="checkbox" id="select_all" name="select_all" value="" />
</html:form>
<%@ include file="inc/footer.jsp" %>
