<%@ page isErrorPage="true" %>
<%@ include file="../inc/init.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Error Page</title>
	<meta http-equiv="Expires" content="-1" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/css/screen.css" type="text/css" media="screen, print" />

<script language="Javascript1.2">
   function openStackTrace() {
      window_properties = getMidScreenPopupProperties();
      window.open("", "stacktrace", window_properties);
   }

   function getMidScreenPopupProperties() {
      w = 750;
      h = 500;
      x = 300; // (window.width - w) / 2;
      y = 300; //(window.heigth - h)/ 2;
      //alert(window.heigth);
      //alert(window.width);
      props = "height=" + h + ", hotkeys=no, location=no, menubar=no, personalBar=no, screenX =" +  x + ", screenY = " + y + ", scrollbars=yes, status=yes, toolbar=no, width=" + w;
      //alert(props);
      return props;
   }
</script>

</head>

<body onload="window.focus()">

<div id="header">
	<h1>Error page</h1>
</div>
<div id="body">
<span class="pagebanner">An exception occured</span>
<table>
<tbody>
<tr class="odd">
<td>Message</td>
<td><bean:write name="<%=ExceptionConstants.EXCEPTION_MESSAGE%>"/></td>
</tr>
         <%--
            To allow the printStacktrace for accessing the implicite exception object,
            we have to put this object on the session.
         --%>
         <%
         if (exception != null) {
            request.getSession().setAttribute(ExceptionConstants.EXCEPTION,exception);
         }
         %>
	<tr class="even">
	   <td>Stack Trace (technical)</td>
	   <td><html:link page="/exception/initStackTrace.do" onclick="openStackTrace()" target="stacktrace">Show</html:link></td>
	</tr>
<logic:present name="<%=ExceptionConstants.EXCEPTION_ACTION_ERRORS%>">
	<tr class="odd">
	   <td>Error Messages</td>
	   <td><html:errors name="<%=ExceptionConstants.EXCEPTION_ACTION_ERRORS%>"/></td>
	</tr>
	</logic:present>
</table>
<%@ include file="../inc/footer.jsp" %>
