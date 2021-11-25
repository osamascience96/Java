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
</style>

<dspace:layout locbar="nolink" title="About Us" >
    <h1 class="text-center">Mission</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <h3>Ashoka Archives promotes the production and a wide dissemination of knowledge through</h3>
        <ul>
            <h4><li>The collection and creation of primary soruce material in the form of private papers and institutional papers for study and research on modern and contemporary history of India</li></h4>
            <h4><li>With major thrust on polity, economy and society</li></h4>
            <h4><li>Preserving collections and ensuring their co-ordinated management</li></h4>
            <h4><li>Making such source material available to students, researchers and teachers and to the wider scholarly community</li></h4>
            <h4><li>Delivering quality and effective service for their application in the form most relevant to users</li></h4>
        </ul>
    </div>
</dspace:layout>
