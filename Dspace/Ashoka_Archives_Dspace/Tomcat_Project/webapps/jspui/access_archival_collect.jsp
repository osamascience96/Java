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

    ol > h5{
        font-weight:bold;
    }
</style>

<dspace:layout locbar="nolink" title="Admission" >
    <h1 class="text-center">Access to Archival Collections</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <ol type="a">
            <h5><li>The maximum period of membership is one year. After the expiry of this period one will need to renew the membership.</li></h5>
            <h5><li>Papers/files will be issued to the new scholar only after the approval of the admission form by the competant authority.</li></h5>
            <h5><li>All private/institutional papers in the archives are open for consultation except where the donor/donors have placed restrictions or closed the papers for a specific period of time.</li></h5>
            <h5><li>Catalogues of collections can be consulted on the Archives website as well as in the Reading Room.</li></h5>
            <h5><li>Scholars should give their requisition for papers/files on the prescribed form in duplicate in the Reading Room.</li></h5>
        </ol>
    </div>
</dspace:layout>
