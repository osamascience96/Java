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
    <h1 class="text-center">Copyright</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <ol type="i">
            <h5><li>The Archives shall not have any copyright claims on the papers donated to the Arhives. The Donor and his legal heirs will own the copyright of the papers.</li></h5>
            <h5><li>The Archives shall allow scholars to use the material donated by the donors only for non-commercial research purposes and shall take a written undertaking from the scholars to abide by the access rules of the Archives.</li></h5>
            <h5><li>The Archives shall further take an undertaking in writing from the scholars, who wish to use the archival material for publication/exhibition/films/any other public display, to abide by the copyright rules pertaining to the Collections of Ashoka Archives. The Archives/Donor/Donors will have to be duly acknowledged by the scholars in their study/research projects/publications, etc.</li></h5>
            <h5><li>Copyright rules would apply to duplication of all documents, images, photos, audios, videos, etc.</li></h5>
            <h5><li>Acquisitions purchased with the assistance of grant aid will be held subject to the terms and conditions of bodies from whom such aid has been received.</li></h5>
        </ol>
    </div>
</dspace:layout>
