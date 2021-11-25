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

    #archives_digital_cover{
        padding: 30px;
        background-color: #8B1615;
        color: white;
    }
    
    #archives_digital_cover > h2{
        float: left;
        position: relative;
        left: 200px;
        top: 100px;
    }

    #archives_digital_cover > img{
        width: 50%;
        height: 300px;
        float: right;
    }

    #digital_archive_content{
        margin-top: 20px;
    }

    #digital_content{
        border: 6px solid #e7e7e7;
        padding: 120px 0 120px 0;
    }

    .digital_arc_btn{
        font-size: 20px!important;
        margin: 15px 0 15px 0;
    }
</style>

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    <div id="archives_digital_cover" class="row">
        <h2>Digital Archives</h2>
        <img src="<%=request.getContextPath()%>/image/test/manmohan_singh_with_soilders.PNG" class="img-rounded" alt="test_image" />
    </div>
    <div class="container">
        <div id="digital_archive_content">
            <div class="row">
                <div class="col-md-3">
                    <button class="btn btn-secondary digital_arc_btn">Manmohan Singh</button>
                    <button class="btn btn-secondary digital_arc_btn">Prabhakar Machawe</button>
                    <button class="btn btn-secondary digital_arc_btn">Dunu Roy</button>
                    <button class="btn btn-secondary digital_arc_btn">M.N.Deshpande</button>
                </div>
                <div id="digital_content" class="col-md-9">

                </div>
            </div>
        </div>
    </div>
</dspace:layout>
