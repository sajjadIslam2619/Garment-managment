<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="init.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>The JAG Test Console</title>
	<meta http-equiv="Expires" content="-1" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/screen.css" type="text/css" media="screen, print" />
    <link rel="stylesheet" type="text/css" media="all" href="<%= request.getContextPath()%>/inc/jscalendar-1.0/calendar-system.css" title="calendar"/>

    <!-- import the calendar script -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/inc/jscalendar-1.0/calendar.js"></script>

    <!-- import the language module -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/inc/jscalendar-1.0/lang/calendar-en.js"></script>

    <!-- other languages might be available in the lang directory; please check
         your distribution archive. -->
    <!-- the following script defines the Calendar.setup helper function, which makes
        adding a calendar a matter of 1 or 2 lines of code. -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/inc/jscalendar-1.0/calendar-setup.js"></script>

    <script type="text/javascript">
        function selectAll(checkbox) {
            // skip the first (allesMarkeren) checkbox
            for (i = 0; i < document.forms[0].length; i++) {
                var element = document.forms[0].elements[i];
                if (element.type == "checkbox" && element.name != "select_all") {
                    element.checked = checkbox.checked;
                }
            }
        }
    </script>

</head>
<body>

<div id="header">
	<h1>The JAG Test Console</h1>
   <b>
   <script language="JavaScript">
   var version="$Name: JAG_v6_1 $"
   version=version.slice(7,version.length-1);
   if (version.length > 0) {
   document.write("Version: ");
   document.write(version);
   }
   </script>
   </b>
   <br/>
   <br/>
   
   <ul>
		<li><a href="http://jag.sourceforge.net">JAG Documentation</a></li>
		<li><a href="http://www.finalist.com">Finalist IT Group</a></li>
    </ul>
	
</div>
<div id="body">
