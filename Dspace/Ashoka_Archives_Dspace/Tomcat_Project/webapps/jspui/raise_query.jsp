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

    .query_input, textarea{
        font-size:20px;
        border:none;
        background-color:#e4e4e4;
        padding:10px;
    }

    .row{
        margin: 5px 0 5px 0;
    }

    #contact_info{
        width:60%;
        margin:auto;
        padding:10px;
        background-color:#e4e4e4;
    }

    #contact_info > a{
        font-size: 18px;
    }
</style>

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    
    <h1 class="text-center">Raise Query</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px; text-align:center;">
        <form action="#" method="post">
            <div class="row">
                <input class="query_input" type="text" placeholder="Your Name*" required/>
            </div>
            <div class="row">
                <input class="query_input" type="email" placeholder="Your Email*" required/>
            </div>
            <div class="row">
                <textarea class="query_input" rows="10" cols="35" placeholder="Your message*"></textarea>
            </div>
            <div class="row">
                <input class="query_input" type="submit" value="Submit Query" />
            </div>
        </form>

        <div class="row">
            <h2>For other queries contact</h2>
            <div id="contact_info">
                <a href="mailto:ashoka.archives@ashoka.edu.in">ashoka.archives@ashoka.edu.in</a>
                <h4>D.S. Rawat: <a href="mailto:ds.rawat@ashoka.edu.in">ds.rawat@ashoka.edu.in</a></h4>
                <h4>Deepshikha Salooja: <a href="mailto:deepshikha.salooja@ashoka.edu.in">deepshikha.salooja@ashoka.edu.in</a></h4>
            </div>
        </div>
    </div>
</dspace:layout>
