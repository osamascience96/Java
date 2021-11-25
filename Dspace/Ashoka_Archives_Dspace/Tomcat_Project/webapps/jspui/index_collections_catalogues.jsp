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
</style>

<dspace:layout locbar="nolink" title="Explore Archives" >
    <%@include file="layout/explore_archives_nav.jsp"%>
    <h1 class="text-center">Index of Collections/Catalogues updated as on 21 September 2021</h1>
    <div class="container" style="border:4px solid #e4e4e4; padding:20px;">
        <ol>
            <h4>
                <li>Anand, A. S. (Former Chief Justice of India) (Catalogue Available)</li>
            </h4>
            <h4>
                <li>Bhatt, Chandi Prasad (environmentalist &amp; Chipko movement leader)</li>
            </h4>
            <h4>
                <li>Bidwai, Praful (journalist, political analyst &amp; activist)</li>
            </h4>
            <h4>
                <li>Bindra, Prema Singh (wildlife, conservationist, journalist &amp; writer)</li>
            </h4>
            <h4>
                <li>Chavda, Divyabhanusinh (Wildlife Conservationist) (Catalogue Available)</li>
            </h4>
            <h4>
                <li>Cheetal: Journal of Wildlie (Catalogue Available)</li>
            </h4>
            <h4>
                <li>Dang Hari (Mountaineer, Environmentalist and natural historian)</li>
            </h4>
            <h4>
                <li>Deepak Kumar (Academic)</li>
            </h4>
            <h4>
                <li>Deshpande, M.N (Archaeologist, Art Historian and Conservator) (Catalogue Available)</li>
            </h4>
            <h4>
                <li>Dua, H.K. (Journalist) (Catalogue Available)</li>
            </h4>
            <h4>
                <li>Gandhi, Gopalkrishna (Academic &amp; diplomat) (Catalogue available)</li>
            </h4>
            <h4>
                <li>Haksar, Nandita (Lawyer, human rights activst &amp; writer)</li>
            </h4>
            <h4>
                <li>Harriss-White, Barbara (Academic &amp; political economist)</li>
            </h4>
            <h4>
                <li>Hazard Centre (NGO) (Catalogue available)</li>
            </h4>
            <h4>
                <li>Hiro, Dilip (Author &amp; Journalist)</li>
            </h4>
            <h4>
                <li>Hoot Digital Archive</li>
            </h4>
            <h4>
                <li>Hornbill Journal</li>
            </h4>
            <h4>
                <li>Jayal, Nalni D. (Environmentalist)</li>
            </h4>
            <h4>
                <li>Karanth, K. Ullas (Wildlife conservationist &amp; tiger expert)</li>
            </h4>
            <h4>
                <li>Karnad, Girish(film actor/director &amp; Kannada playwright) (Catalogue available)</li>
            </h4>
            <h4>
                <li>Kohli, Suresh (Poet, writer, translator, editor, liberty critic, filmmaker and film historian)</li>
            </h4>
            <h4>
                <li>Machwe, Prabhakar (Hindi/Marathi/English Writer &amp; poet) (Catalogue available)</li>
            </h4>
            <h4>
                <li>Manorama Jafa Children's Literature Collection</li>
            </h4>
            <h4>
                <li>Mainstream (Current Affairs Weekly, 1962-2020)</li>
            </h4>
            <h4>
                <li>Mehrotra, S.R(historian &amp; author)</li>
            </h4>
            <h4>
                <li>Menon, Ritu(feminist writer &amp; publisher)</li>
            </h4>
            <h4>
                <li>Nagarkar, Kiran (English/Marathi writer &amp; novelist)</li>
            </h4>
            <h4>
                <li>Nayar Kuldip (Journalist &amp; writer) (Catalogue available)</li>
            </h4>
        </ol>
    </div>
</dspace:layout>
