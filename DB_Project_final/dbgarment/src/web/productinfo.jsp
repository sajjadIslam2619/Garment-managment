<%@ include file="inc/header.jsp" %>
<html:form action='/saveProductInfo' method='post' onsubmit="return validateProductInfoForm(this);">
<html:hidden property="mode"/>
<html:errors/>
<p>&nbsp;</p>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initProductInfoSearch.do"><strong>ProductInfo <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initProductInfo.do?idProduct=null&"><strong><bean:message key="entity.new"/> ProductInfo</strong></a>
</div>
    <table bgcolor="#f0e0a0">
      <tbody>
      <tr>
        <td colspan="4">
                      <table cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
                      <html:hidden property="idProduct"/>
                      <logic:equal name="productInfoForm" property="mode" value="change">
                        <tr bgcolor="#eeeeee">
                          <error:td errorClass="inputerror" property="idProduct" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="productInfoForm.idProduct.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idProduct"  disabled="true"/>
                          </td>
                        </tr>
                      </logic:equal>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="productName" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="productInfoForm.productName.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="productName" styleId="productNameId"  maxlength="55" size="50" />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="idProductType" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="productInfoForm.idProductType.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idProductType" styleId="idProductTypeId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="productPrice" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="productInfoForm.productPrice.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="productPrice" styleId="productPriceId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="productImage" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="productInfoForm.productImage.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="productImage" styleId="productImageId"  maxlength="200" size="50" />
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
          <logic:equal name="productInfoForm" property="mode" value="new">
             <html:submit property="<%=Constants.SUBMIT_NO_VALIDATION%>" value="Delete" onclick="bCancel=true" disabled="true"/>
          </logic:equal>
          <logic:equal name="productInfoForm" property="mode" value="change">
             <html:submit property="<%=Constants.SUBMIT_NO_VALIDATION%>" value="Delete" onclick="bCancel=true"/>
          </logic:equal>
        </td>
        <td>&nbsp;</td>
      </tr>
      </tbody>
    </table>
</html:form>
<html:javascript formName="productInfoForm" />
<%@ include file="inc/footer.jsp" %>
