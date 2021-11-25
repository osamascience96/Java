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

<dspace:layout locbar="nolink" title="Admission" >
    <h1 class="text-center">Guidelines for Scholars</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <h3>Admission/Registration Rules</h3>
        <h5 style="font-weight:bold;">Admission to the Reading Room of the Ashoka Archives is granted to only bonafide research scholars:-</h5>
        <ol type="a">
            <h5><li>Faculty members, research scholars and students of Ashoka University.</li></h5>
            <h5><li>Faculty members and research scholars of recognized universities of India.</li></h5>
            <h5><li>Research scholars/assistants of recognized universities or institutions who produce introduction letter from their supervisor or Professor or Head of the Department of Universities of Principles of their Colleges or Heads of Institutions or any other evidence that may prove they are bonafide scholars acceptable to the Chair, Ashoka Archives of Contemporary India.</li></h5>
        </ol>
    </div>
</dspace:layout>
