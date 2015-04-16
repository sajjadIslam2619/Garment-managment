<%@ include file="inc/header.jsp" %>
<html:form action='/saveOrderInfo' method='post' onsubmit="return validateOrderInfoForm(this);">
<html:hidden property="mode"/>
<html:errors/>
<p>&nbsp;</p>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderInfoSearch.do"><strong>OrderInfo <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initOrderInfo.do?idOrderInfo=null&"><strong><bean:message key="entity.new"/> OrderInfo</strong></a>
</div>
    <table bgcolor="#f0e0a0">
      <tbody>
      <tr>
        <td colspan="4">
                      <table cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
                      <html:hidden property="idOrderInfo"/>
                      <logic:equal name="orderInfoForm" property="mode" value="change">
                        <tr bgcolor="#eeeeee">
                          <error:td errorClass="inputerror" property="idOrderInfo" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.idOrderInfo.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idOrderInfo"  disabled="true"/>
                          </td>
                        </tr>
                      </logic:equal>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="idUser" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.idUser.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idUser" styleId="idUserId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="idOrderType" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.idOrderType.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idOrderType" styleId="idOrderTypeId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="productAmount" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.productAmount.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="productAmount" styleId="productAmountId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="orderEstimatedDate" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.orderEstimatedDate.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="orderEstimatedDate" styleId="orderEstimatedDateId"   />
                          <button type="reset" id="orderEstimatedDateTrigger">...</button>
                              <script type="text/javascript">
                                  Calendar.setup({
                                      inputField     :    "orderEstimatedDateId",      // id of the input field
                                      ifFormat       :    "%d/%m/%Y",       // format of the input field
                                      showsTime      :    false,            // will display a time selector
                                      button         :    "orderEstimatedDateTrigger",   // trigger for the calendar (button ID)
                                      singleClick    :    false,           // double-click mode
                                      step           :    1                // show all years in drop-down boxes (instead of every other year as default)
                                  });
                              </script>
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="idProduct" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.idProduct.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idProduct" styleId="idProductId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="orderDetail" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.orderDetail.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="orderDetail" styleId="orderDetailId"  maxlength="500" size="50" />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="idOrderStatus" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="orderInfoForm.idOrderStatus.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idOrderStatus" styleId="idOrderStatusId"   />
                          </td>
                        </tr>
          </table>
        </td>
      </tr>
      <tr bgcolor="#f0e0a0">
        <td>
          <div align="center"> &nbsp; </div>
        </td>
        <td>&nbsp;</td>
        <td align="right">
          <html:submit property="submit" value="Save"/>
          <logic:equal name="orderInfoForm" property="mode" value="new">
             <html:submit property="<%=Constants.SUBMIT_NO_VALIDATION%>" value="Delete" onclick="bCancel=true" disabled="true"/>
          </logic:equal>
          <logic:equal name="orderInfoForm" property="mode" value="change">
             <html:submit property="<%=Constants.SUBMIT_NO_VALIDATION%>" value="Delete" onclick="bCancel=true"/>
          </logic:equal>
        </td>
        <td>&nbsp;</td>
      </tr>
      </tbody>
    </table>
</html:form>
<html:javascript formName="orderInfoForm" />
<%@ include file="inc/footer.jsp" %>
