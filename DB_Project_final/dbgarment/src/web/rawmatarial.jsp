<%@ include file="inc/header.jsp" %>
<html:form action='/saveRawMatarial' method='post' onsubmit="return validateRawMatarialForm(this);">
<html:hidden property="mode"/>
<html:errors/>
<p>&nbsp;</p>
<div class="exportlinks">&nbsp;<a href="index.jsp"><strong><bean:message key="entity.index"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initRawMatarialSearch.do"><strong>RawMatarial <bean:message key="entity.list"/></strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initRawMatarial.do?idRawMatarial=null&"><strong><bean:message key="entity.new"/> RawMatarial</strong></a>
</div>
    <table bgcolor="#f0e0a0">
      <tbody>
      <tr>
        <td colspan="4">
                      <table cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
                      <html:hidden property="idRawMatarial"/>
                      <logic:equal name="rawMatarialForm" property="mode" value="change">
                        <tr bgcolor="#eeeeee">
                          <error:td errorClass="inputerror" property="idRawMatarial" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="rawMatarialForm.idRawMatarial.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idRawMatarial"  disabled="true"/>
                          </td>
                        </tr>
                      </logic:equal>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="idRawMaterialType" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="rawMatarialForm.idRawMaterialType.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="idRawMaterialType" styleId="idRawMaterialTypeId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="rawMaterialAmount" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="rawMatarialForm.rawMaterialAmount.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="rawMaterialAmount" styleId="rawMaterialAmountId"   />
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <error:td errorClass="inputerror" property="perUnitPrice" width="254"><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
                           </font><font size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="rawMatarialForm.perUnitPrice.displayName"/></font></b></font> <font face="Verdana, Arial, Helvetica, sans-serif">:
                           </font></b></font></error:td>
                          <td width="23" align="center" nowrap height="15"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><html:text property="perUnitPrice" styleId="perUnitPriceId"   />
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
          <logic:equal name="rawMatarialForm" property="mode" value="new">
             <html:submit property="<%=Constants.SUBMIT_NO_VALIDATION%>" value="Delete" onclick="bCancel=true" disabled="true"/>
          </logic:equal>
          <logic:equal name="rawMatarialForm" property="mode" value="change">
             <html:submit property="<%=Constants.SUBMIT_NO_VALIDATION%>" value="Delete" onclick="bCancel=true"/>
          </logic:equal>
        </td>
        <td>&nbsp;</td>
      </tr>
      </tbody>
    </table>
</html:form>
<html:javascript formName="rawMatarialForm" />
<%@ include file="inc/footer.jsp" %>
