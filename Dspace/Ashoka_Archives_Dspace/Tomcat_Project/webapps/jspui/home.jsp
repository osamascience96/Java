<%--

    The contents of this file are subject to the license and copyright
    detailed in the LICENSE and NOTICE files at the root of the source
    tree and available online at

    http://www.dspace.org/license/

--%>
<%--
  - Home page JSP
  -
  - Attributes:
  -    communities - Community[] all communities in DSpace
  -    recent.submissions - RecetSubmissions
  --%>

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
<%@ page import="org.dspace.content.Collection" %>
<%@ page import="org.dspace.content.Bitstream" %>
<%@ page import="org.dspace.browse.ItemCounter" %>
<%@ page import="org.dspace.content.Item" %>
<%@ page import="org.dspace.services.ConfigurationService" %>
<%@ page import="org.dspace.services.factory.DSpaceServicesFactory" %>

<%
    List<Community> communities = (List<Community>) request.getAttribute("communities");
	List<Collection> collections = communities.get(0).getCollections();

    Locale sessionLocale = UIUtil.getSessionLocale(request);
    Config.set(request.getSession(), Config.FMT_LOCALE, sessionLocale);
    NewsService newsService = CoreServiceFactory.getInstance().getNewsService();
    String topNews = newsService.readNewsFile(LocaleSupport.getLocalizedMessage(pageContext, "news-top.html"));
    String sideNews = newsService.readNewsFile(LocaleSupport.getLocalizedMessage(pageContext, "news-side.html"));

    ConfigurationService configurationService = DSpaceServicesFactory.getInstance().getConfigurationService();
    
    boolean feedEnabled = configurationService.getBooleanProperty("webui.feed.enable");
    String feedData = "NONE";
    if (feedEnabled)
    {
        // FeedData is expected to be a comma separated list
        String[] formats = configurationService.getArrayProperty("webui.feed.formats");
        String allFormats = StringUtils.join(formats, ",");
        feedData = "ALL:" + allFormats;
    }
    
    ItemCounter ic = new ItemCounter(UIUtil.obtainContext(request));

    RecentSubmissions submissions = (RecentSubmissions) request.getAttribute("recent.submissions");
    ItemService itemService = ContentServiceFactory.getInstance().getItemService();
    CommunityService communityService = ContentServiceFactory.getInstance().getCommunityService();
%>
<style>
	.collection_title{
		background-color:#8B1615!important;
		color:white;
		font-size:14px;
		padding: 2px 5px 2px 5px;
	}

	figure{
		margin: 2px;
	}
</style>
<dspace:layout locbar="nolink" titlekey="jsp.home.title" feedData="<%= feedData %>">
	<div class="row" style="background-color:white;">
		<div class="col-sm-12 col-md-3">
			<div class="container">
				<%-- facebook title --%>
				<h3 style="color:#776853;"><img src="<%=request.getContextPath()%>/image/facebook_icon.png" alt="facebook_ico" width="30" height="30"/> Ashoka on Facebook</h3>
				<hr style="border:2px solid #776853;"/>
				<img src="<%=request.getContextPath()%>/image/test/facebook_test_posts.PNG" width="100%"/>
			</div>
			<div class="container">
				<h3 style="color:#776853;"><img src="<%=request.getContextPath()%>/image/twitter_ico.ico" alt="twitter_ico" width="30" height="30"/> Ashoka on Twitter</h3>
				<hr style="border:2px solid #776853;"/>
				<img src="<%=request.getContextPath()%>/image/test/twitter_test_posts.PNG" width="100%"/>
			</div>
		</div>
		<div class="col-sm-12 col-md-6">
			<div class="jumbotron">
        		<h3 id="content_title" class="text-center">Ashoka Archives of Contemporary India</h3>
				<p id="content_para" class="text-center">
					The Ashoka Archives of Contemporary India was set up in 2017 with a vision to archive and preserve 
					primary soruce material for the study of modern and contemporary history of India with major thrust or
					polity, economy and society. The basic aim was to create a major center for historical and social science
					research in the country.
				</p>
				<p id="content_para" class="text-center">
					Keeping in mind the latest trends in social science research, the main focus of Ashoka Archives is to 
					collect documents related to economic reforms initiated in the 1990s, science and technology
					environment and climate change, women empowerment, social, educational and political developments in
					the country, growth of media in various forms and all other related themes.
				</p>
			</div>

			<div class="jumbotron">
				<div class="row">
					<% for(Collection collection : collections){%>
						<div class="col-md-3">
							<a href="<%=request.getContextPath()%>/handle/<%=collection.getHandle()%>">
								<figure>
									<figcaption class="collection_title"><%=collection.getName()%></figcaption>
									<img src="<%=request.getContextPath()%>/image/test/collections.jpg" width="100%" />
								</figure>
							</a>
						</div>
					<% }%>
				</div>
			</div>
		</div>
		<div class="col-sm-12 col-md-3">
			<div class="container">
				<%-- facebook title --%>
				<h3 style="color:#776853;">Ashoka on Youtube</h3>
				<hr style="border:2px solid #776853;"/>
				<img src="<%=request.getContextPath()%>/image/test/youtube_test_posts.PNG" width="100%"/>
			</div>
			<div class="container">
				<h4 style="background:#8B1615;padding:3px;text-align:center;font-family:none;color:white;">Latest News & Updates</h4>
			</div>
		</div>
	</div>	
</dspace:layout>
