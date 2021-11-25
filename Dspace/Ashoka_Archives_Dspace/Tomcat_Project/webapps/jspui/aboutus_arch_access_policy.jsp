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
    <h1 class="text-center">Ashoka Archives of Contemporary India</h1>
    <h2 class="text-center">Collection and Access Policy</h2>
    <div class="container" style="border:4px solid #e4e4e4; padding: 20px 0 20px 0;">
        <ol>
            <h3><li>Introduction</li></h3>
            <ol>
                <h4><li>Mission Statement</li></h4>
                <h4><li>Vision Statement</li></h4>
            </ol>
            <h3><li>Directive Principles for the Collection Policy</li></h3>
            <ol>
                <h4><li>Individual and Institutional Collections</li></h4>
                <h4><li>Donation of Papers: Doners</li></h4>
                <h4><li>Custodian: Ashoka Archives</li></h4>
                <h4><li>Terms and Conditions</li></h4>
                <h4><li>Closed Papers</li></h4>
            </ol>
            <h3><li>Collection Management</li></h3>
            <ol>
                <h4><li>Option 1</li></h4>
                <h4><li>Option 2</li></h4>
                <h4><li>Option 3</li></h4>
            </ol>
        </ol>
    </div>
</dspace:layout>
