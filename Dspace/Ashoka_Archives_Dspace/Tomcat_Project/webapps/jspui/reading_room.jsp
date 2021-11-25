<%@page import="org.dspace.core.factory.CoreServiceFactory"%>
<%@page import="org.dspace.core.service.NewsService"%>
<%@page import="org.dspace.content.service.CommunityService"%>
<%@page import="org.dspace.content.factory.ContentServiceFactory"%>
<%@page import="org.dspace.content.service.ItemService"%>
<%@page import="org.dspace.core.Utils"%>
<%@page import="org.dspace.content.Bitstream"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.dspace.org/dspace-tags.tld" prefix="dspace" %>

<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.jsp.jstl.core.*" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocaleSupport" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.dspace.core.I18nUtil" %>
<%@ page import="org.dspace.app.webui.util.UIUtil" %>
<%@ page import="org.dspace.app.webui.components.RecentSubmissions" %>
<%@ page import="org.dspace.content.Community" %>
<%@ page import="org.dspace.browse.ItemCounter" %>
<%@ page import="org.dspace.content.Item" %>
<%@ page import="org.dspace.services.ConfigurationService" %>
<%@ page import="org.dspace.services.factory.DSpaceServicesFactory" %>

<style>
    .undernavigation{
        background: white;
    }

    h4, span{
        font-weight:bold;
    }

    ol > h5{
        font-weight:bold;
    }
</style>

<dspace:layout locbar="nolink" title="Admission" >
    <h1 class="text-center">Visit to Reading Room</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <h4>Reading Room</h4>
        <ul>
            <li><span style="font-size:18px;">Request for materials:</span> You must have a <span>membership</span> of Ashoka Archives to request for access to materials in the Reading Room and on the Ashoka Archives website. We may not be able to provide access to unprocessed/uncatalogued collections, (In this when some-one clicks on <span>membership</span> it should lead the scholar to Guidelines for Scholars in the Archives Policy document Part II)</li>
            <li><span style="font-size:18px;">Visit to Reading Room:</span> We recommend requesting materials in advance of your visit. Please submit your <span>request(s)</span> atleast one week prior to your arrival to enable us to make the materials available for your consultation. (In this, <span>request(s)</span> should lead them to the scholars'Requisition Forms in the Archives Policy document part II)</li>
        </ul>
    </div>
</dspace:layout>
