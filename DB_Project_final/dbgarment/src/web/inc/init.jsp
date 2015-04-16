<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/finalist.tld" prefix="finalist" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/error.tld" prefix="error" %>
<!-- Core JSTL Taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Core Runtime JSTL Taglib -->
<%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<!-- Control JSTL Taglib -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!-- i18n JSTL Taglib -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- SQL JSTL Taglib -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!-- Functions JSTL Taglib -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import=" java.util.*,
                 com.finalist.Constants,
                 com.finalist.util.genelv.struts.ExceptionConstants
                  "%>
<%@ page language='java' errorPage ="/exception/initException.do"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
