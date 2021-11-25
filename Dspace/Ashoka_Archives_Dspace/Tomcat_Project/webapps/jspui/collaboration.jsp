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

    h4{
        font-weight:bold;
    }

    span{
        font-weight:bold;
    }
</style>

<dspace:layout locbar="nolink" title="Outreach" >
    <h1 class="text-center">Collaboration</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <h4>Curation and Collaboration:</h4>
        <span>
            The Shah Commission of inquiry materials available here are curated by the Political Conflict,
            Gender and People's Right Initiative, (PCRes), Center for Race and Gender, University of California, 
            Berkeley and Stanford Libraries, in collaboration with the Ashoka Univerisity Archives of Contemporary
            India Collection, Sonepat, Haryana and Dr. Chistophe Jaffrelot, Dr. Sunil Khilnani, and Pratinav Anil.
        </span>
    </div>
</dspace:layout>
