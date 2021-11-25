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

<dspace:layout locbar="nolink" title="Contact Us" >
    <h1 class="text-center">Contact Information</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        
        <h4>Website <a href="https://ashoka.edu.in/ashoka-archives" target="_blank">www.ashoka.edu.in</a></h4>
        
        <h4>Email: <a href="mailto:ashoka.archives@ashoka.edu.in">ashoka.archives@ashoka.edu.in</a></h4>
        
        <h4>Phone Number: <a href="tel:+4733378901">+9100000000000</a></h4>
        
        <h4>Physical Location/Postal Address:</h4>
        <span>
            Ashoka Archives of Contemporary India Ashoka University,
            <br/>
            #2, Rajiv Gandhi Education City, P.O. Rai, Sonepat, Haryana 131 029
        </span>
        
        <h4>Donation or Transfer:</h4>
        <span>
            For donation or transfer of archival materials to Ashoka Archives contant.
        </span>

        <h4>Deepa Bhatnagar</h4>
        <span>Director, Ashoka Archives of Contemporary India</span>
        <br/>
        <span>Email: <a href="mailto:deepa.bhatnagar@ashoka.edu.in">deepa.bhatnagar@ashoka.edu.in</a></span>

        <h4>(For Information about the types of materials the Archives collects read Ashoka Archives <a href="aboutus_arch_access_policy.jsp" target="_blank">Collection Policy</a>).</h4>

    </div>
</dspace:layout>
