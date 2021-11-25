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

    #digital_archive_content{
        margin-top: 20px;
    }

    #digital_content{
        border: 15px solid #e7e7e7;
        border-radius: 8px;
        padding: 15px 20px 15px 20px;
    }

    #digital_content > img{
        margin-left: 200px;
    }

    .digital_arc_btn{
        font-size: 20px!important;
        margin: 15px 0 15px 0;
    }
</style>

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    <div class="container">
        <div id="digital_archive_content">
            <div class="row">
                <div class="col-md-3">
                    <button class="btn btn-secondary digital_arc_btn">Chandi Prasad Bhatt</button>
                    <button class="btn btn-secondary digital_arc_btn">Divyabhanusinh Chavda</button>
                    <button class="btn btn-secondary digital_arc_btn">Girish Karnad</button>
                    <button class="btn btn-secondary digital_arc_btn">Gopalkrishna Gandhi</button>
                    <button class="btn btn-secondary digital_arc_btn">L.M.Singhvi</button>
                    <button class="btn btn-secondary digital_arc_btn">M.K.Ranjitsinh</button>
                </div>
                <h2 class="text-center">Chandi Prasad Bhatt</h2>
                <div id="digital_content" class="col-md-9">
                    <img src="<%=request.getContextPath()%>/image/test/glimpse_archive.PNG" width="400px" height="100%" alt="archive"/>
                </div>
            </div>
        </div>
    </div>
</dspace:layout>
