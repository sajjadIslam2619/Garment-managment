<%@ include file="inc/header.jsp" %>
<TABLE>
  <THEAD>
  <TR>
    <TH><bean:message key="entity.components"/></TH>
    <TH><bean:message key="entity.list"/></TH>
    <TH><bean:message key="entity.new"/></TH>
  </TR>
  </THEAD>
  <TBODY>
  <TR class=odd>
    <TD>OrderInfoService -  OrderInfo</TD>
    <TD>
        <a href='initOrderInfoSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initOrderInfo.do?idOrderInfo=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=even>
    <TD>OrderStatusService -  OrderStatus</TD>
    <TD>
        <a href='initOrderStatusSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initOrderStatus.do?idOrderStatus=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=odd>
    <TD>OrderStatusTypeService -  OrderStatusType</TD>
    <TD>
        <a href='initOrderStatusTypeSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initOrderStatusType.do?idOrderStatusType=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=even>
    <TD>OrderTypeService -  OrderType</TD>
    <TD>
        <a href='initOrderTypeSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initOrderType.do?idOrderType=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=odd>
    <TD>ProductInfoService -  ProductInfo</TD>
    <TD>
        <a href='initProductInfoSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initProductInfo.do?idProduct=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=even>
    <TD>ProductTypeService -  ProductType</TD>
    <TD>
        <a href='initProductTypeSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initProductType.do?idProductType=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=odd>
    <TD>RawMatarialService -  RawMatarial</TD>
    <TD>
        <a href='initRawMatarialSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initRawMatarial.do?idRawMatarial=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=even>
    <TD>RawMatarialTypeService -  RawMatarialType</TD>
    <TD>
        <a href='initRawMatarialTypeSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initRawMatarialType.do?idRawMaterialType=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=odd>
    <TD>UserInfoService -  UserInfo</TD>
    <TD>
        <a href='initUserInfoSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initUserInfo.do?idUser=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  <TR class=even>
    <TD>UserTypeService -  UserType</TD>
    <TD>
        <a href='initUserTypeSearch.do'><bean:message key="entity.list"/></a>
    </TD>
    <TD>
        <a href='initUserType.do?idUserType=null&'><bean:message key="entity.new"/></a>
    </TD>
  </TR>
  </TBODY>
</TABLE>

<%@ include file="inc/footer.jsp" %>
